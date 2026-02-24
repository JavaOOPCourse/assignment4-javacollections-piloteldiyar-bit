package service;

import model.Student;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void initializeStudents() {
        students.add(new Student(1, "Nzik", 3.4));
        students.add(new Student(2, "Nursultan", 1.8));
        students.add(new Student(3, "Mirana", 3.9));
        students.add(new Student(4, "Daniel", 2.7));
        students.add(new Student(5, "Kasya", 1.9));
    }

    public void removeLowGPA() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getGpa() < 2.0) {
                iterator.remove();
            }
        }
    }

    public void findHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        System.out.println("Student with highest GPA: " + topStudent);
    }

    public void insertAtIndex() {
        Student newStudent = new Student(6, "Erbol", 3.1);
        if (students.size() >= 2) {
            students.add(2, newStudent);
        } else {
            students.add(newStudent);
        }
    }

    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in list.");
            return;
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
