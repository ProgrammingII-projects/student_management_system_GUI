package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import controller.DashboardController;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Student;
import model.StudentDatabase;
import java.util.List;

public class TableTemplate extends JFrame {

    private StudentDatabase database = new StudentDatabase("model/students.txt");
    private DashboardController controller;

    public TableTemplate(DashboardController controller) {
        this.controller = controller;
    }

    private Object[][] prepareRows(List<Student> students, String text) {
        Object[][] rows = new Object[students.size()][7];
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            rows[i][0] = s.getStudentID();
            rows[i][1] = s.getName();
            rows[i][2] = s.getAge();
            rows[i][3] = s.getGender();
            rows[i][4] = s.getDepartment();
            rows[i][5] = s.getGPA();
            rows[i][6] = text;
        }
        return rows;
    }

    public void display(String text) {

        ArrayList<Student> students = database.getRecords();

        JFrame frame = new JFrame("Student Management - " + text);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(10, 25, 74));
        frame.setLayout(new BorderLayout());

        // ======== SEARCH BAR PANEL ========
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(new Color(10, 25, 74));
        JLabel searchLabel = new JLabel("Search by ID:");
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        JTextField searchField = new JTextField(15);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setBackground(new Color(25, 50, 120));
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);

        // ======== TABLE SETUP ========
        String[] columns = {"ID", "Name", "Age", "Gender", "Department", "GPA", "Action"};
        Object[][] rows = prepareRows(students, text);

        JTable table = new JTable(rows, columns) {
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };

        // ======== TABLE STYLE ========
        table.setBackground(new Color(15, 35, 90));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(35);
        table.setGridColor(new Color(40, 60, 120));
        table.setSelectionBackground(new Color(30, 60, 130));
        table.setSelectionForeground(Color.WHITE);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(20, 40, 100));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setReorderingAllowed(false);

        // Alternate row color
        DefaultTableCellRenderer alternate = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(20, 45, 110) : new Color(25, 50, 120));
                    c.setForeground(Color.WHITE);
                }
                return c;
            }
        };
        for (int i = 0; i < table.getColumnCount() - 1; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(alternate);
        }

        // ======== BUTTON RENDERER ========
        table.getColumn("Action").setCellRenderer((tbl, value, isSelected, hasFocus, row, col) -> {
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.BOLD, 13));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            if (text.equals("Delete ❌")) {
                button.setBackground(new Color(204, 0, 0));
            } else {
                button.setBackground(new Color(0, 153, 51));
            }
            if (isSelected) button.setBackground(button.getBackground().darker());
            return button;
        });
        

        // ======== BUTTON EDITOR ========
        class ButtonEditor extends DefaultCellEditor {
            private JButton button;
            private int currentRow = -1;
            private List<Student> currentStudents;

            public ButtonEditor(List<Student> currentStudents) {
                super(new JCheckBox());
                this.currentStudents = currentStudents;
                button = new JButton(text);
                button.setFont(new Font("Segoe UI", Font.BOLD, 13));
                button.setForeground(Color.WHITE);
                button.setFocusPainted(false);
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBackground(text.equals("Delete ❌") ? new Color(204, 0, 0) : new Color(0, 153, 51));

                button.addActionListener(e -> {
                    if (currentRow >= 0 && currentRow < currentStudents.size()) {
                        if (text.equals("Delete ❌")) {
                            frame.dispose();
                            controller.deleteStudent(String.valueOf(currentStudents.get(currentRow).getStudentID()));
                            TableTemplate t = new TableTemplate(controller);
                            t.display(text);
                        } else {
                            frame.dispose();
                            new DisplayStudent(currentStudents.get(currentRow), controller, 2);
                        }
                    }
                    fireEditingStopped();
                });
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                currentRow = row;
                return button;
            }

            @Override
            public Object getCellEditorValue() {
                return text;
            }
        }

        table.getColumn("Action").setCellEditor(new ButtonEditor(students));

        // ======== DYNAMIC SEARCH ========
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            private void filterAndUpdate() {
                String input = searchField.getText().trim();
                List<Student> filtered;
                if (input.isEmpty()) {
                    filtered = students;
                } else {
                    filtered = new ArrayList<>();
                    for (Student s : students) {
                        if (String.valueOf(s.getStudentID()).startsWith(input)) {
                            filtered.add(s);
                        }
                    }
                }

                Object[][] newRows = prepareRows(filtered, text);
                DefaultTableModel newModel = new DefaultTableModel(newRows, columns) {
                    public boolean isCellEditable(int row, int column) {
                        return column == 6;
                    }
                };
                table.setModel(newModel);

                // re-apply renderer/editor
                for (int i = 0; i < table.getColumnCount() - 1; i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(alternate);
                }
                table.getColumn("Action").setCellRenderer((tbl, val, sel, foc, r, c) -> {
                    JButton button = new JButton(text);
                    button.setFont(new Font("Segoe UI", Font.BOLD, 13));
                    button.setForeground(Color.WHITE);
                    button.setFocusPainted(false);
                    button.setBorder(BorderFactory.createEmptyBorder());
                    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    button.setBackground(text.equals("Delete ❌") ? new Color(204, 0, 0) : new Color(0, 153, 51));
                    if (sel) button.setBackground(button.getBackground().darker());
                    return button;
                });
                table.getColumn("Action").setCellEditor(new ButtonEditor(filtered));
            }

            @Override public void insertUpdate(DocumentEvent e) { filterAndUpdate(); }
            @Override public void removeUpdate(DocumentEvent e) { filterAndUpdate(); }
            @Override public void changedUpdate(DocumentEvent e) { filterAndUpdate(); }
        });

        // ======== BACK BUTTON ========
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(new Color(10, 25, 74));

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(120, 35));
        backButton.setBackground(new Color(204, 0, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(e -> frame.dispose());

        bottomPanel.add(backButton);

        // ======== ADD COMPONENTS ========
        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
