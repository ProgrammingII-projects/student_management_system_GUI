package view;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JButton;

import model.*;
public class studentWidget {
    
    private int studentID;
    private String Name;
    private double GPA;

    public studentWidget(Student st)
    {
        GPA = st.getGPA();
        Name = st.getName();
        studentID = st.getStudentID();
    }

    public void display()
    {
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        
        JButton button = new JButton(studentID + "   " + Name + "              " + GPA);
        Dimension buttonSize = new Dimension(400, 40);
        button.setPreferredSize(buttonSize);
        buttonPanel.add(button);
        

    }






}
