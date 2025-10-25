package view;

import javax.swing.*;
import java.awt.event.*;
import controller.DashboardController;

public class DeleteStudent extends JFrame {
    private JTextField studentIdField;
    private JButton deleteButton;
    private DashboardController controller;

    public DeleteStudent(DashboardController controller) {
        this.controller = controller;

        setTitle("Delete Student");
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

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(110, 80, 120, 30);
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = studentIdField.getText().trim();
                controller.deleteStudent(input);
            }
        });
    }
    public void prefillStudentId(String id) {
        studentIdField.setText(id);
    }
}
