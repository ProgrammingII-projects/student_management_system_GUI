package controller;

import view.DashboardView;
import view.AddStudentView;
import view.AlertView;
import model.Student;
import model.StudentDatabase;
import utils.Generator;

public class DashboardController {
    private DashboardView view;
    private AddStudentView addStudentView;
    private StudentDatabase database;

    public DashboardController(DashboardView view, StudentDatabase database) {
        this.view = view;
        this.database = database;
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(
                e -> {
                    AddStudentView addStudentView = new AddStudentView();
                    new AddStudentController(addStudentView, database);
                });
        view.getDeleteButton().addActionListener(e -> new AlertView("hello", "Delete clicked!"));
        view.getSearchButton().addActionListener(e -> new AlertView("hello", "Search clicked!"));
        view.getViewButton().addActionListener(e -> new AlertView("hello", "View clicked!"));
        view.getExitButton().addActionListener(e -> System.exit(0));
        view.getLogoutButton().addActionListener(e -> {
            view.dispose();
            new AlertView("hello", "Logged out successfully!");
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
        new AlertView("Success", "Student added successfully!");
    }

    public void deleteStudent(Student student) {

        if (database.deleteStudent(student.getStudentID())) {
            new AlertView("Success", "Student deleted successfully!");

        } else {
            new AlertView("Error", "Student not deleted!");
        }
    }

}
