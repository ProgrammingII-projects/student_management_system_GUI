package view;

import java.awt.*;
import javax.swing.*;

public class AddStudentView extends JFrame {
    private JButton addButton, clearButton;
    private JLabel titleLabel, nameLabel, ageLabel, genderLabel, departmentLabel, gpaLabel;
    private JTextField nameField, ageField, gpaField;
    private JComboBox<String> genderField, departmentField;

    public AddStudentView() {
        setTitle("Student Management System - Add Student");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        // ===== Title =====
        titleLabel = new JLabel("Add New Student", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBounds(0, 20, 450, 30);
        add(titleLabel);

        // ===== Labels =====
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(60, 80, 100, 25);
        add(nameLabel);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(60, 120, 100, 25);
        add(ageLabel);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(60, 160, 100, 25);
        add(genderLabel);

        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(60, 200, 100, 25);
        add(departmentLabel);

        gpaLabel = new JLabel("GPA:");
        gpaLabel.setBounds(60, 240, 100, 25);
        add(gpaLabel);

        // ===== Fields =====
        nameField = new JTextField();
        nameField.setBounds(170, 80, 200, 25);
        add(nameField);

        ageField = new JTextField();
        ageField.setBounds(170, 120, 200, 25);
        add(ageField);

        genderField = new JComboBox<>(new String[]{"Male", "Female"});
        genderField.setBounds(170, 160, 200, 25);
        add(genderField);

        departmentField = new JComboBox<>(new String[]{"Computer Science", "Engineering", "Business", "Medicine"});
        departmentField.setBounds(170, 200, 200, 25);
        add(departmentField);

        gpaField = new JTextField();
        gpaField.setBounds(170, 240, 200, 25);
        add(gpaField);

        // ===== Buttons =====
        addButton = new JButton("Add Student");
        addButton.setBackground(new Color(0, 153, 51));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBounds(100, 300, 120, 35);
        add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(204, 0, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setBounds(250, 300, 100, 35);
        add(clearButton);

        setVisible(true);
    }

    // ===== Getters for controller =====
    public JButton getAddButton() { return addButton; }
    public JButton getClearButton() { return clearButton; }
    public JTextField getNameField() { return nameField; }
    public JTextField getAgeField() { return ageField; }
    public JTextField getGpaField() { return gpaField; }
    public JComboBox<String> getGenderField() { return genderField; }
    public JComboBox<String> getDepartmentField() { return departmentField; }

    // ===== Optional method to clear fields =====
    public void clearFields() {
        nameField.setText("");
        ageField.setText("");
        gpaField.setText("");
        genderField.setSelectedIndex(0);
        departmentField.setSelectedIndex(0);
    }
}
