package controller;

import view.LoginView;
import view.AlertView;
import view.DashboardView;
import model.StudentDatabase;

public class LoginController {
    private LoginView view;
    private StudentDatabase database;

    public LoginController(LoginView view, StudentDatabase database) {
        this.view = view;
        this.database = database;
        initController();
    }

    private void initController() {
        view.getLoginButton().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = view.getUsernameField().getText();
        String password = new String(view.getPasswordField().getPassword());

        if (username.equals("admin") && password.equals("admin")) {
            view.dispose();
            new AlertView("hello","Login Successful!", () -> {
            DashboardView dashboardView = new DashboardView();
            new DashboardController(dashboardView, database);
        });
           // DashboardView dashboardView = new DashboardView();
          //  new DashboardController(dashboardView, database);
        } else {
            new AlertView("hello","Invalid Username or Password!");
        }
    }
}
