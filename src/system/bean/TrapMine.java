/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.bean;

import java.awt.Container;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import system.controller.CTRAudio;

/**
 *
 * @author Koulikov
 */
public class TrapMine extends JLabel {

    public Container caller;

    public TrapMine(Container calling, Point location) {
        this.caller = calling;
        this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/trap_mine.gif")));
        this.setSize(this.getIcon().getIconHeight(), this.getIcon().getIconWidth());
        int thaX, thaY;
        thaX = location.x - this.getWidth() / 2;
        thaY = location.y - this.getHeight() / 2;
        this.setLocation(thaX, thaY);
        this.setVisible(true);
        repaint();
        CTRAudio.play("/system/sfx/trap_mine.wav");
    }

    public TrapMine(Container calling, Point location, boolean toNoSound) {
        this.caller = calling;
        this.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/trap_mine.gif")));
        this.setSize(this.getIcon().getIconHeight(), this.getIcon().getIconWidth());
        int thaX, thaY;
        thaX = location.x - this.getWidth() / 2;
        thaY = location.y - this.getHeight() / 2;
        this.setLocation(thaX, thaY);
        this.setVisible(true);
        repaint();
    }
}
