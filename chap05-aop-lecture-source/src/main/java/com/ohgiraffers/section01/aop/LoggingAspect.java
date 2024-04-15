package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/* @Aspect : pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션이다. */
@Aspect
@Component
public class LoggingAspect {

    /* @Pointcut : 여러 조인 포인트를 매치하기 위해 지정한 표현식 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    // 반드시 void 형식으로 작성
    public void logPointcut(){}

    /* JoinPoint : 포인트컷으로 패치한 실행 시점
    *  이렇게 매치된 조인포인트에서 해야 할 일이 어드바이스이다.
    *  매개변수로 전달한 JoinPoint 객체는 현재 조인 포인트의 메소드명, 인수값 등의 자세한 정보를 액세스 할 수 있다. */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0 ) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    /* After 어드바이스는 포인트 컷을 동일한 클래스 내에서 사용하는 것이면 클래스명은 생략 가능하다.
    *  단, 패키지가 다르면 패키지를 포함한 클래스명을 기술해야 한다. */
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getSignature : " + joinPoint.getSignature());
    }

    /* Returning 속성은 리턴값으로 받아올 오브젝트의 매개변수 이름과 동일해야 한다.
      또한 joinPoint는 반드시 첫 번째 매개변수로 선언해야 한다.
     */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result : " + result);
    }

    /* Throwing 속성 이름과 매개변수의 이름이 동일해야 한다. */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception : " + exception);
    }

    /* Around Advice는 가장 강력한 어드바이스이다.
    *  이 어드바이스는 조인포인트를 완전히 장악하기 때문에
    *  앞에 살펴 본 어드바이스 모두 Around 어드바이스로 조합할 수 있다.
    *  심지어 원본 조인포인트를 언제 실행할지, 실행 자체를 안할지, 계속 실행할지 여부까지도 제어한다.
    *  AroundAdvice는 조인포인트 매개변수는 ProceedingJoinPoint로 고정되어있다.
    *  JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
    *  조인포인트의 진행하는 호출을 잊는 경우가 자주 발생하기 때문에 주의해야 하며
    *  최소한의 요건을 충족하면서도 가장 기능이 약한 어드바이스를 쓰는게 바람직하다. */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before " + joinPoint.getSignature().getName());

        /* 원본 조인포인트를 실행한다. */
        Object result = joinPoint.proceed();

        System.out.println("Around After " + joinPoint.getSignature().getName());

        /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */
        return result;
    }
}
