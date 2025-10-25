package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import model.*;

public class DisplayStudentsController {
    public static void main(String[] args) {
    

          JFrame frame;
          frame = new JFrame("display student");
          
          // display BIG word in the Center says "Students"
          JLabel titleLabel = new JLabel("STUDENTS", SwingConstants.CENTER);
          titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 48));

          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(1000, 600);
          frame.setLayout(new BorderLayout());

          StudentDatabase database = new StudentDatabase("model/students.txt");
          
          // Create a main panel to hold the title and scrollable content
          JPanel mainPanel = new JPanel(new BorderLayout());
          mainPanel.add(titleLabel, BorderLayout.NORTH);
          
          // Create header panel with column labels
          JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
          JLabel idLabel = new JLabel("ID");
          JLabel nameLabel = new JLabel("Name");
          JLabel gpaLabel = new JLabel("GPA");
          
          // Style the header labels
          idLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
          nameLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
          gpaLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
          
          // Set preferred sizes to match the student widget layout
          idLabel.setPreferredSize(new Dimension(100, 30));
          nameLabel.setPreferredSize(new Dimension(750, 30));
          gpaLabel.setPreferredSize(new Dimension(100, 30));
          
          headerPanel.add(idLabel);
          headerPanel.add(nameLabel);
          headerPanel.add(gpaLabel);
          headerPanel.setPreferredSize(new Dimension(900, 40));
          
          // Create a content panel for the student widgets
          JPanel contentPanel = new JPanel();
          contentPanel.setLayout(new GridLayout(0, 1, 5, 5)); // Single column layout with gaps
          
          // Create scroll pane
          JScrollPane scrollPane = new JScrollPane(contentPanel);
          scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          
          // Create a center panel to hold header and scrollable content
          JPanel centerPanel = new JPanel(new BorderLayout());
          centerPanel.add(headerPanel, BorderLayout.NORTH);
          centerPanel.add(scrollPane, BorderLayout.CENTER);
          
          mainPanel.add(centerPanel, BorderLayout.CENTER);
          frame.add(mainPanel);

          /* 
          Student st = new Student(10043, "Ziad gebril", 20, "Male",
          "Compu & Communications", 3.54);
          //new displayStudent(st);
          
          studentWidget wid = new studentWidget(st,frame);
          wid.display();
          */
          

        

        new DisplayStudents(database, contentPanel);
        frame.setVisible(true);

    }
}
