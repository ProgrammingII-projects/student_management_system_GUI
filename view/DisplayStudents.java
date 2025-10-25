package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

public class DisplayStudents {

    private static JFrame frame;
    Student student;
    StudentDatabase database;

    public DisplayStudents()
    {
        display();
    }

    public void display()
    {
        frame = new JFrame("display student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        int i = database.getRecords().size();

        frame.setLayout(new GridLayout(i, 2, 5, 1));

        for(i=0 ; i < i ; i++ )
        {
            
        }

    }
    
}
