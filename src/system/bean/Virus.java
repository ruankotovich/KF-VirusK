/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.bean;

import java.awt.Container;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import system.build.INTVArma;
import system.build.INTVMine;
import system.build.INTVSoro;
import system.controller.CTRAudio;
import system.controller.CTRVirus;
import ui.wnd.WNDGameWindow;

/**
 *
 * @author Koulikov
 */
public class Virus extends JLabel {

    public int dificuldade = 3;
    public boolean dead = false;
    public int hp = 1;
    public String type = "SV";
    public int thaHp = 1;
    public Container caller;
    public CTRVirus controller;
//    public AudioClip died = Applet.newAudioClip(this.getClass().getResource("/system/sfx/virus_die.wav"));

    public Virus(Container calling, int dif) {
        this.dificuldade = dif;
        this.caller = calling;

        if (new Random().nextInt((int) 200 / dificuldade) == 0) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_f3_w.gif")));
            hp += 10;
            thaHp += 10;
            type = "EI"; //Encapsulado Incancescente
        } else if (new Random().nextInt((int) 140 / dificuldade) == 0) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_f2_w.gif")));
            hp += 8;
            thaHp += 8;
            type = "EM"; //Encapsulado Malígno

        } else if (new Random().nextInt((int) 120 / dificuldade) == 0) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_f_w.gif")));
            hp += 6;
            thaHp += 6;
            type = "EN"; //Encapsulado Normal
        } else if (new Random().nextInt((int) 100 / dificuldade) == 0) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_o_w.gif")));
            hp += 4;
            thaHp += 4;
            type = "MF"; //Mutação Fortificada
        } else if (new Random().nextInt((int) 80 / dificuldade) == 0) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_i_w.gif")));
            hp += 2;
            thaHp += 2;
            type = "MN"; //Mutação Normal
        } else if (((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).pout) {
            if (new Random().nextInt((int) 50 / dificuldade) == 0) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_b_w.gif")));
                hp += 10;
                thaHp += 10;
                type = "SP"; //SPONTANEOUS POUT
            } else {
                this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_w.gif")));

            }
        } else if (((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).czar) {
            if (new Random().nextInt((int) 50 / dificuldade) == 0) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_czar.gif")));
                hp += 10;
                thaHp += 10;
                type = "CZ"; //CZAR
            } else {
                this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_w.gif")));

            }
        } else {
            this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/virus_w.gif")));
        }

        this.setSize(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
        this.setLocation(new Random().nextInt(caller.getWidth() - this.getWidth()) + this.getWidth(), 0);
        this.setVisible(true);
    }

    public void die() {
        if(this.type != "EI"){
            controller.shiftBlood().setLocation(this.getLocation());
        }else{
            controller.shiftFlame().setLocation(this.getLocation());
        }
        CTRAudio.play("/system/sfx/virus_die.wav");
        WNDGameWindow wnd = ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent());

        wnd.pontuacao += ((int) (dificuldade) / 2) + thaHp;
        wnd.jLbPontos.setText(String.valueOf(wnd.pontuacao));
        setVisible(false);
        dead = true;
        if (new Random().nextInt(dificuldade * 200) == 24) {
            new INTVSoro().setVisible(true);
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).vacinas++;
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).jLbVacinas.setText(String.valueOf(((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).vacinas));
        }

        if (new Random().nextInt(dificuldade * 30) == 24) {
            new INTVArma().setVisible(true);
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).jPBIntegridade.setValue(0);
        }

        if (new Random().nextInt(dificuldade * 24) == 24) {
            new INTVMine().setVisible(true);
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).minas++;
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).jLbMinas.setText(String.valueOf(((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).minas));
        }
    }

    public void diews() {
        setVisible(false);
        dead = true;
        if (new Random().nextInt(dificuldade * 80) == 24) {
            new INTVSoro().setVisible(true);
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).vacinas++;
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).jLbVacinas.setText(String.valueOf(((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).vacinas));
        }

        if (new Random().nextInt(dificuldade * 20) == 24) {
            new INTVArma().setVisible(true);
            ((WNDGameWindow) caller.getParent().getParent().getParent().getParent().getParent()).jPBIntegridade.setValue(0);
        }

        System.gc();
        System.runFinalization();
    }
}
