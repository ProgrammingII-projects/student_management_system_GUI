package view;

import javax.swing.*;
import java.awt.*;
import model.Student;

public class EditStudentView extends BaseReusableView {
    private JButton updateButton, cancelButton;

    public EditStudentView(Student student) {
        super("Edit Student", true);

        updateButton = new JButton("Update");
        updateButton.setBackground(new Color(0, 153, 51));
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(100, 330, 120, 35);
        add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(204, 0, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(250, 330, 100, 35);
        add(cancelButton);

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
