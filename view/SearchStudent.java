package view;

import javax.swing.*;
import java.awt.event.*;
import controller.DashboardController;

public class SearchStudent extends JFrame {
    private JTextField studentIdField;
    private JButton searchButton;
    private DashboardController controller;

    public SearchStudent(DashboardController controller) {
        this.controller = controller;

        setTitle("Search Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 180);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter Student ID:");
        label.setBounds(30, 30, 120, 25);
        add(label);

        studentIdField = new JTextField();
        studentIdField.setBounds(150, 30, 150, 25);
        add(studentIdField);

        searchButton = new JButton("Search");
        searchButton.setBounds(110, 80, 120, 30);
        add(searchButton);

        // Send the search request to the controller
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = studentIdField.getText().trim();
                controller.searchStudent(input);
            }
        });
    }
}
