package view;

import javax.swing.*;
import java.awt.*;

public abstract class BaseReusableView extends JFrame {
    protected JLabel titleLabel, nameLabel, ageLabel, genderLabel, departmentLabel, gpaLabel, idLabel;
    protected JTextField idField, nameField, ageField, gpaField;
    protected JComboBox<String> genderField, departmentField;

    public BaseReusableView(String title, boolean showIdField) {
        setTitle("Student Management System - " + title);
        setSize(450, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBounds(0, 20, 450, 30);
        add(titleLabel);

        int y = 70;

        if (showIdField) {
            idLabel = new JLabel("Student ID:");
            idLabel.setBounds(60, y, 100, 25);
            add(idLabel);

            idField = new JTextField();
            idField.setBounds(170, y, 200, 25);
            idField.setEditable(false);
            add(idField);

            y += 40;
        }

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(60, y, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(170, y, 200, 25);
        add(nameField);

        y += 40;
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(60, y, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(170, y, 200, 25);
        add(ageField);

        y += 40;
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(60, y, 100, 25);
        add(genderLabel);

        genderField = new JComboBox<>(new String[] { "Male", "Female" });
        genderField.setBounds(170, y, 200, 25);
        add(genderField);

        y += 40;
        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(60, y, 100, 25);
        add(departmentLabel);

        departmentField = new JComboBox<>(new String[] {
                "Computer Science", "Engineering", "Business", "Medicine"
        });
        departmentField.setBounds(170, y, 200, 25);
        add(departmentField);

        y += 40;
        gpaLabel = new JLabel("GPA:");
        gpaLabel.setBounds(60, y, 100, 25);
        add(gpaLabel);

        gpaField = new JTextField();
        gpaField.setBounds(170, y, 200, 25);
        add(gpaField);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getGpaField() {
        return gpaField;
    }

    public JComboBox<String> getGenderField() {
        return genderField;
    }

    public JComboBox<String> getDepartmentField() {
        return departmentField;
    }



    public void clearFields() {
        nameField.setText("");
        ageField.setText("");
        gpaField.setText("");
        genderField.setSelectedIndex(0);
        departmentField.setSelectedIndex(0);
    }
}
