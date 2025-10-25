package controller;

import view.DashboardView;
import view.AlertView;
import model.Student;
import model.StudentDatabase;

public class DashboardController {
    private DashboardView view;
    private StudentDatabase database;

    public DashboardController(DashboardView view, StudentDatabase database) {
        this.view = view;
        this.database = database;
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(
            e -> 
          /*  {
            Student student = view.getStudentDetailsFromInput();
            if (student != null) {
                addStudent(student);
            }
        }*/ new AlertView("hello","Add clicked!")
        );
        view.getDeleteButton().addActionListener(e -> new AlertView("hello","Delete clicked!"));
        view.getSearchButton().addActionListener(e -> new AlertView("hello","Search clicked!"));
        view.getViewButton().addActionListener(e -> new AlertView("hello","View clicked!"));
        view.getExitButton().addActionListener(e -> System.exit(0));
        view.getLogoutButton().addActionListener(e -> {
            view.dispose();
            new AlertView("hello","Logged out successfully!");
        });
    }
    // methode to add student to the database
    public void addStudent(Student student) {
        Student s = new Student(student.getStudentID(), student.getName(), student.getAge(),
                student.getGender(), student.getDepartment(), student.getGPA());
         String state = database.addStudent(s);
        if (state != "OK") {
            new AlertView("Error", state);
            return;
        }
        new AlertView("Success", "Student added successfully!" );
    }

}
