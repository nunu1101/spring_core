package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Owner {

    /* init-method와 같은 설정 어노테이션이다. */
    @PostConstruct
    public void openShop() {
        System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑 할 수 있어용~");
    }

    /* destroy-method와 같은 설정 어노테이션이다. */
    @PreDestroy
    public void closeShop(){
        System.out.println("사장님이 가게 문 닫는대요 ㅠㅠㅠ");
    }
}
