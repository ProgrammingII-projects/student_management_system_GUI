package view;

import view.displayStudent;

import javax.swing.JFrame;

import model.*;


public class test {
    public static void main(String[] args) {

        JFrame frame;
        frame = new JFrame("display student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        Student st = new Student(10043, "Ziad gebril", 20, "Male", "Compu & Communications", 3.54);
        //new displayStudent(st);

        
        studentWidget wid = new studentWidget(st,frame);
        wid.display();
    }
}
