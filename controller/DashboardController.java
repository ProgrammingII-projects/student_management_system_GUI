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
    private StudentDatabase database;

    public DashboardController(DashboardView view, StudentDatabase database) {
        this.view = view;
        this.database = database;
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(

           e -> {
                    final AddStudentView addStudentView = new AddStudentView();
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

    public void openSearchWindow() {
        SearchStudent searchView = new SearchStudent(this);
        searchView.setVisible(true);
    }
    public void openDeleteWindow() {
        DeleteStudent deleteView = new DeleteStudent(this);
        deleteView.setVisible(true);
    }
   
    public void deleteStudent(String ID) {
        if (ID.isEmpty()) {
            new AlertView("Error", "Please enter a Student ID!");
            return;
        }

        try {
            int id = Integer.parseInt(ID);

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

    public void searchStudent(String ID) {
        if (ID.isEmpty()) {
            new AlertView("Error", "Please enter a Student ID!");
            return;
        }

        try {
            int id = Integer.parseInt(ID);
            Student student = database.searchStudent(id);

            if (student != null) {
               new DisplayStudent(student,this);

            } else {
                new AlertView("Error", "Student not found!");
            }
        } catch (NumberFormatException ex) {
            new AlertView("Error", "Student ID must be a number!");
        }
    }
}


