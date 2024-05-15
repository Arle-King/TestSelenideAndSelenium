package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AppTest {

    public Person Man(String name, String secondName, int age) {
        return Person.builder()
                .name(name)
                .secondName(secondName)
                .age(age).build();
    }

    public Person Student(String name, String secondName, int age, int classLen) {
        return Person.builder()
                .name(name)
                .secondName(secondName)
                .age(age)
                .classLen(classLen)
                .build();
    }

    @Test
    public void main() {
        String name = "Ivan";
        String secondName = "Volodia";
        int age = 15;
        int classLen = 4;

        Person man = Man(name, secondName, age);
        Person student = Student(name, secondName, age, classLen);
        System.out.println("man info:" + man.getName() + " " + man.getSecondName() + " " + man.getAge() + " " + man.getClassLen());
        System.out.println("student info:" + student.getName() + " " + student.getSecondName() + " " + student.getAge() + " " + student.getClassLen());
    }

}
