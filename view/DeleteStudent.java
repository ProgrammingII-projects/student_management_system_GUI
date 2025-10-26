package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.DashboardController;

public class DeleteStudent extends JFrame {
    private JTextField studentIdField;
    private JButton deleteButton;
    private DashboardController controller;

    // ===== Theme Constants (matches BaseReusableView) =====
    private final Color BACKGROUND_COLOR = new Color(10, 25, 74);
    private final Color TEXT_COLOR = Color.WHITE;
    private final Color FIELD_BG_COLOR = new Color(20, 40, 100);
    private final Color FIELD_BORDER_COLOR = new Color(100, 150, 255);
    private final Font MAIN_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);

    public DeleteStudent(DashboardController controller) {
        this.controller = controller;
        MethodChoose();
    }

    public void MethodChoose() {
        getContentPane().removeAll();
        getContentPane().setBackground(BACKGROUND_COLOR);
        setLayout(null);
        setUndecorated(true);

        JLabel title = new JLabel("Choose Delete Method", SwingConstants.CENTER);
        title.setFont(TITLE_FONT);
        title.setForeground(new Color(173, 216, 255));
        title.setBounds(0, 10, 350, 30);
        add(title);

        JButton IDButton = new JButton("Delete by ID");
        JButton ChooseDeleteButton = new JButton("Delete from List");

        styleButton(IDButton, new Color(0, 102, 204));
        styleButton(ChooseDeleteButton, new Color(0, 153, 51));

        IDButton.setBounds(40, 60, 120, 35);
        ChooseDeleteButton.setBounds(190, 60, 120, 35);

        add(IDButton);
        add(ChooseDeleteButton);

        setTitle("Choose Delete Method");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(370, 160);
        setLocationRelativeTo(null);
        setVisible(true);


        IDButton.addActionListener(e -> {
            dispose();
            SearchDelete();
            setVisible(true);
        });

        ChooseDeleteButton.addActionListener(e -> {
            dispose();
            TableTemplate t = new TableTemplate(controller);
            t.display("Delete");
        });
        add(CloseButton.create(this));
    }

    public void SearchDelete() {
        getContentPane().removeAll();
        getContentPane().setBackground(BACKGROUND_COLOR);
        revalidate();
        repaint();

        setTitle("Delete Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(380, 220);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter Student ID:");
        label.setForeground(TEXT_COLOR);
        label.setFont(MAIN_FONT);
        label.setBounds(40, 50, 150, 25);
        add(label);

        studentIdField = new JTextField();
        studentIdField.setBounds(180, 50, 150, 25);
        styleTextField(studentIdField);
        add(studentIdField);

        deleteButton = new JButton("Delete");
        styleButton(deleteButton, new Color(204, 0, 0));
        deleteButton.setBounds(120, 110, 120, 35);
        add(deleteButton);

        deleteButton.addActionListener(e -> {
            String input = studentIdField.getText().trim();
            controller.deleteStudent(input,0);
            dispose();
        });
        add(CloseButton.create(this));

        setVisible(true);
    }


    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder());

    }

    private void styleTextField(JTextField field) {
        field.setBackground(FIELD_BG_COLOR);
        field.setForeground(TEXT_COLOR);
        field.setCaretColor(TEXT_COLOR);
        field.setBorder(BorderFactory.createLineBorder(FIELD_BORDER_COLOR));
        field.setFont(MAIN_FONT);
    }

    public void prefillStudentId(String id) {
        if (studentIdField != null) {
            studentIdField.setText(id);
        }
    }
}
