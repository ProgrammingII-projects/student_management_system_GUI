package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.DashboardController;

public class SearchStudent extends JFrame {
    private JTextField studentIdField;
    private JButton searchButton;
    private DashboardController controller;

    public SearchStudent(DashboardController controller) {
        setUndecorated(true);
        this.controller = controller;


        setTitle("Search Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(10, 25, 74)); // dark blue background
        getContentPane().setBackground(new Color(10, 25, 74)); // dark blue background

        add(CloseButton.create(this));


        JLabel label = new JLabel("Enter Student ID:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setBounds(40, 40, 150, 25);
        add(label);


        studentIdField = new JTextField();
        studentIdField.setBounds(190, 40, 150, 25);
        studentIdField.setBackground(new Color(20, 40, 100));
        studentIdField.setForeground(Color.WHITE);
        studentIdField.setCaretColor(Color.WHITE);
        studentIdField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        studentIdField.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255)));
        add(studentIdField);


        searchButton = new JButton("Search");
        searchButton.setBounds(130, 100, 120, 35);
        searchButton.setBackground(new Color(0, 153, 51)); // green
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        add(searchButton);


        searchButton.addActionListener(e -> {
            String input = studentIdField.getText().trim();
            controller.searchStudent(input);
        });

        setVisible(true);
    }
}
