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
    private int cadre = 0;

    public Proba() throws IOException {
        setPreferredSize(new Dimension(500, 500));

        image = ImageIO.read(getClass().getResource("sprite.png"));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    cadre = (cadre + 1) % 6;
                    repaint();
                }
            }
        });
//        new Timer(100, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cadre = (cadre + 1) % 6;
//                repaint();
//            }
//        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth() / 2 - 200;
        int y = getHeight() / 2 - 200;
        BufferedImage subimage = image.getSubimage(cadre * 102, 0, 102, 150);
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
