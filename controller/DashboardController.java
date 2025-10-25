package controller;

import view.DashboardView;
import view.AlertView;
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
        view.getAddButton().addActionListener(e -> new AlertView("Add clicked!"));
        view.getDeleteButton().addActionListener(e -> new AlertView("Delete clicked!"));
        view.getSearchButton().addActionListener(e -> new AlertView("Search clicked!"));
        view.getViewButton().addActionListener(e -> new AlertView("View clicked!"));
        view.getExitButton().addActionListener(e -> System.exit(0));
        view.getLogoutButton().addActionListener(e -> {
            view.dispose();
            new AlertView("Logged out successfully!");
        });
    }
}
