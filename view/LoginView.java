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
        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(10, 25, 74));
        
        // Add CloseButton to the top-right corner (increase button size)
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        closePanel.setOpaque(false);

        JButton closeButton = CloseButton.create(this);
        closeButton.setPreferredSize(new Dimension(50, 35)); // Increased size
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 20)); // Larger font for button
        closePanel.add(closeButton);

        GridBagConstraints closeGbc = new GridBagConstraints();
        closeGbc.gridx = 1;
        closeGbc.gridy = 0;
        closeGbc.anchor = GridBagConstraints.NORTHEAST;
        closeGbc.weightx = 1;
        closeGbc.weighty = 1;
        closeGbc.insets = new Insets(5, 5, 0, 5);
        add(closePanel, closeGbc);




        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Dimension fieldSize = new Dimension(250, 35);
        Dimension buttonSize = new Dimension(150, 40);


        JLabel title = new JLabel("Student Management System Login", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);



        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        add(usernameLabel, gbc);


        usernameField = new JTextField();
        usernameField.setPreferredSize(fieldSize);
        usernameField.setFont(fieldFont);
        usernameField.setBackground(new Color(20, 40, 100));
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255)));
        gbc.gridy = 2;
        add(usernameField, gbc);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridy = 3;
        add(passwordLabel, gbc);


        passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldSize);
        passwordField.setFont(fieldFont);
        passwordField.setBackground(new Color(20, 40, 100));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255)));
        gbc.gridy = 4;
        add(passwordField, gbc);


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

    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }


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
