import javax.swing.*;
import java.awt.*;

class NestedGUI {

    NestedGUI() {

        // Set up window
        JFrame window = new JFrame("Font Chooser");
        window.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        // Create objects
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");

        JRadioButton times = new JRadioButton("Times", true);
        JRadioButton helvetica = new JRadioButton("Helvetica", false);
        JRadioButton courier = new JRadioButton("Courier", false);

        JTextField textField = new JTextField(25);

        JButton okButton = new JButton("OK");

        // Add the objects to the window
        Container panel = window.getContentPane();
        panel.setLayout(new FlowLayout());

        // First column containing check boxes
        JPanel checkBoxes = new JPanel();
        checkBoxes.setLayout(new GridLayout(2,1));
        checkBoxes.add(bold);
        checkBoxes.add(italic);

        panel.add(checkBoxes);

        // Second column containing radio buttons
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new GridLayout(3,1));

        ButtonGroup fonts = new ButtonGroup();
        fonts.add(times);
        fonts.add(helvetica);
        fonts.add(courier);

        radioButtons.add(times);
        radioButtons.add(helvetica);
        radioButtons.add(courier);

        panel.add(radioButtons);

        // Third column containing the text field and OK button
        panel.add(textField);
        panel.add(okButton);

        window.pack();
        window.setVisible(true);
    }
}
