import javax.swing.*;
import java.awt.*;

class FirstGUI {

        FirstGUI() {

            JFrame window = new JFrame("Simple Submit Cancel Form");
            window.setLayout(new FlowLayout());

            window.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
            window.setVisible(true);

            JTextField input = new JTextField(25);

            JButton submitButton = new JButton("Submit");
            JButton cancelButton = new JButton("Cancel");

            window.add(input);
            window.add(submitButton);
            window.add(cancelButton);

            window.setSize(400,100);
        }
}
