package org.example;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            StudentManager manager = context.getBean(StudentManager.class);

           // Student student = new Student("Alice", 20, "Female");
           // Student student = new Student("Chris", 19, "male");
            Student student = new Student("Anne", 27, "Female");
            System.out.println(manager.addStudent(student));

           List<Student>students = manager.retrievalAll();
           System.out.println("All students:");
            for (Student s : students) {
                System.out.println(s.getName() + " | " + s.getAge() + " | " + s.getGender());
            }






        } catch (
                SQLException e) {
            System.err.println(" error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}