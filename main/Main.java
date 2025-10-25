package main;

import controller.LoginController;
import model.StudentDatabase;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase("data/students.txt");
        LoginView loginView = new LoginView();
        new LoginController(loginView, database);
    }
}
