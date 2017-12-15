/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Koulikov
 */
public class CTRDesktop {

    public void openLink(String url) {
        try {
            Desktop desktop = null;
//Primeiro verificamos se é possível a integração com o desktop
            if (!Desktop.isDesktopSupported()) {
                throw new IllegalStateException("Desktop resources not supported!");
            }

            desktop = Desktop.getDesktop();
//Agora vemos se é possível disparar o browser default.
            if (!desktop.isSupported(Desktop.Action.BROWSE)) {
                throw new IllegalStateException("No default browser set!");
            }

//Pega a URI de um componente de texto.
            URI uri = new URI(url);
            try {
                //Dispara o browser default, que pode ser o Explorer, Firefox ou outro.
                desktop.browse(uri);
            } catch (IOException ex) {
                Logger.getLogger(CTRDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(CTRDesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
