package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Squirtle implements Pokemon{
    @Override
    public void attack() {
        System.out.println("~구부기 물대포 발사~");
    }
}
