package controller;

import view.DashboardView;
import view.AddStudentView;
import view.AlertView;
import view.*;
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

           e -> {
                    final AddStudentView addStudentView = new AddStudentView();
                    new AddStudentController(addStudentView, database);
                }
        );
        view.getDeleteButton().addActionListener(e -> openDeleteWindow());
        view.getSearchButton().addActionListener(e -> openSearchWindow());
        view.getViewButton().addActionListener(e -> OpenViewWindow());
        view.getExitButton().addActionListener(e -> System.exit(0));
        view.getLogoutButton().addActionListener(e -> {
            view.dispose();
            new AlertView("hello", "Logged out successfully!");
            LoginView loginView = new LoginView();
            new LoginController(loginView, database);
        });
    }

    public void openSearchWindow() {
        SearchStudent searchView = new SearchStudent(this);
        searchView.setVisible(true);
    }

    public void OpenViewWindow() {
        TableTemplate StudentView = new TableTemplate(this);
        StudentView.display("Show");
        
    }


    public void openDeleteWindow() {
        DeleteStudent deleteView = new DeleteStudent(this);
        deleteView.setVisible(true);
    }

    public void deleteStudent(String ID,int flag) {
        if (ID.isEmpty()) {
            new AlertView("Error", "Please enter a Student ID!");
            return;
        }

        try {
            int id = Integer.parseInt(ID);

            // Custom confirmation dialog
            new AlertView(
                    "Confirm Delete",
                    "Are you sure you want to delete student with ID: " + id + "?",
                    () -> {
                        if (database.deleteStudent(id)) {
                            new AlertView("Success", "Student deleted successfully!");
                            if(flag==1)
                            {
                                new TableTemplate(DashboardController.this).display("Delete");
                            }
                            else if(flag==2)
                            {
                                new TableTemplate(DashboardController.this).display("Show ");
                            }

                        } else {
                            new AlertView("Error", "Student not found or not deleted!");
                        }

                    },
                    "confirm"

            );


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
               new DisplayStudent(student,this,0);

            } else {
                new AlertView("Error", "Student not found!");
            }
        } catch (NumberFormatException ex) {
            new AlertView("Error", "Student ID must be a number!");
        }
    }
    public void editStudent(int id, String name, int age, String gender, String department, double gpa) {
        boolean updated = database.editStudent(id, name, age, gender, department, gpa);

        if (updated) {
            new AlertView("Success", "Student details updated successfully!");
        } else {
            new AlertView("Error", "Failed to update student. Please check the ID and inputs!");
        }
    }
    public StudentDatabase getDatabase() {
        return database;
    }

}


