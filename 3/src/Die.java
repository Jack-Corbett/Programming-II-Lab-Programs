import javax.swing.*;
import java.awt.*;

class Die extends JPanel {

    private int diceValue = 3;

    public static void main(String args[]) {
        JFrame window = new JFrame("Die Simulator");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container panel = window.getContentPane();
        panel.setLayout(new BorderLayout());

        Die die = new Die();
        panel.add(die, BorderLayout.CENTER);

        window.setSize(300,300);
        window.setResizable(false);
        window.setVisible(true);
    }

    private void updateVal(int i) {
        diceValue = i;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(40,25, 220, 220);
        g.setColor(Color.black);

        if (diceValue == 1 || diceValue == 3 || diceValue == 5) {
            g.fillOval(135, 120,30, 30);
        }

        if (diceValue > 1) {
            g.fillOval(80, 180,30, 30);
            g.fillOval(190, 60,30, 30);
        }

        if (diceValue > 3) {
            g.fillOval(80, 60,30, 30);
            g.fillOval(190, 180,30, 30);
        }

        if (diceValue == 6) {
            g.fillOval(80, 120,30, 30);
            g.fillOval(190, 120,30, 30);
        }
    }
}
