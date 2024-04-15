package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 첫 번째 손님이 쇼핑 카트를 꺼낸다 */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart 1에 담긴 내용 : " + cart1.getItem());

        /* 두 번째 손님이 쇼핑 카트를 꺼낸다 */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart 2에 담긴 내용 : " + cart2.getItem());

        System.out.println("cart 1의 hashcode : " + cart1.hashCode());
        System.out.println("cart 2의 hashcode : " + cart2.hashCode());

        /* init 메소드는 빈 객체 생성 시점에 동작하므로 바로 확인할 수 있지만
        *  destroy 메소드는 빈 객체 소멸 시점에 동작하므로 컨테이너가 종료되지 않을 경우 확인할 수 없다.
        *  가비지 컬렉터가 해당 빈을 메모리에서 지울 때 destroy 메소드가 동작하게 되는데
        *  메모리에서 지우기 전에 프로세스는 종료되기 때문이다.
        * */

        ((AnnotationConfigApplicationContext) context).close();
    }
}
