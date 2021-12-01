package seleniumTests.testNgTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNgTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class input");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class input");
    }

    @AfterMethod
    public void before() {
        System.out.println("Before test");
    }

    @AfterMethod
    public void after() {
        System.out.println("After test");
    }

    @Test(groups =  "method 1")
//    @Test(expectedExceptions = ArithmeticException.class)
    public void test1(){
        System.out.println("text");
        Assert.assertEquals("res", "res");
    }
}
