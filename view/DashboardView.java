package view;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private JButton addButton, deleteButton, searchButton, viewButton, exitButton, logoutButton;

    public DashboardView() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        titleLabel.setBounds(150, 10, 100, 30);
        titleLabel.setForeground(Color.BLUE);
        add(titleLabel);

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");
        viewButton = new JButton("View");
        exitButton = new JButton("Exit");
        logoutButton = new JButton("Logout");

        addButton.setBounds(50, 50, 120, 30);
        deleteButton.setBounds(200, 50, 120, 30);
        searchButton.setBounds(50, 100, 120, 30);
        viewButton.setBounds(200, 100, 120, 30);
        exitButton.setBounds(50, 150, 120, 30);
        logoutButton.setBounds(200, 150, 120, 30);

        add(addButton);
        add(deleteButton);
        add(searchButton);
        add(viewButton);
        add(exitButton);
        add(logoutButton);

        setVisible(true);
    }

    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getSearchButton() { return searchButton; }
    public JButton getViewButton() { return viewButton; }
    public JButton getExitButton() { return exitButton; }
    public JButton getLogoutButton() { return logoutButton; }
}
