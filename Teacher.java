package com.school;

import com.school.enums.Degree;
import com.school.enums.TeacherType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Teacher {
    private String name;
    private String lastName;
    private String personalNumber;
    private Degree degree; //مدرک معلم
    private Set<School> school = new HashSet<>();
    private Integer experienceYear;
    private Set<Course> course = new HashSet<>();
    private int age;
    private TeacherType type;  // نوع معلم : تمام وقت و پاره وقت

    public Teacher(String name, String lastName, String personalNumber) {
        this.name = name;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<School> getSchool() {
        return school;
    }

    public void setSchool(Set<School> school) {
        this.school = school;
    }

    public Integer getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(Integer experienceYear) {
        this.experienceYear = experienceYear;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TeacherType getType() {
        return type;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    public abstract Double calculateSalary();

    protected final Double calculateTax(Double salary) {

        if (salary < 2_800_000) {
            return 0D;
        }
        if (salary < 4_500_000) {
            return salary * 0.1;
        }
        if (salary < 8_500_000) {
            return salary * 0.15;
        }
        if (salary < 12_500_000) {
            return salary * 0.2;
        }
        return salary * 0.25;
    }

    protected final Double calculateInsurance(Double salary) {
        return salary * 0.07;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return name.equals(teacher.name) &&
                lastName.equals(teacher.lastName) &&
                personalNumber.equals(teacher.personalNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, personalNumber);
    }
}
