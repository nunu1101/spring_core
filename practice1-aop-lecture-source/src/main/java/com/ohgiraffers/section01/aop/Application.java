package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        StudentService studentService  = context.getBean("studentService", StudentService.class);
        System.out.println("========== selectStudents ==========");
        System.out.println(studentService.selectStudents());
        System.out.println("========== selectStudent ==========");
        System.out.println(studentService.selectStudent("홍길동"));
    }
}
