package main;

import controller.DashboardController;
import controller.LoginController;
import model.StudentDatabase;
import view.DashboardView;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase("data/students.txt");

        DashboardView dashboardView = new DashboardView();
        new DashboardController(dashboardView, database);
    }
}
