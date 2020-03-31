import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Mouse {

    Mouse() {
        // Set up window
        JFrame window = new JFrame("Mouse Position");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setLayout(new BorderLayout());

        JPanel boxes = new JPanel(null);

        JLabel output = new JLabel();
        output.setText("Coordinate: ");

        MouseMotionListener movementListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JPanel panel = (JPanel) e.getSource();
                Point coordinate = new Point(e.getPoint());
                panel.setLocation(coordinate);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point coordinate = new Point(e.getPoint());
                output.setText("Coordinate: (" + (coordinate.x ) + ", " + (coordinate.y) + ")");
            }
        };



        JPanel panel1 = new JPanel();
        panel1.setBounds(200,0, 100, 300);
        panel1.setBackground(Color.BLUE);
        panel1.addMouseMotionListener(movementListener);
        boxes.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0,0, 200, 100);
        panel2.setBackground(Color.GREEN);
        panel2.addMouseMotionListener(movementListener);
        boxes.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBounds(0,100, 100, 300);
        panel3.setBackground(Color.RED);
        panel3.addMouseMotionListener(movementListener);
        boxes.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBounds(300,0, 200, 400);
        panel4.setBackground(Color.ORANGE);
        panel4.addMouseMotionListener(movementListener);
        boxes.add(panel4);

        window.add(boxes, BorderLayout.CENTER);
        window.add(output, BorderLayout.SOUTH);

        window.pack();
        window.setSize(500,450);
        window.setVisible(true);
    }
}
