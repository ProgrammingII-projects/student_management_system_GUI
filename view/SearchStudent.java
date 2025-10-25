package view;

import javax.swing.*;
import java.awt.event.*;

import model.Student;
import model.StudentDatabase;

public class SearchStudent extends JFrame {
    private JTextField studentIdField;
    private JButton searchButton;
    private StudentDatabase database;

    public SearchStudent(StudentDatabase database) {
        this.database = database;

        setTitle("Search Student");
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

        searchButton = new JButton("Search");
        searchButton.setBounds(110, 80, 120, 30);
        add(searchButton);

        // Action listener for search
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = studentIdField.getText().trim();

                if (input.isEmpty()) {
                    new AlertView("Error", "Please enter a Student ID!");
                    return;
                }

                try {
                    int id = Integer.parseInt(input);
                    Student student = database.searchStudent(id);

                    if (student != null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Student Found:\n\n" +
                                        "ID: " + student.getStudentID() + "\n" +
                                        "Name: " + student.getName() + "\n" +
                                        "Age: " + student.getAge() + "\n" +
                                        "Gender: " + student.getGender() + "\n" +
                                        "Department: " + student.getDepartment() + "\n" +
                                        "GPA: " + student.getGPA(),
                                "Search Result",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        new AlertView("Error", "Student not found!");
                    }

                } catch (NumberFormatException ex) {
                    new AlertView("Error", "Student ID must be a number!");
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase("model/students.txt");
        SwingUtilities.invokeLater(() -> new SearchStudent(db).setVisible(true));
    }
}
