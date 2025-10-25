package view;

import javax.swing.*;
import java.awt.event.*;

import model.Student;
import model.StudentDatabase;

public class DeleteStudent extends JFrame {
    private JTextField studentIdField;
    private JButton deleteButton;
    private StudentDatabase database;

    public DeleteStudent(StudentDatabase database) {
        this.database = database;

        setTitle("Delete Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Action listener for delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = studentIdField.getText().trim();

                if (input.isEmpty()) {
                    new AlertView("Error", "Please enter a Student ID!");
                    return;
                }

                try {
                    int id = Integer.parseInt(input);

                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to delete student with ID: " + id + "?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Delete student
                        if (database.deleteStudent(id)) {
                            new AlertView("Success", "Student deleted successfully!");
                        } else {
                            new AlertView("Error", "Student not found or not deleted!");
                        }
                    } else {
                        System.exit(0);
                    }

                } catch (NumberFormatException ex) {
                    new AlertView("Error", "Student ID must be a number!");
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase("model/students.txt");
        SwingUtilities.invokeLater(() -> new DeleteStudent(db).setVisible(true));
    }
}
