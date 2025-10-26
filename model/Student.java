package model;
public class Student {
    private int studentID;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double GPA;
   // private StudentDatabase studentDatabase = new StudentDatabase("Student/students.txt");

    public Student(int studentID, String name, int age, String gender, String department, double GPA) {
        setStudentID(studentID);
        setName(name);
        setAge(age);
        setGender(gender);
        setDepartment(department);
        setGPA(GPA);

    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // Method to get a line representation of the student for file storage
    public String lineRepresentation() {
        return studentID + "," + name + "," + age + "," + gender + "," + department + "," + GPA;
    }


     public static String validateTexString(String studentName, String ageStr, String gpaAsString) {
        if (studentName == null || studentName.trim().isEmpty())
            return "Name cannot be empty and must be a valid string";

        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 6 || age > 100)
                return "Age must be between 6 and 100";
        } catch (NumberFormatException e) {
            return "Age must be a valid number";
        }

        double gpa;
        try {
            gpa = Double.parseDouble(gpaAsString);
            if (gpa < 0.0 || gpa > 4.0)
                return "GPA must be between 0.0 and 4.0";
        } catch (NumberFormatException e) {
            return "GPA must be a valid number";
        }

        return "OK"; // everything is valid except department and gender and alraedy id is generated in GUI
    }
    
}