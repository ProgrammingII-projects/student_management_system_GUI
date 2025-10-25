package view;

import javax.swing.*;
import java.awt.*;

public class AddStudentView extends BaseReusableView {
    private JButton addButton, clearButton;

    public AddStudentView() {
        super("Add New Student", false);

        addButton = new JButton("Add Student");
        addButton.setBackground(new Color(0, 153, 51));
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(100, 320, 120, 35);
        add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(204, 0, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBounds(250, 320, 100, 35);
        add(clearButton);

        setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
}
