/* Esse jogo foi feito baseado em caralho nem um, do zero e na raça, essa porra é foda, esse jogo é
 do caralho, seu filho da puta, mentira, é um ПЖД(cú);
 */
package ui.wnd;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import system.bean.Bullet;
import system.bean.TrapMine;
import system.bean.Turret;
import system.bean.Virus;
import system.build.INTFConsole;
import system.build.INTVFusao;
import system.build.INTWarning;
import system.build.INTYouLose;
import system.controller.CTRAudio;
import system.controller.CTRBullet;
import system.controller.CTRVirus;

/**
 *
 * @author Koulikov
 */
public class WNDGameWindow extends javax.swing.JFrame {
// THREADS

    public Timer mainControl;
    public Turret one = new Turret(this);
    public Turret two = new Turret(this);

    //VARIÁVEIS SENTINELAS
    public int vacinas = 3;
    public int minas = 0;
    public int virusMaximus = 0;

    //SENTINELAS DE CONTROLE
    public boolean isShooting = false;
    public boolean isPlayingSound = true;
    public boolean pout = false;
    public boolean czar = false;
    public boolean isDead = false;
    public boolean chloe = false;
    public boolean isKalashnikov = false;

    //SENTINELAS DE INTERAÇÃO
    public AudioClip backm;
    public int virusAtuales = 0;
    public int virusAdds = 0;
    public int pontuacao = 0;
    public int dif = 3;
    public int habpnt = 0;
    public int hability = 1;

    //COMPONENTES SENTINELAS
    public final JLabel jScope = new JLabel(new ImageIcon(this.getClass().getResource("/ui/gfx/scope.png")));

    //CONTROLADORES
    public final CTRVirus cTRVirus;
    public CTRBullet cTRBullet = new CTRBullet();

    /**
     * Creates new form WNDGameWindow
     *
     * @param dificuldade
     * @param clipe
     */
    public WNDGameWindow(int dificuldade, AudioClip clipe) {

        //MÉTODOS INICIAIS
        initComponents();
        cTRVirus = new CTRVirus(this);
        this.pack();
        repaint();
        initWindow();
        initSecondaryComponents();
        initTimer();

        //VARIÁVEIS INICIAIS
        dif = dificuldade;
        backm = clipe;
        minas = 25 - dificuldade;
        virusMaximus = dificuldade * 5;

        //INICIALIZAÇÃO DE COMPONENTES TERCIÁRIOS
        jPainelPrincipal.grabFocus();
        jPainelPerigo.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51, 100), 3));
        jPainelPerigo.setBackground(new Color(255, 102, 0, 100));
        jScope.setVisible(false);
        jPainelStatus.setBackground(new Color(0, 0, 0, 190));
        jTpausado.setBackground(new Color(0, 0, 0, 100));
        jTpausado.setVisible(false);
        jLbVacinas.setText(String.valueOf(vacinas));
        jLbMinas.setText(String.valueOf(minas));
        this.setTitle("Virus, a praga - V1.3.1.2 - Running...");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/ui/gfx/vtp.png")).getImage());

        new INTWarning(this).setVisible(true);
        this.setCursor(this.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));

        //PLANO B
        repaint();
        System.gc();
        System.runFinalization();
    }

    private WNDGameWindow() {
        throw new UnsupportedOperationException("Iniciar sem o MAIN SEU PUTO!");
    }

    private void initTimer() {

        //THREAD PRINCIPAL
        jPainelPrincipal.add(jScope);
//        300 - (dif * 10)
        mainControl = new Timer(10, new ActionListener() {
            int count = 0;
            int countShoot = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                //VARIÁVEIS SENTINELAS
                count += 10;
                countShoot += 10;

                //INICIO DO LAÇO isShooting
                if (isShooting && countShoot >= 100) {
                    if (MouseInfo.getPointerInfo().getLocation().y < JTurretBody1.getX() && MouseInfo.getPointerInfo().getLocation().y < JTurretBody2.getX()) {

                        //INICIO DO LAÇO TIRO
                        if (jPBIntegridade.getString().equals("Pronto!")) {
                            countShoot = 0;
                            CTRAudio.play("/system/sfx/wpn7.wav");
                            Bullet b1;
                            Bullet b2;

                            //EASTER EGG CHLOE
                            if (chloe) {
                                b1 = new Bullet(one, true);
                                b2 = new Bullet(two, true);
                            } else {
                                b1 = new Bullet(one, false);
                                b2 = new Bullet(two, false);
                            }

                            //ADICIONANDO NOVO PROJETIL
                            jPainelPrincipal.add(b1);
                            jPainelPrincipal.add(b2);
                            cTRBullet.bulletList.add(b1);
                            cTRBullet.bulletList.add(b2);

                            //AJUSTANDO PROJÉTIL NA ZOrder
                            b1.getParent().setComponentZOrder(b1, 0);
                            b2.getParent().setComponentZOrder(b2, 0);
                            b1 = null;
                            b2 = null;
                            jPBIntegridade.setValue(jPBIntegridade.getValue() + 15);
                        }
                    }
                }

                if (count >= 300 - (dif * 10)) {
                    //COMEÇO DO LAÇO
                    count = 0;

                    //CONTROLANDO NOVO VÍRUS
                    if (virusAdds < virusMaximus) {
                        addVirus(new Virus(jPainelPrincipal, dif));
                    }
                    //FIM ORDENANDO AS ZOrders
                }

                //DIMINUINDO INTEGRIDADE DA TORRE
                jPBIntegridade.setValue(jPBIntegridade.getValue() - 1);

                //AJUSTANDO SCOPE
                jScope.setVisible(true);
                jScope.setLocation(MouseInfo.getPointerInfo().getLocation().x - jScope.getWidth() / 2, MouseInfo.getPointerInfo().getLocation().y - jScope.getHeight() / 2);

            }
        });

    }

    public void addVirus(Virus viral) {
        viral = new Virus(jPainelPrincipal, dif);
        viral.controller = cTRVirus;
        jPainelPrincipal.add(viral);
        cTRVirus.viruslist.add(viral);

        //ORDENANDO AS ZOrders
        viral.getParent().setComponentZOrder(viral, 4);
        jPainelStatus.getParent().setComponentZOrder(jPainelStatus, 3);
        one.getParent().setComponentZOrder(one, 1);
        two.getParent().setComponentZOrder(two, 2);
        jScope.getParent().setComponentZOrder(jScope, 0);
        virusAdds++;
        virusAtuales++;
    }

    private void initWindow() {
        //INICIALIZAÇÃO DA JANELA

        this.dispose();
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jPainelPrincipal.grabFocus();
    }

    private void initSecondaryComponents() {
        //INCIALIZAÇÃO DE COMPONENTES SECUNDÁRIOS
        jPainelPrincipal.add(one);
        jPainelPrincipal.add(two);
        jScope.setSize(jScope.getIcon().getIconWidth(), jScope.getIcon().getIconHeight());

        //LOCALIZAÇÃO DAS TORRES
        one.setLocation((this.getWidth() / 2 - one.getX() / 2) + 50, this.getPreferredSize().height - one.getHeight() - 45);
        two.setLocation((this.getWidth() / 2 - two.getX() / 2) - 55, this.getPreferredSize().height - two.getHeight() - 45);

        //AJUSTE DAS ZOrders
        jPainelPrincipal.setComponentZOrder(JTurretBody1, 3);
        jPainelPrincipal.setComponentZOrder(JTurretBody2, 2);
        jPainelPrincipal.setComponentZOrder(one, 0);
        jPainelPrincipal.setComponentZOrder(two, 1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelAnalogico = new javax.swing.JLayeredPane();
        jPainelPrincipal = new javax.swing.JLayeredPane();
        JTurretBody1 = new javax.swing.JLabel();
        JTurretBody2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPainelStatus = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTespecialidade = new javax.swing.JLabel();
        jLbVacinas = new javax.swing.JLabel();
        jPBInfection = new javax.swing.JProgressBar();
        jLabel22 = new javax.swing.JLabel();
        jLbPontos2 = new javax.swing.JLabel();
        jPBIntegridade = new javax.swing.JProgressBar();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLbMinas = new javax.swing.JLabel();
        jLbPontos = new javax.swing.JLabel();
        jTpausado = new javax.swing.JLabel();
        jPainelPerigo = new javax.swing.JPanel();
        jLb_LimitR = new javax.swing.JLabel();
        jLb_LimitL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLbBase = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPainelAnalogico.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPainelAnalogico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPainelPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPainelPrincipalMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPainelPrincipalMouseDragged(evt);
            }
        });
        jPainelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPainelPrincipalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPainelPrincipalMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPainelPrincipalMouseClicked(evt);
            }
        });
        jPainelPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPainelPrincipalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPainelPrincipalKeyReleased(evt);
            }
        });

        JTurretBody1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/gfx/body_turret.png"))); // NOI18N

        JTurretBody2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/gfx/body_turret.png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/shield.png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/shield.png"))); // NOI18N

        jPainelStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nível de Infecção : ");

        jTespecialidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTespecialidade.setForeground(new java.awt.Color(255, 255, 255));
        jTespecialidade.setText("Normal/Multi-Patógenos");

        jLbVacinas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLbVacinas.setForeground(new java.awt.Color(255, 255, 255));
        jLbVacinas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbVacinas.setText("<vacinas>");

        jPBInfection.setBackground(new java.awt.Color(204, 255, 204));
        jPBInfection.setForeground(new java.awt.Color(153, 0, 0));
        jPBInfection.setString("Não Infectado");
        jPBInfection.setStringPainted(true);
        jPBInfection.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jPBInfectionStateChanged(evt);
            }
        });
        jPBInfection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPBInfectionPropertyChange(evt);
            }
        });
        jPBInfection.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jPBInfectionVetoableChange(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Pontuação : ");

        jLbPontos2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLbPontos2.setForeground(new java.awt.Color(255, 255, 255));
        jLbPontos2.setText("Especialidade Atual : ");

        jPBIntegridade.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPBIntegridade.setForeground(new Color(0,128,0));
        jPBIntegridade.setMaximum(2000);
        jPBIntegridade.setString("Pronto!");
        jPBIntegridade.setStringPainted(true);
        jPBIntegridade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jPBIntegridadeStateChanged(evt);
            }
        });
        jPBIntegridade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPBIntegridadePropertyChange(evt);
            }
        });
        jPBIntegridade.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jPBIntegridadeVetoableChange(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/sound_on.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Integridade da Torre :");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/mine_icon.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/soro.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLbMinas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLbMinas.setForeground(new java.awt.Color(255, 255, 255));
        jLbMinas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbMinas.setText("<minas>");

        jLbPontos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLbPontos.setForeground(new java.awt.Color(255, 255, 255));
        jLbPontos.setText("0");

        javax.swing.GroupLayout jPainelStatusLayout = new javax.swing.GroupLayout(jPainelStatus);
        jPainelStatus.setLayout(jPainelStatusLayout);
        jPainelStatusLayout.setHorizontalGroup(
            jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelStatusLayout.createSequentialGroup()
                        .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPainelStatusLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel20))
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPBInfection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPBIntegridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPainelStatusLayout.createSequentialGroup()
                        .addComponent(jLbPontos2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTespecialidade)))
                .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelStatusLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLbPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelStatusLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbVacinas)
                            .addComponent(jLbMinas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPainelStatusLayout.setVerticalGroup(
            jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jPBInfection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLbPontos)))
                .addGap(13, 13, 13)
                .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPBIntegridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLbVacinas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbMinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTespecialidade)
                        .addComponent(jLbPontos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTpausado.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTpausado.setForeground(new java.awt.Color(255, 255, 255));
        jTpausado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTpausado.setText("PAUSADO");
        jTpausado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jTpausado.setOpaque(true);

        jPainelPrincipal.setLayer(JTurretBody1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPainelPrincipal.setLayer(JTurretBody2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPainelPrincipal.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPainelPrincipal.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPainelPrincipal.setLayer(jPainelStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPainelPrincipal.setLayer(jTpausado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelPrincipalLayout = new javax.swing.GroupLayout(jPainelPrincipal);
        jPainelPrincipal.setLayout(jPainelPrincipalLayout);
        jPainelPrincipalLayout.setHorizontalGroup(
            jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPainelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPainelPrincipalLayout.createSequentialGroup()
                        .addComponent(JTurretBody2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTurretBody1))
                    .addGroup(jPainelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel26)))
                .addGap(584, 584, 584))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelPrincipalLayout.createSequentialGroup()
                .addComponent(jTpausado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPainelPrincipalLayout.setVerticalGroup(
            jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelPrincipalLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jTpausado, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addGroup(jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPainelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPainelPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTurretBody1))
                        .addGroup(jPainelPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTurretBody2))))
                .addGap(39, 39, 39))
        );

        jPainelAnalogico.add(jPainelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        jPainelPerigo.setBackground(new java.awt.Color(0, 0, 0));
        jPainelPerigo.setPreferredSize(new java.awt.Dimension(1360, 2));

        javax.swing.GroupLayout jPainelPerigoLayout = new javax.swing.GroupLayout(jPainelPerigo);
        jPainelPerigo.setLayout(jPainelPerigoLayout);
        jPainelPerigoLayout.setHorizontalGroup(
            jPainelPerigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPainelPerigoLayout.setVerticalGroup(
            jPainelPerigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPainelAnalogico.add(jPainelPerigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1370, 130));

        jLb_LimitR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/limit_right.png"))); // NOI18N
        jPainelAnalogico.add(jLb_LimitR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 770));

        jLb_LimitL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/limit_left.png"))); // NOI18N
        jPainelAnalogico.add(jLb_LimitL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 770));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 300, 300, -1));

        jLbBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/base.png"))); // NOI18N
        jPainelAnalogico.add(jLbBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 700, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 470, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, 310, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/gfx/static/floor.png"))); // NOI18N
        jPainelAnalogico.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelAnalogico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelAnalogico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPainelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPainelPrincipalMouseClicked
    }//GEN-LAST:event_jPainelPrincipalMouseClicked

    private void jPainelPrincipalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPainelPrincipalMouseReleased
        //PARA DE ATIRAR
        isShooting = false;
    }//GEN-LAST:event_jPainelPrincipalMouseReleased

    private void jPainelPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPainelPrincipalMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1) {
//COMEÇA A ATIRAR
            isShooting = true;
        } else if (evt.getButton() == MouseEvent.BUTTON3) {

            //EVENTO DO SORO DE FUSÃO
            if (vacinas > 0) {
                vacinas--;
                jLbVacinas.setText(String.valueOf(vacinas));
                for (Virus v : cTRVirus.viruslist) {
                    v.die();
                    virusAtuales--;
                }
                new INTVFusao().setVisible(true);
            }

        } else if (evt.getButton() == MouseEvent.BUTTON2) {

            //EVENTO DAS MINAS
            if (minas > 0) {
                minas--;
                jLbMinas.setText(String.valueOf(minas));
                TrapMine mina = new TrapMine(jPainelPrincipal, evt.getLocationOnScreen());
                jPainelPrincipal.add(mina);
                mina.getParent().setComponentZOrder(mina, 4);
            }
        }
    }//GEN-LAST:event_jPainelPrincipalMousePressed

    private void jPainelPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPainelPrincipalMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPainelPrincipalMouseDragged

    private void jPainelPrincipalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPainelPrincipalMouseMoved
    }//GEN-LAST:event_jPainelPrincipalMouseMoved

    private void jPBInfectionVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jPBInfectionVetoableChange
    }//GEN-LAST:event_jPBInfectionVetoableChange

    private void jPBInfectionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPBInfectionPropertyChange
    }//GEN-LAST:event_jPBInfectionPropertyChange

    private void jPBInfectionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jPBInfectionStateChanged

        //CONTROLE DA BARRA DE INFECÇÃO
        int value = jPBInfection.getValue();
        if (value == (int) jPBInfection.getMaximum() * 0.95) {
            jPBInfection.setString("Morte Iminente!!!");
        } else if (value >= jPBInfection.getMaximum() * 0.9) {
            jPBInfection.setString("Risco de Morte!!");
        } else if (value >= (int) jPBInfection.getMaximum() * 0.8) {
            jPBInfection.setString("Caso Grave!");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.7) {
            jPBInfection.setString("Moribundo");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.6) {
            jPBInfection.setString("Pestilento");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.5) {
            jPBInfection.setString("Infectado");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.4) {
            jPBInfection.setString("Infeccção Moderada");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.3) {
            jPBInfection.setString("Infecção Leve");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.2) {
            jPBInfection.setString("Infecção Imperceptível");

        } else if (value >= (int) jPBInfection.getMaximum() * 0.1) {
            jPBInfection.setString("Risco de Infecção");

        } else if (value < (int) jPBInfection.getMaximum() * 0.1) {
            jPBInfection.setString("Sadio");

        }
        if (jPBInfection.getValue() >= jPBInfection.getMaximum()) {
            death();
        }

    }//GEN-LAST:event_jPBInfectionStateChanged

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked

        //CONTROLE DA BACKGROUND MUSIC
        if (isPlayingSound) {
            isPlayingSound = false;
            jLabel21.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/static/sound_off.png")));
            backm.stop();
        } else {
            isPlayingSound = true;
            jLabel21.setIcon(new ImageIcon(this.getClass().getResource("/system/gfx/static/sound_on.png")));
            backm.loop();
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jPainelPrincipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPainelPrincipalKeyPressed

        //CONTROLE DOS EVENTOS DE TECLADO
        //ABRIR O CONSOLE
        if (evt.getKeyCode() == KeyEvent.VK_QUOTE) {
            new INTFConsole(this).setVisible(true);
        }

        //ATIRAR
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            isShooting = true;
        }

        //ACOPLAR MINA
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
            try {
                new Robot().mousePress(InputEvent.BUTTON2_MASK);
                new Robot().mouseRelease(InputEvent.BUTTON2_MASK);
            } catch (AWTException ex) {
                Logger.getLogger(WNDGameWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //PAUSAR O JOGO
        if (evt.getKeyCode() == KeyEvent.VK_P) {
            jTpausado.getParent().setComponentZOrder(jTpausado, 0);
            if (jTpausado.isVisible()) {
                jTpausado.setVisible(false);
                cTRBullet.bulletControl.start();
                cTRVirus.virusControl.start();
                this.mainControl.start();
            } else {
                jTpausado.setVisible(true);
                cTRBullet.bulletControl.stop();
                cTRVirus.virusControl.stop();
                this.mainControl.stop();
            }
        }

        //PLANO B
        repaint();
    }//GEN-LAST:event_jPainelPrincipalKeyPressed

    private void jPBIntegridadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jPBIntegridadeStateChanged

//CONTROLE DA INTEGRIDADE DA TORRE
        if (jPBIntegridade.getValue() >= jPBIntegridade.getMaximum()) {
            jPBIntegridade.setString("Torre Danificada");
            AudioClip fadeout = Applet.newAudioClip(this.getClass().getResource("/system/sfx/wpnfadeout.wav"));
            fadeout.play();
            jPBIntegridade.setForeground(Color.RED);
        } else if (jPBIntegridade.getValue() <= (int) jPBIntegridade.getMaximum() * 0.8) {
            jPBIntegridade.setForeground(new Color(0, 128, 0));
            jPBIntegridade.setString("Pronto!");
        }
    }//GEN-LAST:event_jPBIntegridadeStateChanged

    private void jPBIntegridadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPBIntegridadePropertyChange
    }//GEN-LAST:event_jPBIntegridadePropertyChange

    private void jPBIntegridadeVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jPBIntegridadeVetoableChange
    }//GEN-LAST:event_jPBIntegridadeVetoableChange

    private void jPainelPrincipalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPainelPrincipalKeyReleased
//CONTROLE DE TIRO

        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            isShooting = false;
        }
    }//GEN-LAST:event_jPainelPrincipalKeyReleased

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void death() {

        //CONTROLE DA MORTE
        jPBInfection.setString("Mais do que Morto.");
        if (isDead == false) {
            isDead = true;
            new INTYouLose(this).setVisible(true);
        }
        isShooting = false;
        mainControl.stop();
        cTRVirus.virusControl.stop();
        cTRBullet.bulletControl.stop();
        backm.stop();
        this.dispose();
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(WNDGameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WNDGameWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTurretBody1;
    private javax.swing.JLabel JTurretBody2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbBase;
    public javax.swing.JLabel jLbMinas;
    public javax.swing.JLabel jLbPontos;
    public javax.swing.JLabel jLbPontos2;
    public javax.swing.JLabel jLbVacinas;
    private javax.swing.JLabel jLb_LimitL;
    private javax.swing.JLabel jLb_LimitR;
    public javax.swing.JProgressBar jPBInfection;
    public javax.swing.JProgressBar jPBIntegridade;
    public javax.swing.JLayeredPane jPainelAnalogico;
    private javax.swing.JPanel jPainelPerigo;
    public javax.swing.JLayeredPane jPainelPrincipal;
    public javax.swing.JPanel jPainelStatus;
    public javax.swing.JLabel jTespecialidade;
    private javax.swing.JLabel jTpausado;
    // End of variables declaration//GEN-END:variables
}
