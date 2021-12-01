package seleniumTests.junitTests;

import org.junit.*;
import org.junit.rules.Timeout;

public class JunitTests {

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class input");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class input");
    }

    @Before
    public void before() {
        System.out.println("Before test");
    }

    @After
    public void after() {
        System.out.println("After test");
    }

    @Test
    public void test() {
        System.out.println("text");
        Assert.assertEquals("text", "text");
    }

    @Test(timeout = 1000)
//    @Test(expected = NoSuchElementException.class)
//    @Ignore
    public void test2() {
        System.out.println("text");
        Assert.assertEquals("text2", "text2");
    }

}
