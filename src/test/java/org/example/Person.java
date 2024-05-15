package org.example;

public class Person {

    private String name;
    private String secondName;
    private int age;
    private int classLen;

    private Person() {}

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder extends Person{

        Person person;

        private PersonBuilder() {
            person = new Person();
        }

        public PersonBuilder name(String name) {
            person.name = name;
            return this;
        }

        public PersonBuilder secondName(String secondName) {
            person.secondName = secondName;
            return this;
        }

        public PersonBuilder age(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder classLen(int classLen) {
            person.classLen = classLen;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public int getClassLen() {
        return classLen;
    }
}
