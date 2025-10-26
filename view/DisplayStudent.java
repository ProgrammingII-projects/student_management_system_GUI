package view;

import javax.swing.*;

import controller.DashboardController;

import java.awt.*;
import java.awt.event.*;

import controller.EditStudentController;
import model.*;

public class DisplayStudent {

    private static JFrame frame;
    private Student student;
    private DashboardController controller;
    int flag = 0;


    public DisplayStudent(Student student, DashboardController controller,int flag) {
        this.student = student;
        this.controller = controller;
        this.flag=flag;
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        studentWidget st = new studentWidget(student,frame);
        frame.add(st.getPanel());


       */
        frame.add(buttonPanel);



        EditButton.addActionListener(e -> {
            frame.dispose(); // close current display
            EditStudentView editView = new EditStudentView(student);
            new EditStudentController(editView, controller.getDatabase()); // use same DB
            
        });


        DeleteButton.addActionListener(e -> {
                controller.deleteStudent(String.valueOf(student.getStudentID()));
                frame.dispose(); // close after delete
                if(flag == 1){
                TableTemplate t = new TableTemplate(controller); 
                t.display("Delete ❌");
                }
                else if(flag==2){
                    TableTemplate t = new TableTemplate(controller); 
                    t.display("Show 🔎");
        }
        });

        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(flag==2){
                    TableTemplate t = new TableTemplate(controller); 
                    t.display("Show 🔎");
            }
            }
        });

        frame.setVisible(true);
    }
}