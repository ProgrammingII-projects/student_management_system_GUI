package view;

import java.util.ArrayList;

import javax.swing.*;

import model.Student;
import model.StudentDatabase;

public class TableTemplate {

    public TableTemplate()
    {
        display();
    }

    public void display(){
        
        StudentDatabase database = new StudentDatabase("model/students.txt");
        ArrayList<Student> students = database.getRecords();
        

        JFrame frame = new JFrame("Simple Swing Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add "Action" column with button in each row
        String[] columns = { "ID", "Name", "Age", "Gender", "Department", "Action" };
        Object[][] rows = new Object[students.size()][6];

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            rows[i][0] = s.getStudentID();
            rows[i][1] = s.getName();
            rows[i][2] = s.getAge();
            rows[i][3] = s.getGender();
            rows[i][4] = s.getDepartment();
            rows[i][5] = "Show 🔎";  // Placeholder for the button in the "Action" column
        }

        JTable table = new JTable(rows, columns) {
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Only "Action" column is editable
            }
        };



        // Proper button renderer for Action column
        table.getColumn("Action").setCellRenderer((table1, value, isSelected, hasFocus, row, column) -> {
            JButton button = new JButton("Show 🔎");
            return button;
        });

        // Proper button editor using DefaultCellEditor with a JCheckBox, but placing button inside
        class ButtonEditor extends DefaultCellEditor {
            private JButton button = new JButton("Show 🔎");
            public ButtonEditor() {
                super(new JCheckBox());
                button.addActionListener(e -> {
                    int row = table.getEditingRow();
                    JOptionPane.showMessageDialog(frame, "Show button clicked for row: " + (row + 1));
                    fireEditingStopped();
                });
            }

            public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                return button;
            }

            public Object getCellEditorValue() {
                return "Show 🔎";
            }
        }
        table.getColumn("Action").setCellEditor(new ButtonEditor());

        frame.add(new JScrollPane(table));
        frame.setSize(1000, 400);
        frame.setVisible(true);

    }
}
