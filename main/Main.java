package main;

import controller.DashboardController;
import model.StudentDatabase;
import view.DashboardView;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase("model/students.txt");

        DashboardView dashboardView = new DashboardView();
        new DashboardController(dashboardView, database);
    }
}
