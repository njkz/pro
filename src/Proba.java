import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by student on 27.10.2014.
 */
public class Proba extends JComponent {

    private BufferedImage image;

    private Physics physics = new Physics();
    private int dx = 0;

    public Proba() throws IOException {
        setPreferredSize(new Dimension(500, 500));

        image = ImageIO.read(getClass().getResource("sprite.png"));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dx = 1;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    dx = -1;
                }
            }

            public void keyReleased(KeyEvent e) {
                dx = 0;
            }
        });
        new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                physics.update(dx);
                repaint();
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth() / 2 - 200 + physics.getX();
        int y = getHeight() / 2 - 200;
        BufferedImage subimage = image.getSubimage(physics.getCadre() * 102, 0, 102, 150);
        g.drawImage(subimage, x, y, this);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Proba");
        frame.add(new Proba());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
