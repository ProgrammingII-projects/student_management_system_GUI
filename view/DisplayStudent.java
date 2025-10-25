package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

public class displayStudent {

    private static JFrame frame;
    Student student;

    public displayStudent(Student student) {
        this.student = student;
        
        display();
    }

    /*
     * setStudentID(studentID);
     * setName(name);
     * setAge(age);
     * setGender(gender);
     * setDepartment(department);
     * setGPA(GPA);
     */

    public void display() {

        frame = new JFrame("display student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        frame.setLayout(new GridLayout(7,2 , 5, 1));

        
        JLabel nameLabel = new JLabel("       Name : ");
        JLabel nameText = new JLabel(student.getName());

        JLabel IDLabel = new JLabel("       ID : ");
        JLabel IDText = new JLabel(String.valueOf(student.getStudentID()));

        JLabel AgeLabel = new JLabel("       Age : ");
        JLabel AgeText = new JLabel(String.valueOf(student.getAge()));

        JLabel GenderLabel = new JLabel("       Gender : ");
        JLabel GenderText = new JLabel(student.getGender());

        JLabel DepartmentLabel = new JLabel("       Department : ");
        JLabel DepartmentText = new JLabel(student.getDepartment());

        JLabel GPALabel = new JLabel("       GPA : ");
        JLabel GPAText = new JLabel(String.valueOf(student.getGPA()));


        
        frame.add(nameLabel);
        frame.add(nameText);

        frame.add(GenderLabel);
        frame.add(GenderText);

        frame.add(IDLabel);
        frame.add(IDText);

        frame.add(AgeLabel);
        frame.add(AgeText);

        frame.add(DepartmentLabel);
        frame.add(DepartmentText);

        frame.add(GPALabel);
        frame.add(GPAText);



        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        
        
        JButton EditButton = new JButton("Edit Student");
        JButton DeleteButton = new JButton("Delete student");
        JButton BackButton = new JButton("Back");
        
        Dimension buttonSize = new Dimension(120, 40); // standard size of buttons we will use
        EditButton.setPreferredSize(buttonSize);
        DeleteButton.setPreferredSize(buttonSize);
        BackButton.setPreferredSize(buttonSize);
        
        buttonPanel.add(EditButton);
        buttonPanel.add(DeleteButton);
        buttonPanel.add(BackButton);

        /* 
        // Display the student widget (summary) above the buttons
        studentWidget st = new studentWidget(student);
        frame.add(st.getPanel());

        */
        frame.add(buttonPanel);

       
        

       
        EditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AlertView("Under construction.....", null);
            }
        });

        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AlertView("Under construction.....",null);
            }
        });

        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AlertView("Under construction.....", null);
            }
        });

        frame.setVisible(true);
    }
}