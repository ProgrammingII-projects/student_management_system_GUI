/*package Unused;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.*;

public class StudentWidget {

    private Student student;
    private JPanel buttonPanel;
    private Dimension buttonSize;

    public studentWidget(Student st) {
        this.student = st;
        this.buttonPanel = new JPanel();
        this.buttonSize = new Dimension(950, 40); // Button width set to 900
       
        setupPanel();
    }

    // Setup the student widget display panel (single button with student summary)
    private void setupPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        String label = student.getStudentID() + "                  " + student.getName() + "                                                                                                                                                                                                                  " + student.getGPA();
        JButton button = new JButton(label);
        button.setPreferredSize(this.buttonSize); // Use the buttonSize with width 900
        buttonPanel.add(button);
        buttonPanel.setPreferredSize(new Dimension(900, 50)); // Set preferred size for the panel
    }

    // Return the widget's JPanel for use in other views (e.g., displayStudent)
    public JPanel getPanel() {
        return buttonPanel;
    }
}
*/