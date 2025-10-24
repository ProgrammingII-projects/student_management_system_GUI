package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.Alert;

public class displayStudent {
    
    private static JFrame frame;
    private int studentID;
    private String Name;
    private int age;
    private String gender;
    private String department;
    private double GPA;

   public displayStudent()
   {
    display();
   }
 
 /*  setStudentID(studentID);
   setName(name);
   setAge(age);
   setGender(gender);
   setDepartment(department);
   setGPA(GPA);
   */
    
   public void display() {

    frame = new JFrame("Login Form");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 500);

    frame.setLayout(new GridLayout(2, 2, 5, 7));

    JLabel nameLabel = new JLabel(Name);
    JTextField nameField = new JTextField();
    
    frame.add(nameLabel);





}
}