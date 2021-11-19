package com.school.service;

import com.school.*;
import com.school.enums.Degree;
import com.school.enums.TeacherType;

import java.util.*;
import java.util.stream.Collectors;

public class TeacherService {
    List<Teacher> teachers = new ArrayList<>();
    List<School> schools = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public TeacherService() {
        teachers.add(new PartTimeTeacher("zahra", "zahraei", "28", 10, 120_000));
        teachers.add(new PartTimeTeacher("ali", "aliyani", "50", 25, 20_000));
        teachers.add(new FullTimeTeacher("ahmad", "admadi", "33", 500.0));
        teachers.add(new FullTimeTeacher("reza", "razavi", "38", 600.0));
    }

    public void addSchool(Teacher teacher, School school) {
        teacher.getSchool().add(school);
        teachers.add(teacher);

    }


    public void addCourse(Teacher teacher, Course course) {
        teacher.getCourse().add(course);
        teachers.add(teacher);


    }

    public List<Teacher> getTeacherWithUpAvgSalary() {
        List<Double> nums = teachers.stream().filter(t -> t.getType() == TeacherType.FULL_TIME).map(t -> t.calculateSalary()).collect(Collectors.toList());
        Double aveSalary = nums.stream().mapToDouble(d -> d)
                .average()
                .orElse(0.0);
        return teachers.stream().filter(t -> t.calculateSalary() >= aveSalary).collect(Collectors.toList());
    }

    public List<AbstractMap.SimpleEntry<TeacherType, List<Teacher>>> getTenYearTeachers() {
        List<AbstractMap.SimpleEntry<TeacherType, List<Teacher>>> output = new ArrayList<>();
        List<Teacher> ptList = teachers.stream().filter(t -> t.getType() == TeacherType.PART_TIME).filter(t -> t.getExperienceYear() == 10).collect(Collectors.toList());
        List<Teacher> ftList = teachers.stream().filter(t -> t.getType() == TeacherType.FULL_TIME).filter(t -> t.getExperienceYear() == 10).collect(Collectors.toList());
        AbstractMap.SimpleEntry<TeacherType, List<Teacher>> ptEntry = new AbstractMap.SimpleEntry<>(TeacherType.PART_TIME, ptList);
        AbstractMap.SimpleEntry<TeacherType, List<Teacher>> ftEntry = new AbstractMap.SimpleEntry<>(TeacherType.FULL_TIME, ftList);
        output.add(ptEntry);
        output.add(ftEntry);
        return output;
    }

    public List<Teacher> getTeacherWithBSDegree() {
        return teachers.stream()
                .filter(t -> t.getType() == TeacherType.PART_TIME)
                .filter(t -> t.getDegree() == Degree.BS)
                .filter(t -> t.getSchool().stream().anyMatch(s -> s.getDegree() == 2))
                .filter(t -> t.getCourse().stream().count() >= 2)
                .collect(Collectors.toList());
    }

    public Set<School> getSchoolName() {
        Set<School> schools = new HashSet<>();
        teachers.stream().forEach(t -> schools.addAll(t.getSchool()));
        return schools;
    }

    public Map<School, List<Teacher>> getMapSchools() {
        Set<School> schools = getSchoolName();
        Map<School, List<Teacher>> map = new HashMap<>();
        schools.stream().forEach(
                s -> {
                    List<Teacher> tList = new ArrayList<>();
                    teachers.stream().forEach(t ->
                    {
                        if (t.getSchool().contains(s)) {
                            tList.add(t);
                        }

                    });
                    map.put(s, tList);
                });
        return map;
    }


}