package view;

import javax.swing.*;
import java.awt.*;

public class AlertView {
    //you cann use this constructor if you don't need to execute any action on OK button click
    public AlertView(String title ,String text) {
        this(title ,text, null);
    }
    
    //you can use this constructor to execute an action on OK button click
    public AlertView(String title, String text, Runnable onOk) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            frame.dispose();
            if(onOk != null) onOk.run();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
