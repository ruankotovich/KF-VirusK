/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.build;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import system.bean.TrapMine;
import system.controller.CTRAudio;
import ui.wnd.WNDGameWindow;

/**
 *
 * @author Koulikov
 */
public class INTFConsole extends JFrame {

    int count = 0;
    Timer t;
    WNDGameWindow dGameWindow;

    /**
     * Creates new form INTWarning
     *
     * @param gameWnd
     */
    private void verificarComando() {
        String comando = jTextField1.getText().toLowerCase();

        switch (comando) {
            case "cls":
                jTextArea1.setText("");
                break;

            case "close":
                jButton1.doClick();
                break;

            case "sys.exit":
                System.exit(0);
                break;

            case "gs.karma":
                dGameWindow.vacinas += 5;
                dGameWindow.jLbVacinas.setText(String.valueOf(dGameWindow.vacinas));
                jTextArea1.setText(jTextArea1.getText() + "\nAdquiriu 5 soros de fusão.");
                break;

            case "chloe":
                dGameWindow.jPBInfection.setMaximum(dGameWindow.jPBInfection.getMaximum() * 2);
                jTextArea1.setText(jTextArea1.getText() + "\nResistência máxima dobrada!\nAnterior : " + (dGameWindow.jPBInfection.getMaximum() / 20) + "% Atual : " + (dGameWindow.jPBInfection.getMaximum() / 10) + "%");
                break;

            case "grace":
                dGameWindow.jPBInfection.setMaximum(dGameWindow.jPBInfection.getMaximum() * 3);
                jTextArea1.setText(jTextArea1.getText() + "\nResistência máxima triplicada!\nAnterior : " + (dGameWindow.jPBInfection.getMaximum() / 30) + "% Atual : " + (dGameWindow.jPBInfection.getMaximum() / 10) + "%");
                break;

            case "gs.czar":
                if (dGameWindow.czar) {
                jTextArea1.setText(jTextArea1.getText() + "\nAiiin Vlw Flw");
                dGameWindow.czar = false;
            } else {
                jTextArea1.setText(jTextArea1.getText() + "\nAiiiin Aiiin");
                dGameWindow.czar = true;
            }

                break;

            case "gs.spontaneouspout":
                if (dGameWindow.pout) {
                jTextArea1.setText(jTextArea1.getText() + "\n2GB de memória RAM recuperados com a exclusão dos lábios gigantes");
                dGameWindow.pout = false;
            } else {
                jTextArea1.setText(jTextArea1.getText() + "\n2GB de memória RAM só pros lábios gigantes");
                dGameWindow.pout = true;
            }

                break;

            case "moretz":
                dGameWindow.jPBInfection.setMaximum(dGameWindow.jPBInfection.getMaximum() * 4);
                jTextArea1.setText(jTextArea1.getText() + "\nResistência máxima quadruplicada!\nAnterior : " + (dGameWindow.jPBInfection.getMaximum() / 40) + "% Atual : " + (dGameWindow.jPBInfection.getMaximum() / 10) + "%");
                break;

            case "gs.urss":
                if (dGameWindow.chloe) {
                dGameWindow.chloe = false;
                jTextArea1.setText(jTextArea1.getText() + "\n Projétil alterado para Normal/Multi-Patógenos.");
                dGameWindow.jTespecialidade.setText("Normal/Multi-Patógenos");
            } else {
                dGameWindow.chloe = true;
                jTextArea1.setText(jTextArea1.getText() + "\n Projétil alterado para Chloe (Chipset Low Enhancer).");
                dGameWindow.jTespecialidade.setText("Chloe (Chipset Low Enhancer)");
            }
                break;

            case "gs.anapple":
                dGameWindow.jPBInfection.setValue(0);
                jTextArea1.setText(jTextArea1.getText() + "\n Se sentindo muito melhor...");
                break;

            case "gs.hitman":
                dGameWindow.jPBIntegridade.setMaximum(dGameWindow.jPBIntegridade.getMaximum() * 2);
                jTextArea1.setText(jTextArea1.getText() + "\nIntegridade da arma dobrada!\nAnterior :" + (dGameWindow.jPBIntegridade.getMaximum() / 20) + " Atual : " + (dGameWindow.jPBIntegridade.getMaximum() / 10) + "");
                break;

            case "gs.irecordnothing":
                dGameWindow.jPBInfection.setValue(dGameWindow.jPBInfection.getMaximum());
                this.dispose();
                try {
                    this.finalize();
                    System.gc();
                } catch (Throwable ex) {
                    Logger.getLogger(INTFConsole.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "gs.kalashnikov":
                if (dGameWindow.isKalashnikov) {
                dGameWindow.isKalashnikov = false;
                dGameWindow.one.setIcon(new ImageIcon(this.getClass().getResource("/ui/gfx/turret.png")));
                dGameWindow.two.setIcon(new ImageIcon(this.getClass().getResource("/ui/gfx/turret.png")));
                jTextArea1.setText(jTextArea1.getText() + "\n Os Soldados Russos Foram Dispensados...");
            } else {
                dGameWindow.isKalashnikov = true;
                dGameWindow.one.setIcon(new ImageIcon(this.getClass().getResource("/ui/gfx/russian.png")));
                dGameWindow.two.setIcon(new ImageIcon(this.getClass().getResource("/ui/gfx/russian.png")));
                jTextArea1.setText(jTextArea1.getText() + "\n Os Soldados Russos Foram Recrutados!");
            }
                break;

            case "gs.fluoruracila":
                dGameWindow.minas += 1000;
                dGameWindow.jLbMinas.setText(String.valueOf(dGameWindow.minas));
                jTextArea1.setText(jTextArea1.getText() + "\nContra o câncer!");
                break;

            case "gs.partyhard":
                for (int i = 1; i <= 40; i++) {
                int locationX = new Random().nextInt(Toolkit.getDefaultToolkit().getScreenSize().width - 10) + 10;
                int locationY = new Random().nextInt(Toolkit.getDefaultToolkit().getScreenSize().height - 10) + 10;
                dGameWindow.jPainelPrincipal.add(new TrapMine(dGameWindow.jPainelPrincipal, new Point(locationX, locationY), false));

            }
                jTextArea1.setText(jTextArea1.getText() + "\n Tuts Tuts Tuts Tuts!");
                CTRAudio.play("/system/sfx/thats_the_way.wav");
                break;

            default:
                jTextArea1.setText(jTextArea1.getText() + "\nErro : comando não encontrado.");
                break;
        }
        jTextField1.setText("");
        jTextField1.grabFocus();
        System.gc();
        System.runFinalization();

    }

    public INTFConsole(WNDGameWindow gameWnd) {
        this.dGameWindow = gameWnd;
        dGameWindow.mainControl.stop();
        dGameWindow.cTRBullet.bulletControl.stop();
        dGameWindow.cTRVirus.virusControl.stop();
        initComponents();
        initWindow();
    }

    private INTFConsole() {
        initComponents();
        initWindow();
    }

    private void initWindow() {
        this.dispose();
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize(this.jPanel1.getSize());
        this.setLocation(this.getLocation().x, 0);
        this.setTitle(jLabel1.getText());
        jTextField1.grabFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                INTFConsole.this.windowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(0, 204, 0));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSOLE FIRMWARE 1.5");

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(">");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        dGameWindow.mainControl.start();
        dGameWindow.cTRBullet.bulletControl.start();
        dGameWindow.cTRVirus.virusControl.start();
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(INTFConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.gc();
        System.runFinalization();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            verificarComando();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void windowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosed
    }//GEN-LAST:event_windowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        jButton1.doClick();
    }//GEN-LAST:event_formWindowClosing

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_QUOTE) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new INTFConsole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
