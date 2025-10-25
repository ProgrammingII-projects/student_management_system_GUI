package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.*;

public class studentWidget {

    private Student student;
    private JPanel buttonPanel;
    private Dimension buttonSize;
    private static JFrame frame;

    public studentWidget(Student st,JFrame frame) {
        this.student = st;
        this.buttonPanel = new JPanel();
        this.frame = frame;
       
        setupPanel();
    }

    // Setup the student widget display panel (single button with student summary)
    private void setupPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
        String label = student.getStudentID() + "   " + student.getName() + "              " + student.getGPA();
        JButton button = new JButton(label);
        Dimension buttonSize = new Dimension(400, 40);
        button.setPreferredSize(buttonSize);
        buttonPanel.add(button);
    }

    // Return the widget's JPanel for use in other views (e.g., displayStudent)
    public JPanel getPanel() {
        return buttonPanel;
    }


      
        // Display the student widget (summary) above the buttons
        public void display(){
            Dimension buttonSize = new Dimension(900, 40);
        frame.add(getPanel());
        frame.add(buttonPanel);
        buttonPanel.setPreferredSize(this.buttonSize);
        
        frame.setVisible(true);

        }

}
