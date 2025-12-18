import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    private final String correctUsername = "apakek";
    private final String correctPassword = "hoh123";

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblMessage;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login gui = new Login();
            gui.go();
        });
    }

    public void go() {
        JFrame frame = new JFrame("Aplikasi Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null); // Tengah layar

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan field username
        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(15);

        // Label dan field password
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(15);

        // Tombol
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());

        // Label pesan hasil
        lblMessage = new JLabel(" ");
        lblMessage.setForeground(Color.RED);
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);

        // Penempatan komponen
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblUsername, gbc);

        gbc.gridx = 1;
        panel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblPassword, gbc);

        gbc.gridx = 1;
        panel.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);
        panel.add(buttonPanel, gbc);

        gbc.gridy = 3;
        panel.add(lblMessage, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        txtUsername.requestFocusInWindow(); // Fokus awal di username
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (correctUsername.equals(username) && correctPassword.equals(password)) {
                lblMessage.setText("Login Berhasil!");
                lblMessage.setForeground(new Color(0, 128, 0)); // Hijau
                JOptionPane.showMessageDialog(null, "Selamat datang, " + username + "!", 
                    "Login Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                lblMessage.setText("Username atau password salah!");
                lblMessage.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Login Ditolak", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtUsername.setText("");
            txtPassword.setText("");
            lblMessage.setText(" ");
            txtUsername.requestFocusInWindow();
        }
    }
}