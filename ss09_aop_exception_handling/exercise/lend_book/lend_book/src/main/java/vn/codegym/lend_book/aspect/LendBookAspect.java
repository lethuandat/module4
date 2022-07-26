package vn.codegym.lend_book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LendBookAspect {

    @Pointcut("within(vn.codegym.lend_book.controller.*)")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void writeAllAction(JoinPoint joinPoint) {
        System.out.println("Time: " + LocalDateTime.now() + " have action: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("allMethodPointCut()")
    public void countUser(JoinPoint joinPoint) {
        int count = 0;
        System.out.println("Time: " + LocalDateTime.now() + " have action: " + joinPoint.getSignature().getName());
    }

}
