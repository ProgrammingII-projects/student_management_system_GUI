package view;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import controller.DashboardController;
import model.Student;
import model.StudentDatabase;

public class TableTemplate extends JFrame {

    private StudentDatabase database = new StudentDatabase("model/students.txt");
    private DashboardController controller;

    public TableTemplate(DashboardController controller) {
        this.controller = controller;
    }

    public void display(String text) {
        ArrayList<Student> students = database.getRecords();

        JFrame frame = new JFrame("Student Table - " + text);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(10, 25, 74)); // dark blue

        // ===== Table Setup =====
        String[] columns = { "ID", "Name", "Age", "Gender", "Department", "GPA", "Action" };
        Object[][] rows = new Object[students.size()][7];

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            rows[i][0] = s.getStudentID();
            rows[i][1] = s.getName();
            rows[i][2] = s.getAge();
            rows[i][3] = s.getGender();
            rows[i][4] = s.getDepartment();
            rows[i][5] = s.getGPA();
            rows[i][6] = text; // Button label
        }

        JTable table = new JTable(rows, columns) {
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };

        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(35);
        table.setBackground(new Color(20, 40, 100));
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(70, 90, 160));

        // ===== Table Header Styling =====
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(30, 60, 130));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        // ===== Button Renderer =====
        table.getColumn("Action").setCellRenderer((tbl, value, isSelected, hasFocus, row, col) -> {
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.BOLD, 13));
            button.setFocusPainted(false);
            button.setForeground(Color.WHITE);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (text.equals("Delete ")) {
                button.setBackground(new Color(204, 0, 0));
            } else {
                button.setBackground(new Color(0, 153, 51));
            }

            if (isSelected) {
                button.setBackground(button.getBackground().darker());
            }

            return button;
        });

        // ===== Button Editor =====
        class ButtonEditor extends DefaultCellEditor {
            private JButton button;
            private int currentRow = -1;

            public ButtonEditor() {
                super(new JCheckBox());
                button = new JButton(text);
                button.setFont(new Font("Segoe UI", Font.BOLD, 13));
                button.setForeground(Color.WHITE);
                button.setFocusPainted(false);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createEmptyBorder());

                button.addActionListener(e -> {
                    if (currentRow >= 0 && currentRow < students.size()) {
                        if (text.equals("Delete ")) {
                            frame.dispose();
                            controller.deleteStudent(String.valueOf(students.get(currentRow).getStudentID()));
                            TableTemplate t = new TableTemplate(controller);
                            t.display(text);
                        } else {
                            frame.dispose();
                            new DisplayStudent(students.get(currentRow), controller, 2);
                        }
                    }
                    fireEditingStopped();
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
                currentRow = row;
                if (text.equals("Delete ")) {
                    button.setBackground(new Color(204, 0, 0));
                } else {
                    button.setBackground(new Color(0, 153, 51));
                }
                return button;
            }

            @Override
            public Object getCellEditorValue() {
                return text;
            }
        }

        table.getColumn("Action").setCellEditor(new ButtonEditor());

        // ===== ScrollPane =====
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(new Color(10, 25, 74));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== Bottom Panel =====
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(10, 25, 74));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(120, 35));
        backButton.setBackground(new Color(100, 100, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(e -> frame.dispose());

        bottomPanel.add(backButton);

        // ===== Add to Frame =====
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
