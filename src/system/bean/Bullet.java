/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.bean;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Koulikov
 */
public class Bullet extends JLabel {

    public final Turret caller;
    public int inerithX = 0;
    public int inerithY = 0;
    public int damage = 1;
    public boolean isActivated = true;
    public boolean translated = false;
    public boolean isChloe = false;

    public Bullet(Turret turret, boolean chloe) {
        this.caller = turret;
        this.isChloe = chloe;
        if (isChloe) {
            damage = 100;
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/static/chloe.png")));
        } else {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/static/bullet.png")));
        }
        this.setSize(10, 10);
        this.setLocation(turret.getLocation().x + turret.getSize().width / 2, turret.getLocation().y + turret.getSize().height / 2 - 10);
        this.setVisible(true);
        int inerithXnumb = (int) MouseInfo.getPointerInfo().getLocation().x;

        if (inerithXnumb > caller.getX() + caller.getWidth() / 2) {
            inerithX = (int) ((MouseInfo.getPointerInfo().getLocation().x) - (caller.getX() + caller.getWidth() / 2)) * (-1);
        } else {
            inerithX = (int) ((caller.getX() + caller.getWidth() / 2) - (MouseInfo.getPointerInfo().getLocation().x));
        }
        inerithY = (int) caller.caller.getHeight() - MouseInfo.getPointerInfo().getLocation().y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(caller.rotation, this.getSize().width / 2, this.getSize().height / 2);
        super.paintComponent(g);
    }

}
