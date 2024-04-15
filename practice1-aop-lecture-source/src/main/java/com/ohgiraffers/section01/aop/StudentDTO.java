package com.ohgiraffers.section01.aop;

public class StudentDTO {

    private String name;
    private int age;
    private int gradeNum;

    public StudentDTO(){}

    public StudentDTO(String name, int age, int gradeNum) {
        this.name = name;
        this.age = age;
        this.gradeNum = gradeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gradeNum=" + gradeNum +
                '}';
    }
}
