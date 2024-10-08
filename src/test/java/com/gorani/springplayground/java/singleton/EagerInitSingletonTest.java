package com.gorani.springplayground.java.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EagerInitSingletonTest {

    /**
     * 클래스 멤버 변수는 프로그램 실행시점에 모두 초기화 되지 않습니다.
     * 클래스의 메서드에 접근하여 클래스가 로드될 때 클래스 멤버 변수가 초기화 됩니다.
     * print 되어지는 메시지를 보시고 실행 시점을 확인해보세요
     */
    @Test
    void getSingletonTest() {
        System.out.println("test start");
        EagerInitSingleton.getInstance();
        EagerInitSingleton.getInstance();
        EagerInitSingleton.getInstance();
    }
}