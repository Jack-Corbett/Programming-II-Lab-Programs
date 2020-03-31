import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class FontSelector {

    private boolean isBold;
    private boolean isItalic;

    FontSelector() {
        // Set up window
        JFrame window = new JFrame("Font Chooser");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(25);

        // Create objects
        JCheckBox bold = new JCheckBox("Bold");

        // Example using an Item Listener to check if the checkboxes state has changed
        class fontBold implements ItemListener {

            @Override
            public void itemStateChanged(ItemEvent e) {
                isBold = textField.getFont().isBold();
                isItalic = textField.getFont().isItalic();

                if (isBold && isItalic) {
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
                } else if (isItalic) {
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC + Font.BOLD));
                } else if (isBold) {
                    textField.setFont(textField.getFont().deriveFont(Font.PLAIN));
                } else {
                    textField.setFont(textField.getFont().deriveFont(Font.BOLD));
                }
            }
        };

        bold.addItemListener(new fontBold());

        JCheckBox italic = new JCheckBox("Italic");

        // Example using an action listener to check if the checkboxes state has changed
        ActionListener fontItalic = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isBold = textField.getFont().isBold();
                boolean isItalic = textField.getFont().isItalic();

                if (isBold && isItalic) {
                    textField.setFont(textField.getFont().deriveFont(Font.BOLD));
                } else if (isBold) {
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC + Font.BOLD));
                } else if (isItalic) {
                    textField.setFont(textField.getFont().deriveFont(Font.PLAIN));
                } else {
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
                }
            }
        };

        italic.addActionListener(fontItalic);


        JRadioButton times = new JRadioButton("Times", true);
        JRadioButton helvetica = new JRadioButton("Helvetica", false);
        JRadioButton courier = new JRadioButton("Courier", false);

        textField.setFont(new Font("Times", Font.PLAIN, 14));
        textField.setText(times.getText());

        ActionListener fontChange = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AbstractButton button = (AbstractButton) e.getSource();

                isBold = textField.getFont().isBold();
                isItalic = textField.getFont().isItalic();

                textField.setFont(new Font(button.getText(), Font.PLAIN, 14));

                if (isBold && isItalic) {
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC + Font.BOLD));
                } else if (isItalic) {
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
                } else if (isBold) {
                    textField.setFont(textField.getFont().deriveFont(Font.BOLD));
                }

                textField.setText(button.getText());
            }
        };

        times.addActionListener(fontChange);
        helvetica.addActionListener(fontChange);
        courier.addActionListener(fontChange);

        JButton okButton = new JButton("OK");

        ActionListener okPressed = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
                System.exit(0);
            }
        };

        okButton.addActionListener(okPressed);

        // Add the objects to the window
        Container panel = window.getContentPane();
        panel.setLayout(new FlowLayout());

        // First column containing check boxes
        JPanel checkBoxes = new JPanel();
        checkBoxes.setLayout(new GridLayout(2, 1));
        checkBoxes.add(bold);
        checkBoxes.add(italic);

        panel.add(checkBoxes);

        // Second column containing radio buttons
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new GridLayout(3, 1));

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

