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
            String name = view.getNameField().getText();
            String ageStr = view.getAgeField().getText();
            String gpaStr = view.getGpaField().getText();

            String validation = Student.validateTexString(name, ageStr, gpaStr);
            if (!"OK".equals(validation)) {
                new AlertView("Error", validation);
                return;
            }

            int age = Integer.parseInt(ageStr);
            double gpa = Double.parseDouble(gpaStr);

            int id = Generator.generateStudentRandomId();
            Student student = new Student(
                    id,
                    name,
                    age,
                    view.getGenderField().getSelectedItem().toString(),
                    view.getDepartmentField().getSelectedItem().toString(),
                    gpa);

            String state = database.addStudent(student);
            if (!"OK".equals(state)) {
                new AlertView("Error", state);
                return;
            }

            new AlertView("Success", "Student added successfully\nwith ID: " + id, () -> view.dispose());

        } catch (Exception ex) {
            new AlertView("Error", "An unexpected error occurred!");
        }
    }

}
