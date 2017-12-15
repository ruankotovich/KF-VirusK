/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.controller;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import system.bean.Bullet;
import system.bean.TrapMine;
import system.bean.Virus;
import ui.wnd.WNDGameWindow;

/**
 *
 * @author Koulikov
 */
public class CTRVirus {

    public LinkedList<JLabel> BLOOD;
    public LinkedList<JLabel> FLAME;

    private static final int MAX_BLOOD = 300;

    public ArrayList<Virus> viruslist = new ArrayList<>();
    WNDGameWindow dGameWindow;

    public CTRVirus(WNDGameWindow gameWindow) {
        this.dGameWindow = gameWindow;

        BLOOD = new LinkedList<>();
        FLAME = new LinkedList<>();
        for (int i = 0; i < MAX_BLOOD; i++) {
            JLabel blood = new JLabel(new ImageIcon(CTRVirus.class.getResource("/system/gfx/static/virusblood_" + (new Random().nextInt(3) + 1) + ".png")));
            blood.setSize(30, 30);
            blood.setVisible(true);
            blood.setLocation(-30, -30);
            BLOOD.add(blood);
            gameWindow.jPainelPrincipal.add(blood);
        }

        for (int i = 0; i < MAX_BLOOD; i++) {
            JLabel flame = new JLabel(new ImageIcon(CTRVirus.class.getResource("/system/gfx/flame.gif")));
            flame.setSize(30, 30);
            flame.setVisible(true);
            flame.setLocation(-30, -30);
            FLAME.add(flame);
            gameWindow.jPainelPrincipal.add(flame);
        }

    }

    public JLabel shiftBlood() {
        JLabel next = BLOOD.get(0);
        BLOOD.remove(0);
        BLOOD.add(next);
        return next;
    }

    public JLabel shiftFlame() {
        JLabel next = FLAME.get(0);
        FLAME.remove(0);
        FLAME.add(next);
        return next;
    }

    public Timer virusControl = new Timer(10, new ActionListener() {
        int autokill = 0;

        @Override
        public void actionPerformed(ActionEvent e) {

            for (Virus virus : viruslist) {
                WNDGameWindow wnd = ((WNDGameWindow) virus.caller.getParent().getParent().getParent().getParent().getParent());
                if (!virus.dead) {
                    autokill += 1;
                    if (wnd.isKalashnikov && autokill > 80) {
                        autokill = 0;
                        try {

                            //TIRO AUTOMATICO
//                            new Robot().mouseMove(virus.getX() + virus.getWidth() / 2, virus.getY() + virus.getHeight() / 2);
//                            new Robot().keyPress(KeyEvent.VK_SPACE);
//                            new Robot().keyRelease(KeyEvent.VK_SPACE);
                            //INSTANT KILL
                            new Robot().mouseMove(virus.getX() + virus.getWidth() / 2, virus.getY() + virus.getHeight() / 2);
                            CTRAudio.play("/system/sfx/wpn4.wav");
                            virus.die();
                            dGameWindow.virusAtuales--;
                            wnd.jPBInfection.setValue(wnd.jPBInfection.getValue() - 1);
                        } catch (AWTException ex) {
                            Logger.getLogger(CTRVirus.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (virus.getY() - virus.getHeight() / 2 > virus.caller.getHeight()) {
                        virus.setVisible(false);
                        try {
                            wnd.jPBInfection.setValue(wnd.jPBInfection.getValue() + virus.dificuldade);
                            virus.diews();
                            dGameWindow.virusAtuales--;
                        } catch (Exception ex) {
                        }

                    } else {
                        virus.setLocation(virus.getLocation().x, virus.getLocation().y + new Random().nextInt(2) + 1);
                    }

                    //BULLET
                    ArrayList<Bullet> bullets = new ArrayList<>();
                    for (Component c : virus.caller.getComponents()) {
                        if (c instanceof Bullet) {
                            bullets.add((Bullet) c);
                        }
                    }

                    //MINE
                    ArrayList<TrapMine> trapm = new ArrayList<>();
                    for (Component c : virus.caller.getComponents()) {
                        if (c instanceof TrapMine) {
                            trapm.add((TrapMine) c);
                        }
                    }

                    //FOR BULLETS
                    for (Bullet bull : bullets) {
                        Rectangle bulletCordinate = bull.getBounds();
                        Rectangle thisCordinate = virus.getBounds();
                        if (bulletCordinate.intersects(thisCordinate)) {
                            bull.setVisible(false);
                            bull.setLocation(-10, -10);
                            virus.hp -= bull.damage;

                            if (virus.hp <= 0) {
                                virus.die();
                                dGameWindow.virusAtuales--;
                            } else {
                                shiftBlood().setLocation(virus.getLocation());
                            }

                            try {
                                wnd.jPBInfection.setValue(wnd.jPBInfection.getValue() - 1);
                            } catch (Exception ex) {
                            }
                        }
                    }
                    //END FOR BULLETS

                    //FOR MINES
                    for (TrapMine mine : trapm) {
                        Rectangle trapCordinate = mine.getBounds();
                        Rectangle thisCordinate = virus.getBounds();
                        if (trapCordinate.intersects(thisCordinate)) {
                            JLabel holeLabel = new JLabel(new ImageIcon(this.getClass().getResource("/system/gfx/static/hole.png")));
                            holeLabel.setSize(holeLabel.getIcon().getIconWidth(), holeLabel.getIcon().getIconHeight());
                            int mineX, holeW, mineY, holeH;
                            mineX = mine.getLocation().x + mine.getWidth() / 2;
                            mineY = mine.getLocation().y + mine.getHeight() / 2;
                            holeW = holeLabel.getWidth() / 2;
                            holeH = holeLabel.getHeight() / 2;
                            holeLabel.setLocation(mineX - holeW, mineY - holeH);

//                            JLabel flame = new JLabel(new ImageIcon(this.getClass().getResource("/system/gfx/flame.gif")));
//                            flame.setVisible(true);
//                            flame.setSize(flame.getIcon().getIconWidth(), flame.getIcon().getIconHeight());
//                            flame.setLocation(holeLabel.getLocation().x + 12, holeLabel.getLocation().y + 4);
//                            mine.caller.add(flame);
                            mine.caller.add(holeLabel);

                            holeLabel.setVisible(true);
                            holeLabel.getParent().setComponentZOrder(holeLabel, holeLabel.getParent().getComponentCount() - 1);
                            mine.setVisible(false);
                            mine.setLocation(-10, -10);
                            CTRAudio.play("/system/sfx/explode.wav");
                            virus.die();
                            dGameWindow.virusAtuales--;
                            try {
                                wnd.jPBInfection.setValue(wnd.jPBInfection.getValue() - 1);
                            } catch (Exception ex) {
                            }
                        }
                    }

                    //END FOR MINES
                }
                if ((dGameWindow.virusAdds == dGameWindow.virusMaximus) && (dGameWindow.virusAtuales < dGameWindow.virusMaximus) && (virus.dead)) {
                    if (new Random().nextInt(200) == 199) {
                        virus.dead = false;
                        virus.setLocation(new Random().nextInt(virus.caller.getWidth() - virus.getWidth()) + virus.getWidth(), new Random().nextInt(30));
                        virus.setVisible(true);
                        dGameWindow.virusAtuales++;
                    }
                }
            }

        }
    });

}
