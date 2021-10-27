package junitTests;


import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.google.common.math.LongMath.isPrime;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Junit5Tests {

    @RegisterExtension
    public String text = "";

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before class input");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("After class input");
    }

    @BeforeEach
    public void before(){
        System.out.println("Before test");
    }

    @AfterEach
    public void after(){
        System.out.println("After test");
    }

    @Test
    public void test(){
        System.out.println("test");
//        Assertions.assertTimeout(Duration.ofMillis(1), () -> Thread.sleep(10));
    }

    @Test
    @ValueSource(strings = {"1", "2"})
    public void test2(){
        System.out.println("test2");
//        Assertions.assertAll(
//                () -> assertTrue(isPrime(2)),
//                () -> assertFalse(isPrime(4))
//       );
    }
}
