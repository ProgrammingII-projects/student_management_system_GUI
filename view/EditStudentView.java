package view;

import java.awt.*;
import javax.swing.*;
import model.Student;

public class EditStudentView extends JFrame {
    private JButton updateButton, cancelButton;
    private JLabel titleLabel, idLabel, nameLabel, ageLabel, genderLabel, departmentLabel, gpaLabel;
    private JTextField idField, nameField, ageField, gpaField;
    private JComboBox<String> genderField, departmentField;

    public EditStudentView(Student student) {
        setTitle("Student Management System - Edit Student");
        setSize(450, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        // ===== Title =====
        titleLabel = new JLabel("Edit Student", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBounds(0, 20, 450, 30);
        add(titleLabel);

        // ===== Labels =====
        idLabel = new JLabel("Student ID:");
        idLabel.setBounds(60, 70, 100, 25);
        add(idLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(60, 110, 100, 25);
        add(nameLabel);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(60, 150, 100, 25);
        add(ageLabel);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(60, 190, 100, 25);
        add(genderLabel);

        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(60, 230, 100, 25);
        add(departmentLabel);

        gpaLabel = new JLabel("GPA:");
        gpaLabel.setBounds(60, 270, 100, 25);
        add(gpaLabel);

        // ===== Fields =====
        idField = new JTextField();
        idField.setBounds(170, 70, 200, 25);
        idField.setEditable(false); // Keep ID read-only
        add(idField);

        nameField = new JTextField();
        nameField.setBounds(170, 110, 200, 25);
        add(nameField);

        ageField = new JTextField();
        ageField.setBounds(170, 150, 200, 25);
        add(ageField);

        genderField = new JComboBox<>(new String[]{"Male", "Female"});
        genderField.setBounds(170, 190, 200, 25);
        add(genderField);

        departmentField = new JComboBox<>(new String[]{
                "Computer Science", "Engineering", "Business", "Medicine"
        });
        departmentField.setBounds(170, 230, 200, 25);
        add(departmentField);

        gpaField = new JTextField();
        gpaField.setBounds(170, 270, 200, 25);
        add(gpaField);

        // ===== Buttons =====
        updateButton = new JButton("Update");
        updateButton.setBackground(new Color(0, 153, 51));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setBounds(100, 330, 120, 35);
        add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(204, 0, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(250, 330, 100, 35);
        add(cancelButton);

        // ===== Pre-fill student data =====
        if (student != null) {
            idField.setText(String.valueOf(student.getStudentID()));
            nameField.setText(student.getName());
            ageField.setText(String.valueOf(student.getAge()));
            genderField.setSelectedItem(student.getGender());
            departmentField.setSelectedItem(student.getDepartment());
            gpaField.setText(String.valueOf(student.getGPA()));
        }

        setVisible(true);
    }

    // ===== Getters for controller =====
    public JButton getUpdateButton() { return updateButton; }
    public JButton getCancelButton() { return cancelButton; }
    public JTextField getIdField() { return idField; }
    public JTextField getNameField() { return nameField; }
    public JTextField getAgeField() { return ageField; }
    public JTextField getGpaField() { return gpaField; }
    public JComboBox<String> getGenderField() { return genderField; }
    public JComboBox<String> getDepartmentField() { return departmentField; }

    // ===== Optional method to clear fields (same style as AddStudentView) =====
    public void clearFields() {
        nameField.setText("");
        ageField.setText("");
        gpaField.setText("");
        genderField.setSelectedIndex(0);
        departmentField.setSelectedIndex(0);
    }
}
