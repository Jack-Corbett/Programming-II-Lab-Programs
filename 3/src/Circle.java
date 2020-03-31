import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Circle extends JPanel {

    private Color colour;

    public static void main(String args[]) {
        JFrame window = new JFrame("Circle Clicker");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container panel = window.getContentPane();

        Circle circle = new Circle();
        panel.add(circle);

        window.setSize(300,300);
        window.setVisible(true);
    }

    private Circle() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random random = new Random();
                float red = random.nextFloat();
                float green = random.nextFloat();
                float blue = random.nextFloat();
                colour = new Color(red, green, blue);
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setForeground(colour);
        g.fillOval(10,10, 250, 250);
    }
}
