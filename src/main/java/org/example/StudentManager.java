
package org.example;

import java.sql.SQLException;
import java.util.List;

public class StudentManager {

    private final StudentRepository repository;


    public StudentManager(StudentRepository repository) throws SQLException {
        this.repository = repository;
    }


    public String addStudent(Student student) throws SQLException {
        return repository.addStudent(student);
    }

    public List<Student> retrievalAll() throws SQLException {
        return repository.getStudent();
    }


    public Student retrieveStudent(String name) throws SQLException {
        return repository.getStudent(name );
    }
}
