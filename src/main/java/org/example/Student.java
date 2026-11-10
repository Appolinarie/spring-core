package org.example;

public class Student {
    private String name;
    private int age;
    private String gender;


    public Student (String name, int age, String gender){
        this.name =name;
        this.age = age;
        this.gender =gender;
    }

    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
