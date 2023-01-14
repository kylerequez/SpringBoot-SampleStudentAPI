package com.github.SampleRESTApi.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Student")
@Table(
        name = "student"
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "id",
            updatable = false
    )
    private String id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "middle_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String middleName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "age",
            nullable = false
    )
    private int age;
    @Column(
            name = "year_level",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String yearLevel;
    @Column(
            name = "section",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String section;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && id.equals(student.id) && firstName.equals(student.firstName) && middleName.equals(student.middleName) && lastName.equals(student.lastName) && yearLevel.equals(student.yearLevel) && section.equals(student.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, age, yearLevel, section);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", yearLevel='" + yearLevel + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
