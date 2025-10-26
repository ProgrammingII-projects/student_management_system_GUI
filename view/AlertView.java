package view;

import javax.swing.*;
import java.awt.*;

public class AlertView {

    private final Color backgroundColor = new Color(10, 25, 47);
    private final Color accentColor = new Color(41, 128, 255);
    private final Color textColor = new Color(230, 230, 230);

    public AlertView(String title, String text) {
        this(title, text, null, null);
    }

    public AlertView(String title, String text, Runnable onOk) {
        this(title, text, onOk, null);
    }

    public AlertView(String title, String text, Runnable onOk, String type) {
        // Create undecorated frame
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setSize(380, 190);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        frame.setBackground(backgroundColor);

        // Shadow panel for soft edges
        frame.getRootPane().setOpaque(false);
        JPanel shadowPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 0, 50));
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);
                g2d.dispose();
            }
        };
        shadowPanel.setLayout(new BorderLayout());
        shadowPanel.setOpaque(false);

        // Main content panel
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(backgroundColor);

        // Title
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        titleLabel.setForeground(accentColor);

        // Message text
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(textColor);

        // OK Button
        JButton okButton = new JButton("OK");
        okButton.setFocusPainted(false);
        okButton.setBackground(accentColor);
        okButton.setForeground(Color.WHITE);
        okButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        okButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        okButton.setOpaque(true);
        okButton.setBorderPainted(false);

        okButton.addActionListener(e -> {
            frame.dispose();
            if (onOk != null)
                onOk.run();
        });

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(okButton);

        // Layout composition
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        shadowPanel.add(panel, BorderLayout.CENTER);
        frame.add(shadowPanel);

        frame.setVisible(true);
    }
}
