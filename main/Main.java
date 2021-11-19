package com.school.main;

import com.school.Course;
import com.school.School;
import com.school.Teacher;
import com.school.enums.TeacherType;
import com.school.service.TeacherService;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Course course = new Course("math", 1);
        Course course1 = new Course("computer", 2);
        Course course2 = new Course("physic", 3);
        Course course3 = new Course("history", 4);
        Course course4 = new Course("art", 5);


        School school = new School("maktab", 1);
        School school1 = new School("madani", 2);
        School school2 = new School("alavi", 3);
        School school3 = new School("razavi", 3);
        School school4 = new School("jalal", 1);
        School school5 = new School("diba", 1);
        TeacherService teacherService = new TeacherService();

        Teacher teacher = teacherService.getTeachers().get(1);

        teacherService.addSchool(teacher, school);
        teacher.getSchool().stream().forEach(s -> System.out.println(s.getName() + " : " + s.getName()));
//        for(int i=0;i<teacher.getSchool().size();i++){
//            System.out.println(new ArrayList<>(teacher.getSchool()));


        teacherService.addCourse(teacher, course1);
        teacher.getCourse().stream().forEach(s -> System.out.println(s.getName() + " : " + s.getCourseNumber()));
        teacherService.getTeacherWithUpAvgSalary().stream().forEach(t -> System.out.println(t.getName() + " " + t.getLastName()));

        List<AbstractMap.SimpleEntry<TeacherType, List<Teacher>>> list = teacherService.getTenYearTeachers();
        list.stream().forEach(
                e -> {
                    System.out.println(e.getKey().toString());
                    e.getValue().stream().forEach(t -> System.out.println(t.getLastName()));
                });
        teacherService.getTeacherWithBSDegree().stream().forEach(t -> System.out.println(t.getName() + " " + t.getLastName()));
//        }


        teacherService.getMapSchools().entrySet().stream().forEach(e ->
        {
            System.out.println(e.getKey().getName());
            e.getValue().stream().forEach(t -> System.out.println(t.getName() + " " + t.getLastName()));
        });
    }
}
