package utils;

import javax.swing.*;
import java.awt.*;


public class Alert {

    public String text;

    public Alert(String text)
    {
        this.text = text;
        display();
    }

    public void display() {
        JFrame frame = new JFrame(text);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JLabel label = new JLabel(this.text, SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> frame.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
