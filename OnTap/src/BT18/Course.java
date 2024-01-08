package BT18;

import java.util.ArrayList;

public class Course {
    String name;
    ArrayList<String> students;
    int numberOfStudents;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addStudent(String studentsName) {
        students.add(studentsName);
    }
    public ArrayList<String> getStudents() {
        return students;
    }
    public int getNumberOfStudents() {
        return students.size();
    }
}
