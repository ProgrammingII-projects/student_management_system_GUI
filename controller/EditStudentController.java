package controller;

import model.Student;
import model.StudentDatabase;
import view.EditStudentView;
import view.AlertView;

public class EditStudentController {
    private EditStudentView view;
    private StudentDatabase database;

    public EditStudentController(EditStudentView view, StudentDatabase database) {
        this.view = view;
        this.database = database;
        initController();
    }

    private void initController() {
        // Handle Update Button
        view.getUpdateButton().addActionListener(e -> handleUpdateStudent());

        // Handle Cancel Button
        view.getCancelButton().addActionListener(e -> view.dispose());
    }

    private void handleUpdateStudent() {
        try {
            String idStr = view.getIdField().getText().trim();
            String name = view.getNameField().getText().trim();
            String ageStr = view.getAgeField().getText().trim();
            String gpaStr = view.getGpaField().getText().trim();
            String gender = (String) view.getGenderField().getSelectedItem();
            String department = (String) view.getDepartmentField().getSelectedItem();

            // Validate input first
            String validation = Student.validateTexString(name, ageStr, gpaStr);
            if (!"OK".equals(validation)) {
                new AlertView("Error", validation);
                return;
            }

            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);
            double gpa = Double.parseDouble(gpaStr);

            boolean success = database.editStudent(id, name, age, gender, department, gpa);

            if (success) {
                new AlertView("Success", "Student updated successfully!", () -> view.dispose());
            } else {
                new AlertView("Error", "Failed to update student. Check ID or inputs.");
            }

        } catch (NumberFormatException ex) {
            new AlertView("Error", "Please enter valid numbers for ID, Age, and GPA!");
        } catch (Exception ex) {
            new AlertView("Error", "An unexpected error occurred!");
        }
    }
}
