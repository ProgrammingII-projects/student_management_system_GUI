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
        // === Window setup ===
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(10, 25, 74)); // dark blue background

        // === GridBag setup ===
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // === Fonts and sizes ===
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Dimension fieldSize = new Dimension(250, 35);
        Dimension buttonSize = new Dimension(150, 40);

        // === Title ===
        JLabel title = new JLabel("Student Management System Login", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        // === Username label ===
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        add(usernameLabel, gbc);

        // === Username field ===
        usernameField = new JTextField();
        usernameField.setPreferredSize(fieldSize);
        usernameField.setFont(fieldFont);
        usernameField.setBackground(new Color(20, 40, 100));
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255)));
        gbc.gridy = 2;
        add(usernameField, gbc);

        // === Password label ===
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridy = 3;
        add(passwordLabel, gbc);

        // === Password field ===
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldSize);
        passwordField.setFont(fieldFont);
        passwordField.setBackground(new Color(20, 40, 100));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255)));
        gbc.gridy = 4;
        add(passwordField, gbc);

        // === Login button ===
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(buttonSize);
        loginButton.setBackground(new Color(0, 153, 51)); // green
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        gbc.gridy = 5;
        add(loginButton, gbc);

        setVisible(true);
    }

    // === Getters ===
    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
