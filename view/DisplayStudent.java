package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.*;
import model.*;

public class DisplayStudent {

    private JFrame frame;
    private Student student;
    private DashboardController controller;
    private int flag;

    public DisplayStudent(Student student, DashboardController controller, int flag) {
        this.student = student;
        this.controller = controller;
        this.flag = flag;
        display();
    }

    public void display() {

        frame = new JFrame("Student Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(10, 25, 74)); // dark blue background

        // ====== Main Panel ======
        JPanel infoPanel = new JPanel(new GridLayout(6, 2, 15, 15));
        infoPanel.setBackground(new Color(10, 25, 74));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(40, 80, 20, 80));

        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 16);
        Color textColor = Color.WHITE;

        JLabel nameLabel = createStyledLabel("Name:", labelFont, textColor);
        JLabel nameText = createStyledLabel(student.getName(), valueFont, textColor);

        JLabel idLabel = createStyledLabel("Student ID:", labelFont, textColor);
        JLabel idText = createStyledLabel(String.valueOf(student.getStudentID()), valueFont, textColor);

        JLabel ageLabel = createStyledLabel("Age:", labelFont, textColor);
        JLabel ageText = createStyledLabel(String.valueOf(student.getAge()), valueFont, textColor);

        JLabel genderLabel = createStyledLabel("Gender:", labelFont, textColor);
        JLabel genderText = createStyledLabel(student.getGender(), valueFont, textColor);

        JLabel departmentLabel = createStyledLabel("Department:", labelFont, textColor);
        JLabel departmentText = createStyledLabel(student.getDepartment(), valueFont, textColor);

        JLabel gpaLabel = createStyledLabel("GPA:", labelFont, textColor);
        JLabel gpaText = createStyledLabel(String.valueOf(student.getGPA()), valueFont, textColor);

        infoPanel.add(nameLabel); infoPanel.add(nameText);
        infoPanel.add(idLabel); infoPanel.add(idText);
        infoPanel.add(ageLabel); infoPanel.add(ageText);
        infoPanel.add(genderLabel); infoPanel.add(genderText);
        infoPanel.add(departmentLabel); infoPanel.add(departmentText);
        infoPanel.add(gpaLabel); infoPanel.add(gpaText);

        // ====== Buttons Panel ======
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        buttonPanel.setBackground(new Color(10, 25, 74));

        JButton editButton = createStyledButton("Edit Student", new Color(0, 153, 255));
        JButton deleteButton = createStyledButton("Delete Student", new Color(204, 0, 0));
        JButton backButton = createStyledButton("Back", new Color(0, 153, 51));

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        // ====== Add Components ======
        frame.add(infoPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ====== Button Actions ======
        editButton.addActionListener(e -> {
            frame.dispose();
            EditStudentView editView = new EditStudentView(student);
            new EditStudentController(editView, controller.getDatabase());
        });

        deleteButton.addActionListener(e -> {
            controller.deleteStudent(String.valueOf(student.getStudentID()));
            frame.dispose();
            if (flag == 1) {
                new TableTemplate(controller).display("Delete ");
            } else if (flag == 2) {
                new TableTemplate(controller).display("Show ");
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            if (flag == 2) {
                new TableTemplate(controller).display("Show ");
            }
        });

        frame.setVisible(true);
    }

    // ===== Helper Methods =====
    private JLabel createStyledLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(150, 40));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
}
