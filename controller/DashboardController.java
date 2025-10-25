package controller;

import view.DashboardView;
import view.AddStudentView;
import view.AlertView;
import view.*;
import model.Student;
import model.StudentDatabase;

import javax.swing.*;

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
                }
        );
        view.getDeleteButton().addActionListener(e -> openDeleteWindow());
        view.getSearchButton().addActionListener(e -> openSearchWindow());
        view.getViewButton().addActionListener(e -> new AlertView("hello","View clicked!"));
        view.getExitButton().addActionListener(e -> System.exit(0));
        view.getLogoutButton().addActionListener(e -> {
            view.dispose();
            new AlertView("hello", "Logged out successfully!");
        });
    }

    private void openSearchWindow() {
        SearchStudent searchView = new SearchStudent(this);
        searchView.setVisible(true);
    }
    private void openDeleteWindow() {
        DeleteStudent deleteView = new DeleteStudent(this);
        deleteView.setVisible(true);
    }
   
    // methode to add student to the database
    /* 
    public void addStudent(Student student) {
        Student s = new Student(student.getStudentID(), student.getName(), student.getAge(),
                student.getGender(), student.getDepartment(), student.getGPA());
        String state = database.addStudent(s);
        if (state != "OK") {
            new AlertView("Error", state);
            return;
        }
        new AlertView("Success", "Student added successfully!");
    }*/
    public void deleteStudent(String input) {
        if (input.isEmpty()) {
            new AlertView("Error", "Please enter a Student ID!");
            return;
        }

        try {
            int id = Integer.parseInt(input);

            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete student with ID: " + id + "?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                if (database.deleteStudent(id)) {
                    new AlertView("Success", "Student deleted successfully!");
                } else {
                    new AlertView("Error", "Student not found or not deleted!");
                }
            }
        } catch (NumberFormatException ex) {
            new AlertView("Error", "Student ID must be a number!");
        }
    }

    public void searchStudent(String input) {
        if (input.isEmpty()) {
            new AlertView("Error", "Please enter a Student ID!");
            return;
        }

        try {
            int id = Integer.parseInt(input);
            Student student = database.searchStudent(id);

            if (student != null) {
               new DisplayStudent(student);

            } else {
                new AlertView("Error", "Student not found!");
            }
        } catch (NumberFormatException ex) {
            new AlertView("Error", "Student ID must be a number!");
        }
    }
}


