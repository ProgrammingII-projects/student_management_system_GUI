package GUI;

import javax.swing.*;
import javax.swing.plaf.TextUI;

import database.StudentDatabase;

import java.awt.Color;

public class MainMenu extends JFrame {
    // backend connection here
    StudentDatabase studentDatabase;
    
    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton viewButton;
    private JButton exitButton;
    private JButton logoutButton;

    public MainMenu() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
        titleLabel.setBounds(150, 0, 100, 30);
        titleLabel.setForeground(Color.BLUE);


        // add listeners
        addButton = new JButton("Add");
        addButton.setBounds(50, 30, 120, 30);
        add(addButton);
        addButton.addActionListener(e -> {
            dispose();
            //new AddItemGUI();
        });

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(200, 30, 120, 30);
        add(deleteButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(50, 80, 120, 30);
        add(searchButton);

        viewButton = new JButton("View");
        viewButton.setBounds(200, 80, 120, 30);
        add(viewButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(50, 130, 120, 30);
        add(exitButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 130, 120, 30);
        add(logoutButton);

        setVisible(true);
    }
    // test this code
    public static void main(String[] args) {
        new MainMenu();
    }
}
