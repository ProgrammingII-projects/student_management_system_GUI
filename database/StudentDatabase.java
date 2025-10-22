package database;

import Student.Student;
import java.io.*;
import java.util.*;

public class StudentDatabase {

    private ArrayList<Student> records = new ArrayList<>();
    private String fileName;

    public StudentDatabase(String fileName) {
        this.fileName = fileName;
    }

    private Student createRecordFrom(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        String fullName = data[1];
        int age = Integer.parseInt(data[2]);
        String gender = data[3];
        String department = data[4];
        double gpa = Double.parseDouble(data[5]);
        return new Student(id, fullName, age, gender, department, gpa);
    }

    public ArrayList<Student> returnAllRecords() {
        return records;
    }


    public void readFromFile() {
        records.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    records.add(createRecordFrom(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + fileName);
        }
    }

    public void insertRecord(Student student) {
        records.add(student);
    }


    public void deleteRecord(int id) {
        records.removeIf(student -> student.getStudentID() == id);
    }


    public boolean contains(int id) {
        for (Student s : records) {
            if (s.getStudentID() == id)
                return true;
        }
        return false;
    }

    public Student getRecord(int id) {
        for (Student s : records) {
            if (s.getStudentID() == id)
                return s;
        }
        return null;
    }

    public void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : records) {
                bufferedWriter.write(s.lineRepresentation());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + fileName);
        }
    }
    public boolean editStudent(int id, String newFullName, int newAge, String newGender, String newDepartment, double newGPA) {
        for (Student s : records) {
            if (s.getStudentID() == id) {
                s.setName(newFullName);
                s.setAge(newAge);
                s.setGender(newGender);
                s.setDepartment(newDepartment);
                s.setGPA(newGPA);
                saveToFile();
                return true;
            }
        }
        return false;
    }
}
