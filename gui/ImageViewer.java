import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private JButton openButton;

    public ImageViewer() {
        super("Image Viewer");

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        openButton = new JButton("Open Image");

        JPanel panel = new JPanel();
        panel.add(openButton);

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image img = icon.getImage();
                    Image newImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(newImg));
                }
            }
        });

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageViewer();
    }
}