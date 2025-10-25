package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    
    private static JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;


    public LoginView()
    {
        display();
    }

    public void display() {
        frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();  //function that we use to align using X,y,width
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension buttonSize = new Dimension(120, 40);
        Dimension fieldSize = new Dimension(400, 40);

        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(fieldSize);

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldSize);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(buttonSize);

        // Username label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(usernameLabel, gbc);

        // Username field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(usernameField, gbc);

        // Password label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(passwordLabel, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(passwordField, gbc);

        // Login button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(loginButton, gbc);
        
        getUsernameField();
        getPasswordField();
        getLoginButton();
    }

    public JTextField getUsernameField() { return usernameField; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JButton getLoginButton() { return loginButton; }

}