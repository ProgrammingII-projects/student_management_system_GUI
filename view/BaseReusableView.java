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

        // ====== Modern Dark Theme ======
        Color background = new Color(10, 25, 74);          // Dark blue background
        Color labelColor = Color.WHITE;                    // White labels
        Color textFieldBg = new Color(20, 40, 100);        // Slightly lighter blue for inputs
        Color textFieldBorder = new Color(100, 150, 255);  // Light blue border
        Color textColor = Color.WHITE;                     // White text

        getContentPane().setBackground(background);

        // ====== Title ======
        titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(173, 216, 255)); // Soft light blue
        titleLabel.setBounds(0, 20, 450, 30);
        add(titleLabel);

        int y = 70;

        // ====== ID Field (optional) ======
        if (showIdField) {
            idLabel = new JLabel("Student ID:");
            idLabel.setForeground(labelColor);
            idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            idLabel.setBounds(60, y, 100, 25);
            add(idLabel);

            idField = createStyledTextField(textFieldBg, textColor, textFieldBorder);
            idField.setBounds(170, y, 200, 25);
            idField.setEditable(false);
            add(idField);

            y += 40;
        }

        // ====== Name ======
        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(labelColor);
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nameLabel.setBounds(60, y, 100, 25);
        add(nameLabel);

        nameField = createStyledTextField(textFieldBg, textColor, textFieldBorder);
        nameField.setBounds(170, y, 200, 25);
        add(nameField);

        y += 40;

        // ====== Age ======
        ageLabel = new JLabel("Age:");
        ageLabel.setForeground(labelColor);
        ageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ageLabel.setBounds(60, y, 100, 25);
        add(ageLabel);

        ageField = createStyledTextField(textFieldBg, textColor, textFieldBorder);
        ageField.setBounds(170, y, 200, 25);
        add(ageField);

        y += 40;

        // ====== Gender ======
        genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(labelColor);
        genderLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderLabel.setBounds(60, y, 100, 25);
        add(genderLabel);

        genderField = createStyledComboBox(new String[]{"Male", "Female"}, textFieldBg, textColor, textFieldBorder);
        genderField.setBounds(170, y, 200, 25);
        add(genderField);

        y += 40;

        // ====== Department ======
        departmentLabel = new JLabel("Department:");
        departmentLabel.setForeground(labelColor);
        departmentLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        departmentLabel.setBounds(60, y, 100, 25);
        add(departmentLabel);

        departmentField = createStyledComboBox(
                new String[]{"Computer Science", "Engineering", "Business", "Medicine"},
                textFieldBg, textColor, textFieldBorder
        );
        departmentField.setBounds(170, y, 200, 25);
        add(departmentField);

        y += 40;

        // ====== GPA ======
        gpaLabel = new JLabel("GPA:");
        gpaLabel.setForeground(labelColor);
        gpaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gpaLabel.setBounds(60, y, 100, 25);
        add(gpaLabel);

        gpaField = createStyledTextField(textFieldBg, textColor, textFieldBorder);
        gpaField.setBounds(170, y, 200, 25);
        add(gpaField);
    }

    // ====== Helper: Create styled text field ======
    private JTextField createStyledTextField(Color bg, Color fg, Color borderColor) {
        JTextField field = new JTextField();
        field.setBackground(bg);
        field.setForeground(fg);
        field.setCaretColor(fg);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createLineBorder(borderColor));
        return field;
    }

    // ====== Helper: Create styled combo box ======
    private JComboBox<String> createStyledComboBox(String[] options, Color bg, Color fg, Color borderColor) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBackground(bg);
        comboBox.setForeground(fg);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBorder(BorderFactory.createLineBorder(borderColor));
        return comboBox;
    }

    // ====== Getters ======
    public JTextField getNameField() { return nameField; }
    public JTextField getAgeField() { return ageField; }
    public JTextField getGpaField() { return gpaField; }
    public JComboBox<String> getGenderField() { return genderField; }
    public JComboBox<String> getDepartmentField() { return departmentField; }

    // ====== Clear fields ======
    public void clearFields() {
        nameField.setText("");
        ageField.setText("");
        gpaField.setText("");
        genderField.setSelectedIndex(0);
        departmentField.setSelectedIndex(0);
    }
}
