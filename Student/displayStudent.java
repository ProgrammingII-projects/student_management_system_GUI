package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.Alert;

public class displayStudent {

    private static JFrame frame;

    private String Name;
    private int studentID;
    private int age;
    private String gender;
    private String department;
    private double GPA;

    public displayStudent(Student student) {
        Name = student.getName();
        studentID = student.getStudentID();
        age = student.getAge();
        gender = student.getGender();
        department = student.getDepartment();
        GPA = student.getGPA();
        
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
        JLabel nameText = new JLabel(Name);

        JLabel IDLabel = new JLabel("       ID : ");
        JLabel IDText = new JLabel(String.valueOf(studentID));

        JLabel AgeLabel = new JLabel("       Age : ");
        JLabel AgeText = new JLabel(String.valueOf(age));

        JLabel GenderLabel = new JLabel("       Gender : ");
        JLabel GenderText = new JLabel(gender);

        JLabel DepartmentLabel = new JLabel("       Department : ");
        JLabel DepartmentText = new JLabel(department);

        JLabel GPALabel = new JLabel("       GPA : ");
        JLabel GPAText = new JLabel(String.valueOf(GPA));


        
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

       
        frame.add(buttonPanel);

       
        EditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Alert("Under construction.....");
            }
        });

        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Alert("Under construction.....");
            }
        });

        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Alert("Under construction.....");
            }
        });










        frame.setVisible(true);
    }
}