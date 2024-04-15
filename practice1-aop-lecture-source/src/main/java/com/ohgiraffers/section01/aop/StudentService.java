package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    private final StudentDAO studentDAO;
    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Map<String, StudentDTO> selectStudents() {
        System.out.println("selectStudents 메소드 실행");
        return studentDAO.selectStudents();
    }

    public StudentDTO selectStudent(String name){
        System.out.println("selectStudent 메소드 실행");
        return studentDAO.selectStudent(name);
    }
}
