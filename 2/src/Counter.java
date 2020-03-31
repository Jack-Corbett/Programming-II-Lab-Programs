import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Counter {

    private Integer count = 0;
    private JTextField display = new JTextField(15);

    Counter() {
        JFrame window = new JFrame("Counter");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        display.setText(Integer.toString(count));

        JButton increment = new JButton("Increment");

        ActionListener incrementListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                display.setText(Integer.toString(count));
            }
        };

        increment.addActionListener(incrementListener);

        JButton reset = new JButton("Reset");

        ActionListener resetListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count = 0;
                display.setText(Integer.toString(count));
            }
        };

        reset.addActionListener(resetListener);

        Container panel = window.getContentPane();
        panel.setLayout(new BorderLayout());

        JPanel buttons = new JPanel(new GridLayout(2, 1));
        buttons.add(increment);
        buttons.add(reset);
        panel.add(buttons, BorderLayout.WEST);

        panel.add(display, BorderLayout.CENTER);

        window.pack();
        window.setVisible(true);
    }
}
