/*/
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.bean;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Koulikov
 */
public class Turret extends JLabel {

    public final Container caller;
    public double rotation = 0;
    Timer t;

    public Turret(Container calling) {
        this.caller = calling;
        this.setSize(new Rectangle(50, 50).getSize());
        this.setIcon(new ImageIcon(this.getClass().getResource("/ui/gfx/turret.png")));

        t = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                float centerX = getX() + getWidth() / 2;
                float centerY = getY() + getHeight() / 2;
                float radiansToMouse = (float) Math.atan2(centerX - MouseInfo.getPointerInfo().getLocation().getX(), centerY - MouseInfo.getPointerInfo().getLocation().getY());
                float degreesToMouse = (57.2957795f * radiansToMouse) * -1;
                rotation = degreesToMouse;
                repaint();
            }
        });
        t.start();
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.toRadians(rotation), this.getSize().width / 2, this.getSize().height / 2);
        super.paintComponent(g);
    }

}
