import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Clock extends JPanel {

    private BufferedImage image;
    private Integer hourRotation = 0;
    private Integer minuteRotation = 0;

    private Clock() {
        try {
            image = ImageIO.read(new File("clockFace.png"));
        } catch (IOException e) {
            System.err.println("Failed to read file");
        }
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel);
    }

    public static void main(String args[]) {
        JFrame window = new JFrame("Clock Simulator");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container panel = window.getContentPane();
        panel.setLayout(new BorderLayout());
        Clock clock = new Clock();
        panel.add(clock, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JLabel separator = new JLabel(" : ");
        JSpinner hour = new JSpinner(new SpinnerNumberModel(0, 0, 11, 1));
        hour.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                clock.hourRotation = ((Integer) hour.getValue() * 30);
                clock.repaint();
            }
        });

        JSpinner minute = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        minute.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                clock.minuteRotation = ((Integer) minute.getValue() * 6);
                clock.repaint();
            }}
        );

        controls.add(hour);
        controls.add(separator);
        controls.add(minute);
        panel.add(controls, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // Hour
        Line2D hour = new Line2D.Double(305, 305, 305, 150);
        g2.setStroke(new BasicStroke(8));
        g2.setColor(Color.black);

        AffineTransform atH =
                AffineTransform.getRotateInstance(
                        Math.toRadians(hourRotation), hour.getX1(), hour.getY1());

        // Draw the rotated line
        g2.draw(atH.createTransformedShape(hour));

        // Minutes
        Line2D minute = new Line2D.Double(305, 305, 305, 80);
        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.red);

        AffineTransform atM =
                AffineTransform.getRotateInstance(
                        Math.toRadians(minuteRotation), minute.getX1(), minute.getY1());

        // Draw the rotated line
        g2.draw(atM.createTransformedShape(minute));
    }

}
