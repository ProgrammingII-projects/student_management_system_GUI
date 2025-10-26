package view;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private JButton addButton, deleteButton, searchButton, viewButton, exitButton, logoutButton;

    public DashboardView() {
        setTitle("Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color darkBlue = new Color(10, 25, 74);       // main background
        Color midBlue = new Color(25, 55, 109);       // side panel
        Color lightBlue = new Color(100, 149, 237);   // button base
        Color hoverBlue = new Color(70, 130, 180);    // hover effect
        Color textLight = new Color(230, 240, 255);

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(midBlue);
        sidePanel.setPreferredSize(new Dimension(250, getHeight()));
        sidePanel.setLayout(new BorderLayout(10, 10));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel(" Dashboard", SwingConstants.LEFT);
        title.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        title.setForeground(textLight);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        sidePanel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(midBlue);
        buttonPanel.setLayout(new GridLayout(6, 1, 12, 12));

        addButton = createModernButton("Add Student", lightBlue, hoverBlue);
        deleteButton = createModernButton(" Delete", lightBlue, hoverBlue);
        searchButton = createModernButton("Search", lightBlue, hoverBlue);
        viewButton = createModernButton("View All", lightBlue, hoverBlue);
        exitButton = createModernButton(" Exit", lightBlue, hoverBlue);
        logoutButton = createModernButton("Logout", lightBlue, hoverBlue);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(logoutButton);

        sidePanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(darkBlue);
        contentPanel.setLayout(new BorderLayout());


        ImageIcon imageIcon = new ImageIcon("assets/Background2.png");
        Image image = imageIcon.getImage().getScaledInstance(550, 400, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(imageLabel, BorderLayout.CENTER);

        add(sidePanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createModernButton(String text, Color baseColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor);
            }
        });
        return button;
    }

    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getSearchButton() { return searchButton; }
    public JButton getViewButton() { return viewButton; }
    public JButton getExitButton() { return exitButton; }
    public JButton getLogoutButton() { return logoutButton; }

}
