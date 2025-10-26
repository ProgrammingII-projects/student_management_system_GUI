package view;

import javax.swing.*;
import java.awt.event.*;
import controller.DashboardController;

public class DeleteStudent extends JFrame {
    private JTextField studentIdField;
    private JButton deleteButton;
    private DashboardController controller;

    public DeleteStudent(DashboardController controller) {
        this.controller = controller;
        MethodChoose();
    }


    public void MethodChoose(){

    JButton IDButton = new JButton("Delete by ID");
    JButton ChooseDeleteButton = new JButton("Delete from List");

    IDButton.setBounds(30, 30, 130, 35);
    ChooseDeleteButton.setBounds(170, 30, 130, 35);

    setTitle("Choose Delete Method");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(350, 130);
    setLayout(null);
    setLocationRelativeTo(null);

    add(IDButton);
    add(ChooseDeleteButton);

    IDButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            SearchDelete();
            setVisible(true);
        }
    });

    ChooseDeleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           dispose();    
            TableTemplate t = new TableTemplate(controller); 
            t.display("Delete ❌");
        }
    });

    setVisible(true);
    }


    public void SearchDelete(){
        getContentPane().removeAll();
        revalidate();                  
        repaint();   

        setTitle("Delete Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 180);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter Student ID:");
        label.setBounds(30, 30, 120, 25);
        add(label);

        studentIdField = new JTextField();
        studentIdField.setBounds(150, 30, 150, 25);
        add(studentIdField);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(110, 80, 120, 30);
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = studentIdField.getText().trim();
                controller.deleteStudent(input);
                dispose();
            }
        });
    }

    public void prefillStudentId(String id) {
        studentIdField.setText(id);
    }
}
