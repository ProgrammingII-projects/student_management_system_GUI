package view;

import javax.swing.*;
import java.awt.*;
import model.Student;

public class EditStudentView extends BaseReusableView {
    private JButton updateButton, cancelButton;

    public EditStudentView(Student student) {
        super("Edit Student", true); // true = allow ID editing if needed
setUndecorated(true);

        updateButton = new JButton("Update Student");
        updateButton.setBackground(new Color(0, 153, 51)); // green
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        updateButton.setBounds(100, 320, 150, 35);
        add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(204, 0, 0)); // red
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton.setBounds(270, 320, 120, 35);
        add(cancelButton);


        if (student != null) {
            idField.setText(String.valueOf(student.getStudentID()));
            nameField.setText(student.getName());
            ageField.setText(String.valueOf(student.getAge()));
            genderField.setSelectedItem(student.getGender());
            departmentField.setSelectedItem(student.getDepartment());
            gpaField.setText(String.valueOf(student.getGPA()));
        }


        getContentPane().setBackground(new Color(10, 25, 74)); // dark blue
        setFieldColors();

        setVisible(true);
    }


    private void setFieldColors() {
        // make text fields readable and consistent
        JTextField[] fields = { idField, nameField, ageField, gpaField };
        for (JTextField field : fields) {
            field.setBackground(new Color(20, 40, 100)); // slightly lighter blue
            field.setForeground(Color.WHITE);
            field.setCaretColor(Color.WHITE);
            field.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }


        JComboBox<?>[] boxes = { genderField, departmentField };
        for (JComboBox<?> box : boxes) {
            box.setBackground(new Color(20, 40, 100));
            box.setForeground(Color.WHITE);
        }


        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JLabel) {
                comp.setForeground(Color.WHITE);
            }
        }
    }


    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getIdField() {
        return idField;
    }
}
