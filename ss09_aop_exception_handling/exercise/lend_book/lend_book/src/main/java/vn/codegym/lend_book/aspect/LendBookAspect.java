package vn.codegym.lend_book.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LendBookAspect {
    int count = 0;

    @Pointcut("execution(* vn.codegym.lend_book.controller.LendBookController.save(..))")
    public void lendBookPointCut() {
    }

    @AfterReturning("lendBookPointCut()")
    public void lendBookLog() {
        System.out.println("1 người dùng mượn sách thành công, lúc " + LocalDateTime.now());
    }

    @Pointcut("execution(* vn.codegym.lend_book.controller.LendBookController.payBook(..))")
    public void payBookPointCut() {
    }

    @AfterReturning("payBookPointCut()")
    public void payBookLog() {
        System.out.println("1 người dùng trả sách thành công, lúc " + LocalDateTime.now());
    }

    @Pointcut("within(vn.codegym.lend_book.controller.*)")
    public void allMethodPointCut() {
    }
    @After("allMethodPointCut()")
    public void writeAllAction() {
        count++;
        System.out.println("Tính đến lúc: " + LocalDateTime.now() + ", có tất cả: " + count + " thao tác với thư viện");
    }

}
