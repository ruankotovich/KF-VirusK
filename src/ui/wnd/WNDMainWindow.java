package ui.wnd;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import system.build.INTDifficulty;
import system.build.INTFAjuda;
import system.controller.CTRAudio;
import system.controller.CTRDesktop;

/**
 *
 * @author Koulikov
 */
public class WNDMainWindow extends JFrame implements MouseListener {

    int clickcount = 0;
    /**
     * Creates new form WNDMainWindow
     */

    //BACKGROUND MUSIC
    public AudioClip backmusic = Applet.newAudioClip(this.getClass().getResource("/ui/sfx/bgmusic.wav"));

    public WNDMainWindow() {

        //INICIALIZAÇÃO DE COMPONENTES
        initComponents();
        initWindow();
        this.setIconImage(new ImageIcon(this.getClass().getResource("/ui/gfx/vtp.png")).getImage());
        jPainelCreditos.setVisible(false);
        jPchloe.setVisible(false);
    }

    private void initWindow() {

        //INICIALIZAÇÃO DA JANELA
        this.dispose();
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Virus, a praga - V1.3.1.2 - Beta");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        backmusic.loop();

        //ADD LISTENERS
        jBiniciar.addMouseListener(this);
        jBajuda.addMouseListener(this);
        jBcreditos.addMouseListener(this);
        jBsair.addMouseListener(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jBsair = new javax.swing.JLabel();
        jBiniciar = new javax.swing.JLabel();
        jBcreditos = new javax.swing.JLabel();
        jPainelCreditos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jBajuda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPchloe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBsair.setBackground(new java.awt.Color(204, 0, 51));
        jBsair.setFont(new java.awt.Font("Impact", 1, 45)); // NOI18N
        jBsair.setForeground(new java.awt.Color(255, 255, 255));
        jBsair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/button.png"))); // NOI18N
        jBsair.setText("Sair");
        jBsair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBsair.setOpaque(true);
        jBsair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBsairMouseClicked(evt);
            }
        });
        jLayeredPane1.add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 630, 300, -1));

        jBiniciar.setBackground(new java.awt.Color(0, 102, 51));
        jBiniciar.setFont(new java.awt.Font("Impact", 1, 45)); // NOI18N
        jBiniciar.setForeground(new java.awt.Color(255, 255, 255));
        jBiniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/button.png"))); // NOI18N
        jBiniciar.setText("Iniciar");
        jBiniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBiniciar.setOpaque(true);
        jBiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBiniciarMouseClicked(evt);
            }
        });
        jLayeredPane1.add(jBiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 300, -1));

        jBcreditos.setBackground(new java.awt.Color(102, 0, 51));
        jBcreditos.setFont(new java.awt.Font("Impact", 1, 45)); // NOI18N
        jBcreditos.setForeground(new java.awt.Color(255, 255, 255));
        jBcreditos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBcreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/button.png"))); // NOI18N
        jBcreditos.setText("Créditos");
        jBcreditos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBcreditos.setOpaque(true);
        jBcreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBcreditosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBcreditosMouseEntered(evt);
            }
        });
        jLayeredPane1.add(jBcreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 520, 300, -1));

        jPainelCreditos.setBackground(new java.awt.Color(255, 255, 255));
        jPainelCreditos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Créditos");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Synthetic Wisdom");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("xyahh@synth.wis.ru");

        jButton1.setText("Visitar Site");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Chipset Low Enhancer");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jLabel14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel14KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPainelCreditosLayout = new javax.swing.GroupLayout(jPainelCreditos);
        jPainelCreditos.setLayout(jPainelCreditosLayout);
        jPainelCreditosLayout.setHorizontalGroup(
            jPainelCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPainelCreditosLayout.setVerticalGroup(
            jPainelCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPainelCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 190));

        jBajuda.setBackground(new java.awt.Color(102, 0, 51));
        jBajuda.setFont(new java.awt.Font("Impact", 1, 45)); // NOI18N
        jBajuda.setForeground(new java.awt.Color(255, 255, 255));
        jBajuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/button.png"))); // NOI18N
        jBajuda.setText("Ajuda");
        jBajuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBajuda.setOpaque(true);
        jBajuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBajudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBajudaMouseEntered(evt);
            }
        });
        jLayeredPane1.add(jBajuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 410, 300, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Synthetic Wisdom 2017 - Virus, a praga. c1.3.1.2 (BETA)");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, 860, -1));

        jPchloe.setBackground(new java.awt.Color(0, 0, 0));
        jPchloe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/chloe.jpg"))); // NOI18N

        javax.swing.GroupLayout jPchloeLayout = new javax.swing.GroupLayout(jPchloe);
        jPchloe.setLayout(jPchloeLayout);
        jPchloeLayout.setHorizontalGroup(
            jPchloeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPchloeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPchloeLayout.setVerticalGroup(
            jPchloeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPchloeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPchloe, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 420, 620));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/gfx/viruus.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBcreditosMouseClicked

        //CONTROLE PAINEL DE CRÉDITOS
        if (jPainelCreditos.isVisible()) {
            jPainelCreditos.setVisible(false);
        } else {
            jPainelCreditos.setVisible(true);
        }
    }//GEN-LAST:event_jBcreditosMouseClicked

    private void jBcreditosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBcreditosMouseEntered
    }//GEN-LAST:event_jBcreditosMouseEntered

    private void jBsairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBsairMouseClicked
        //EVENTO DE SAIDA
        System.exit(0);
    }//GEN-LAST:event_jBsairMouseClicked

    private void jBiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBiniciarMouseClicked
        //EVENTO INICIAR
        new INTDifficulty(this).setVisible(true);
    }//GEN-LAST:event_jBiniciarMouseClicked

    private void jBajudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBajudaMouseClicked
        //EVENTO AJUDA
        new INTFAjuda().setVisible(true);
    }//GEN-LAST:event_jBajudaMouseClicked

    private void jBajudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBajudaMouseEntered
    }//GEN-LAST:event_jBajudaMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //EVENTO SITE
        new CTRDesktop().openLink("http://www.google.com.br");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPainelCreditos.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel14KeyPressed
    }//GEN-LAST:event_jLabel14KeyPressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        //EVENTO EASTER EGG CHLOE
        if (clickcount >= 4) {
            if (jPchloe.isVisible()) {
                jPchloe.setVisible(false);
            } else {
                jPchloe.setVisible(true);
            }
        }
        clickcount++;
        switch (clickcount) {
            case 1:
                CTRAudio.play("/system/sfx/count/zp_cnt_1.wav");
                break;
            case 2:
                CTRAudio.play("/system/sfx/count/zp_cnt_2.wav");
                break;
            case 3:
                CTRAudio.play("/system/sfx/count/zp_cnt_3.wav");
                break;
            case 4:
                CTRAudio.play("/system/sfx/count/zp_cnt_4.wav");
                break;
            case 5:
                CTRAudio.play("/system/sfx/count/zp_cnt_5.wav");
                break;

        }
    }//GEN-LAST:event_jLabel14MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WNDMainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBajuda;
    private javax.swing.JLabel jBcreditos;
    private javax.swing.JLabel jBiniciar;
    private javax.swing.JLabel jBsair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPainelCreditos;
    private javax.swing.JPanel jPchloe;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel objeto = ((JLabel) e.getSource());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel objeto = ((JLabel) e.getSource());
        objeto.setBorder(BorderFactory.createLineBorder(Color.orange, 4));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JLabel objeto = ((JLabel) e.getSource());
        objeto.setBorder(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel objeto = ((JLabel) e.getSource());
        objeto.setBorder(BorderFactory.createLineBorder(Color.red, 3));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel objeto = ((JLabel) e.getSource());
        objeto.setBorder(null);
    }
}