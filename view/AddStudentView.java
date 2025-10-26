package view;

import javax.swing.*;
import java.awt.*;

public class AddStudentView extends BaseReusableView {
    private JButton addButton, clearButton;

    public AddStudentView() {
        super("Add New Student", false);

        // Set dark blue background
        getContentPane().setBackground(new Color(10, 25, 74)); // dark blue shade

        // Use a null layout if BaseReusableView doesn’t already handle layout
        setLayout(null);

        // Add Student button
        addButton = new JButton("Add Student");
        addButton.setBackground(new Color(0, 153, 51));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addButton.setBounds(100, 320, 140, 40);
        add(addButton);

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(204, 0, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        clearButton.setBounds(260, 320, 120, 40);
        add(clearButton);

        // Optional: make buttons look cleaner
        addButton.setBorder(BorderFactory.createEmptyBorder());
        clearButton.setBorder(BorderFactory.createEmptyBorder());

        setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
}
