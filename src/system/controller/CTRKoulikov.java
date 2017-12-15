/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import system.build.INTKoulikov;
import ui.wnd.WNDMainWindow;

/**
 *
 * @author Koulikov
 */
public class CTRKoulikov {

    public CTRKoulikov() {
        restore();
    }

    public static void main(String[] args) {
        restore();
    }

    public static void restore() {
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension compativel = new Dimension(1366, 768);
        if (!compativel.equals(tela)) {
            new INTKoulikov().setVisible(true);
        } else {
            new WNDMainWindow().setVisible(true);
        }
    }

}
