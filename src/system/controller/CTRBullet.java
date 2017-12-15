/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Classe Aprimorada por RUAN GABRIEL G. BARROS - KOULIKOV SYSTEMS
 */
package system.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import system.bean.Bullet;

/**
 *
 * @author Koulikov
 */
public class CTRBullet {

    public ArrayList<Bullet> bulletList = new ArrayList<>();
    public Timer bulletControl = new Timer(30, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Bullet bullet : bulletList) {
                if (bullet.isActivated) {
                    if (bullet.getLocation().y < -9) {
                        bullet.isActivated = false;
                        bullet.setVisible(false);
                        bullet = null;
                    } else {
                        int inerithCx = bullet.inerithX * bulletControl.getDelay() / bullet.inerithY;
                        bullet.setLocation(bullet.getLocation().x - inerithCx, bullet.getLocation().y - bulletControl.getDelay());
                    }
                }
            }
        }
    });
}
