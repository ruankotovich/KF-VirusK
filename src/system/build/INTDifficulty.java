/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.build;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import javax.swing.JWindow;
import ui.wnd.WNDGameWindow;
import ui.wnd.WNDMainWindow;

/**
 *
 * @author Koulikov
 */
public class INTDifficulty extends JWindow {

    WNDMainWindow caller;

    /**
     * Creates new form INTWarning
     *
     * @param calling
     */
    public INTDifficulty(WNDMainWindow calling) {
        initComponents();
        initWindow();

        this.caller = calling;
    }

    private INTDifficulty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initWindow() {
        jPesteNegra.setVisible(false);
        this.dispose();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void goTo() {
        caller.dispose();
//        caller.backmusic.stop();
        try {
        } catch (Throwable ex) {
            Logger.getLogger(WNDMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPesteNegra = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPesteNegra1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/blood.gif"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 140, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Selecione o nivel de Dificuldade");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 50));

        jPesteNegra.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jPesteNegra);
        jPesteNegra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPesteNegra.setForeground(new java.awt.Color(102, 0, 0));
        jPesteNegra.setText("Atendido no SUS");
        jPesteNegra.setToolTipText("25");
        jPesteNegra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.add(jPesteNegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 230, -1));

        jRadioButton3.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(102, 204, 0));
        jRadioButton3.setText("Criancinha");
        jRadioButton3.setToolTipText("1");
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 320, -1));

        jRadioButton4.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(153, 204, 0));
        jRadioButton4.setText("Brincando de Doente");
        jRadioButton4.setToolTipText("2");
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 320, -1));

        jRadioButton5.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(204, 204, 0));
        jRadioButton5.setText("Alarme Falso");
        jRadioButton5.setToolTipText("3");
        jPanel1.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 320, -1));

        jRadioButton6.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 153, 0));
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Normal");
        jRadioButton6.setToolTipText("4");
        jPanel1.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 320, -1));

        jRadioButton7.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(204, 51, 0));
        jRadioButton7.setText("Patógeno Malígno");
        jRadioButton7.setToolTipText("6");
        jPanel1.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, -1));

        jRadioButton8.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(255, 0, 0));
        jRadioButton8.setText("Endemia");
        jRadioButton8.setToolTipText("8");
        jPanel1.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, -1));

        jRadioButton2.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 0, 51));
        jRadioButton2.setText("Epidemia");
        jRadioButton2.setToolTipText("10");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 320, -1));

        jPesteNegra1.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup1.add(jPesteNegra1);
        jPesteNegra1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPesteNegra1.setForeground(new java.awt.Color(153, 0, 0));
        jPesteNegra1.setText("Pandemia");
        jPesteNegra1.setToolTipText("15");
        jPanel1.add(jPesteNegra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, -1));

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Voltar para a Tela Inicial");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 223, 220, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 255, 51));
        jButton2.setText("Jogar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 220, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        new WNDMainWindow().setVisible(true);
//        this.dispose();
//        try {
//            this.finalize();
//        } catch (Throwable ex) {
//            Logger.getLogger(INTDifficulty.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.dispose();
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(INTDifficulty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        jPesteNegra.setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (Component c : jPesteNegra.getParent().getComponents()) {
            if (c instanceof JRadioButton) {
                if (((JRadioButton) c).isSelected()) {
                    JRadioButton radio = ((JRadioButton) c);
                    new WNDGameWindow(Integer.parseInt(radio.getToolTipText()), caller.backmusic).setVisible(true);
                    this.dispose();
                    caller.backmusic.stop();
                    goTo();
                    try {
                        this.finalize();
                    } catch (Throwable ex) {
                        Logger.getLogger(INTDifficulty.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        System.gc();
        System.runFinalization();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INTDifficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new INTDifficulty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jPesteNegra;
    private javax.swing.JRadioButton jPesteNegra1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    // End of variables declaration//GEN-END:variables
}