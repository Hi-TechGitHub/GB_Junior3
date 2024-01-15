package Homework;

import java.io.*;

public class App {
    public static void main(String[] args) {

        Student user = new Student("Станислав", 37, "secret"); // Создаём экземпляр класса Student.

        serializationStudentData(user); // Сериализуем экземпляр в файл studentData.bin.
        deserializationStudentData(); // Десериализуем бинарный код в консоль из studentData.bin.

    }

    private static void serializationStudentData(Student student) {
        try (FileOutputStream fileOut = new FileOutputStream("studentData.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Объект StudentData успешно сериализован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializationStudentData() {
        try (FileInputStream fileIn = new FileInputStream("studentData.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Student student = (Student) in.readObject();
            System.out.println("Объект StudentData успешно десериализован.");
            System.out.println("Возраст: " + student.getAge());
            System.out.print("Средний балл: " + student.getGPA());
            System.out.println(" - > Тут нету GPA так как мы изначально не отслеживали за ним (использовали transient)");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
