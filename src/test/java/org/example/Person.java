package org.example;

import org.junit.Test;

public class Person {

    public String name;
    public String secondName;
    public int age;
    public int classLen;

    public Person(String name, String secondName, int age, int classLen) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.classLen = classLen;
    }

    public static PersonBuilder builder() {
        return  new PersonBuilder();
    }

    public static class PersonBuilder {
        public String name;
        public String secondName;
        public int age;
        public int classLen;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder classLen(int classLen) {
            this.classLen = classLen;
            return this;
        }

        public Person build() {
            return new Person(name, secondName, age, classLen);
        }
    }

}