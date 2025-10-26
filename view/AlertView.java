
package view;

import javax.swing.*;
import java.awt.*;

public class AlertView {

    private final Color backgroundColor = new Color(10, 25, 47);
    private final Color accentColor = new Color(41, 128, 255);
    private final Color textColor = new Color(230, 230, 230);

    public AlertView(String title, String text) {
        this(title, text, null, "info");
    }

    public AlertView(String title, String text, Runnable onOk) {
        this(title, text, onOk, "info");
    }


    public AlertView(String title, String text, Runnable onOk, String type) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        frame.getContentPane().setBackground(backgroundColor);

        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(backgroundColor);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        titleLabel.setForeground(accentColor);

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(textColor);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(backgroundColor);

        if ("confirm".equalsIgnoreCase(type)) {
            // Yes / Cancel buttons
            JButton yesButton = createButton("Yes", new Color(0, 153, 51));
            JButton cancelButton = createButton("Cancel", new Color(204, 0, 0));

            yesButton.addActionListener(e -> {
                frame.dispose();
                if (onOk != null) onOk.run();
            });

            cancelButton.addActionListener(e -> frame.dispose());

            buttonPanel.add(yesButton);
            buttonPanel.add(cancelButton);
        } else {
            // OK only
            JButton okButton = createButton("OK", accentColor);
            okButton.addActionListener(e -> {
                frame.dispose();
                if (onOk != null) onOk.run();
            });
            buttonPanel.add(okButton);
        }

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }
}

