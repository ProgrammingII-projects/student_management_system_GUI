package view;

import javax.swing.*;
import java.awt.*;

public class CloseButton {


    public static JButton create(JFrame frame) {
        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(new Color(204, 0, 0)); // red
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeButton.setBounds(frame.getWidth() - 45, 10, 35, 25);
        closeButton.addActionListener(e -> frame.dispose());
        return closeButton;
    }
}
