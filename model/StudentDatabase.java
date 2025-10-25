package model;

import java.io.*;
import java.util.*;

public class StudentDatabase {

    private ArrayList<Student> records = new ArrayList<>();
    private String fileName;

    // setters and getters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Student> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Student> records) {
        this.records = records;
    }

    public StudentDatabase(String fileName) {
        setFileName(fileName);
        readFromFile();
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

    public ArrayList<Student> viewStudents() {
        if (records.isEmpty() || records == null) {
            readFromFile();
        }
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

    // di btrabta3 goz2 mn el validation hena ba2i validation hayeb2a fi GUI we el controllers
    public String addStudent(Student student) {
        String validation = Student.validateTexString(student.getName(), String.valueOf(student.getAge()), String.valueOf(student.getGPA()));
        if(validation != "OK")
            return validation;
        records.add(student);
        saveToFile();
        return "OK";
    }

    public boolean deleteStudent(int id) {
        if (!contains(id))
            return false;

        records.removeIf(student -> student.getStudentID() == id);
        saveToFile();
        return true;
    }

    public boolean contains(int id) {
        for (Student s : records) {
            if (s.getStudentID() == id)
                return true;
        }
        return false;
    }

    public Student searchStudent(int id) {
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
    public boolean editStudent(int id, String newFullName, int newAge, String newGender, String newDepartment,
            double newGPA) {
        String validation = Student.validateTexString(newFullName, String.valueOf(newAge), String.valueOf(newGPA));
        if (!validation.equals("OK"))
            return false;
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
