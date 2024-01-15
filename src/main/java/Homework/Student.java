package Homework;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public int age;
    public transient String GPA;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGPA() {
        return GPA;
    }

    public Student(String name, int age, String GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }
}
