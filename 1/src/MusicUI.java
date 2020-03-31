import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class MusicUI {

    MusicUI() {

        JFrame window = new JFrame("Media Player");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container panel = window.getContentPane();
        panel.setLayout(new BorderLayout());

        JLabel songName = new JLabel("Pay No Mind - Madeon feat: Passion Pit");
        JPanel title = new JPanel(new FlowLayout());

        title.add(songName);
        panel.add(title, BorderLayout.NORTH);


        try {
            BufferedImage myPicture = ImageIO.read(this.getClass().getResource("albumArt.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            System.err.println("Failed to find album art");
        }

        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        JButton skipBack = new JButton("<<");
        JButton playPause = new JButton("||");
        JButton skipForward = new JButton(">>");

        controls.add(skipBack);
        controls.add(playPause);
        controls.add(skipForward);

        panel.add(controls, BorderLayout.SOUTH);


        window.pack();
        window.setVisible(true);

    }

}
