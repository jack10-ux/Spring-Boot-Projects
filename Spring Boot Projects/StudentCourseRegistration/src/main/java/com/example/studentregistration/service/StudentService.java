
package com.example.studentregistration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentregistration.model.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Register student
    public Student registerStudent(Student student) {
        students.add(student);
        return student;
    }

    // View all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Find student by ID
    public Student getStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    // Delete student
    public String deleteStudent(int studentId) {

        Student student = getStudentById(studentId);

        if (student != null) {
            students.remove(student);
            return "Student registration deleted successfully";
        }

        return "Student not found";
    }
}
