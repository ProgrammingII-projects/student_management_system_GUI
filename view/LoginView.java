package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        super("Login Form");
        display();
    }

    private void display() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension buttonSize = new Dimension(120, 40);
        Dimension fieldSize = new Dimension(400, 40);

        JLabel usernameLabel = new JLabel("Username");
         usernameField = new JTextField();
        usernameField.setPreferredSize(fieldSize);

        JLabel passwordLabel = new JLabel("Password");
         passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldSize);

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(buttonSize);

        // Username label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(usernameLabel, gbc);

        // Username field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(usernameField, gbc);

        // Password label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(passwordLabel, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(passwordField, gbc);

        // Login button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public JTextField getUsernameField() { return usernameField; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JButton getLoginButton() { return loginButton; }

}