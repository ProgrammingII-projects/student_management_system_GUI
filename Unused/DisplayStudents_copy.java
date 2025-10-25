/*package Unused;


import javax.swing.*;
import java.util.ArrayList;

import model.*;

public class DisplayStudents {

    private JPanel contentPanel;
    StudentDatabase database;
    ArrayList<Student> students;

    public DisplayStudents(StudentDatabase database , JPanel contentPanel)
    {
        this.contentPanel = contentPanel;
        this.database = database;
        students = database.getRecords();
        display();
    }

    


    public void display()
    {

        int size = students.size();
        

        

        for(int i=0 ; i < size ; i++ )
        {
            studentWidget wid = new studentWidget(students.get(i));
            contentPanel.add(wid.getPanel());
        }
        
        // Refresh the content panel to show the new components
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
*/