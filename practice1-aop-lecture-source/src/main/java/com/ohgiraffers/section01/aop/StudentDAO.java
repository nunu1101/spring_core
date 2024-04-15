package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDAO {

    private final Map<String, StudentDTO> studentMap;

    public StudentDAO(){
        studentMap = new HashMap<>();
        studentMap.put("유관순", new StudentDTO("유관순", 17, 1));
        studentMap.put("홍길동", new StudentDTO("홍길동", 18, 2));
        studentMap.put("이순신", new StudentDTO("이순신", 19, 3));
    }

    public Map<String, StudentDTO> selectStudents(){
        return studentMap;
    }

    public StudentDTO selectStudent(String name) {
        StudentDTO returnStudent = studentMap.get(name);

        if (returnStudent == null) {
            throw new RuntimeException("해당하는 학생이 없습니다.");
        }
        return returnStudent;
    }
}
