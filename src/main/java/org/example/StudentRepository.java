 package org.example;


 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

 public class StudentRepository {

     private final Connection conn;

     public StudentRepository(Connection databaseConnection) {
         this.conn = databaseConnection;
     }

     public String addStudent(Student student) throws SQLException {

         String insertSql = "INSERT INTO students (name, age, gender) VALUES (?, ?, ?)";

         PreparedStatement preparedStatement = conn.prepareStatement(insertSql);

         preparedStatement.setString(1, student.getName());
         preparedStatement.setInt(2, student.getAge());
         preparedStatement.setString(3, student.getGender());

         preparedStatement.executeUpdate();

         preparedStatement.close();

         return "Student added successfully";
     }

     public void removeStudent(Student student) {


     }

     public List<Student> getStudent() throws SQLException {
         List<Student> students = new ArrayList<>();
         String select = "select * from students";

         Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery(select);

         while (rs.next()) {
             String name = rs.getString("name");
             int age = rs.getInt("age");
             String gender = rs.getString("gender");

             students.add(new Student(name, age, gender));

         }
         return students;

     }

     public Student getStudent(String studentName) throws SQLException {
         String selectSql = "select * from students where name=?";

         PreparedStatement ps = conn.prepareStatement(selectSql);
         ps.setString(1, studentName);
         ResultSet rs = ps.executeQuery();

         ResultSet resultSet = ps.executeQuery();
         if (resultSet.next()) {
             String name = resultSet.getString("name");
             int age = resultSet.getInt("age");
             String gender = resultSet.getString("gender");
             return new Student(name, age, gender);
         }
         return getStudent(studentName);
     }
 }
 

