package view;

import view.displayStudent;
import model.*;


public class test {
    public static void main(String[] args) {
        
        Student st = new Student(10043, "Ziad gebril", 20, "Male", "Compu & Communications", 3.54);
        new displayStudent(st);
    }
}
