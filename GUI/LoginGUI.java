package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.Alert;

public class LoginGUI {

    private static JFrame frame;

    public LoginGUI() {
        display();
    }

    public void display() {
        frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                if (username.equals("admin") && new String(password).equals("password123")) {
                    new Alert("Login Successful!");
                } else {
                    new Alert("ERROR");
                }
            }
        });
        frame.setVisible(true);
    }
}
