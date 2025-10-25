package controller;

import view.AddStudentView;
import view.AlertView;
import model.Student;
import model.StudentDatabase;
import utils.Generator;

public class AddStudentController {
    private AddStudentView view;
    private StudentDatabase database;

    public AddStudentController(AddStudentView view, StudentDatabase database) {
        this.view = view;
        this.database = database;
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> handleAddStudent());
        view.getClearButton().addActionListener(e -> view.clearFields());
    }

    private void handleAddStudent() {
        try {
            Student student = new Student(
                Generator.generateStudentRandomId(),
                view.getNameField().getText(),
                Integer.parseInt(view.getAgeField().getText()),
                view.getGenderField().getSelectedItem().toString(),
                view.getDepartmentField().getSelectedItem().toString(),
                Double.parseDouble(view.getGpaField().getText())
            );

            String state = database.addStudent(student);

            if (!"OK".equals(state)) {
                new AlertView("Error", state);
                return;
            }

            new AlertView("Success", "Student added successfully!", () -> view.dispose());

        } catch (NumberFormatException ex) {
            new AlertView("Error", "Please enter valid numbers for Age and GPA!");
        } catch (Exception ex) {
            new AlertView("Error", "An unexpected error occurred!");
        }
    }
}
