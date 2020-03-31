import javax.swing.*;
import java.awt.*;

class NestedGUIComboBox {

    NestedGUIComboBox() {
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

        // Second column containing the Combo Box
        String[] fontArray = new String[4];
        fontArray[0] = "Times";
        fontArray[1] = "Helvetica";
        fontArray[2] = "Courier";
        fontArray[3] = "Comic Sans";

        // Create a combo box from the font array
        JComboBox<String> fonts = new JComboBox<>(fontArray);
        panel.add(fonts);

        // Third column containing the text field and OK button
        panel.add(textField);
        panel.add(okButton);

        window.pack();
        window.setVisible(true);
    }
}
