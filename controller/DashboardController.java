package controller;

import view.DashboardView;
import view.AlertView;
import model.Student;
import model.StudentDatabase;
import view.SearchStudent;

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
            e -> 
          /*  {
            Student student = view.getStudentDetailsFromInput();
            if (student != null) {
                addStudent(student);
            }
        }*/ new AlertView("hello","Add clicked!")
        );
        view.getDeleteButton().addActionListener(e -> new AlertView("hello","Delete clicked!"));
        view.getSearchButton().addActionListener(e -> openSearchWindow());
        view.getViewButton().addActionListener(e -> new AlertView("hello","View clicked!"));
        view.getExitButton().addActionListener(e -> System.exit(0));
        view.getLogoutButton().addActionListener(e -> {
            view.dispose();
            new AlertView("hello","Logged out successfully!");
        });
    }
    private void openSearchWindow() {
        SearchStudent searchView = new SearchStudent(this);
        searchView.setVisible(true);
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
    public void deleteStudent(Student student) {

          if(database.deleteStudent(student.getStudentID()))
          {
              new AlertView("Success", "Student deleted successfully!");

          }
          else
          {
              new AlertView("Error", "Student not deleted!");
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
                JOptionPane.showMessageDialog(
                        null,
                        "Student Found:\n\n" +
                                "ID: " + student.getStudentID() + "\n" +
                                "Name: " + student.getName() + "\n" +
                                "Age: " + student.getAge() + "\n" +
                                "Gender: " + student.getGender() + "\n" +
                                "Department: " + student.getDepartment() + "\n" +
                                "GPA: " + student.getGPA(),
                        "Search Result",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                new AlertView("Error", "Student not found!");
            }
        } catch (NumberFormatException ex) {
            new AlertView("Error", "Student ID must be a number!");
        }
    }
}


