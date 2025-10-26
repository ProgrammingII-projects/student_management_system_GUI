package view;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import controller.DashboardController;
import java.awt.*;
import model.Student;
import model.StudentDatabase;

public class TableTemplate extends JFrame {

    StudentDatabase database = new StudentDatabase("model/students.txt");
    private DashboardController controller;

    public TableTemplate(DashboardController controller)
    {
        this.controller = controller;
    }

    public void display(String text){

        ArrayList<Student> students = database.getRecords();

        JFrame frame = new JFrame("Simple Swing Table");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add "Action" column with button in each row
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
            rows[i][6] = text;  // Placeholder value for button
        }

        JTable table = new JTable(rows, columns) {
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Only "Action" column is editable
            }
        };

        // Button renderer for the "Action" column
        table.getColumn("Action").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton(text);
                if (isSelected) {
                    button.setBackground(table.getSelectionBackground());
                    button.setForeground(table.getSelectionForeground());
                } else {
                    button.setBackground(UIManager.getColor("Button.background"));
                    button.setForeground(table.getForeground());
                }
                return button;
            }
        });

        // Button editor for the "Action" column
        class ButtonEditor extends DefaultCellEditor {
            private JButton button;
            private int currentRow = -1;
            private JTable tableRef;

            
            public ButtonEditor() {
                super(new JCheckBox()); // required per DefaultCellEditor constructor Show 🔎
                button = new JButton(text);
                button.addActionListener(e -> {
                    if (currentRow >= 0 && currentRow < students.size()) {
                        if (text.equals( "Delete ❌"))
                        {
                        frame.dispose();
                        controller.deleteStudent(String.valueOf(students.get(currentRow).getStudentID()));
                       
                        TableTemplate t = new TableTemplate(controller);
                        t.display(text);
                        }
                        else{
                        frame.dispose();
                        new DisplayStudent(students.get(currentRow), controller,2);
                        }
                    }
                    fireEditingStopped(); 
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                currentRow = row;
                tableRef = table;
                return button;
            }

            @Override
            public Object getCellEditorValue() {
                return text;
            }
        }

        table.getColumn("Action").setCellEditor(new ButtonEditor());

        // ===== Add Back Button =====
        JPanel bottomPanel = new JPanel();
        JButton backButton = new JButton("Back");
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(backButton);

        backButton.addActionListener(e -> {
            frame.dispose();
        });

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setSize(1000, 400);
        frame.setVisible(true);

    }

}