package baseTest;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.pages.MainPage;
import ui.pages.MyAccount;
import ui.pages.Registration2Page;
import ui.pages.RegistrationPage;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class BaseTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public MyAccount myAccount;
    public Utils utils = new Utils();
    public Faker faker = new Faker();

    public String browser;
    public String patchToScreenShot;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome"},
//                {"firefox"}
        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        if ("chrome".equals(browser)) {
            logger.info(browser + " will be started");
            File fileChromeDriver = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + " is started");
        } else if ("firefox".equals(browser)){
            logger.info(browser + " will be started");
            File fileChromeDriver = new File("./drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileChromeDriver.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + " is started");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenShot = file.getAbsolutePath() + "\\resources\\screenshot" + "-" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() +
                "\\" + this.testName.getMethodName() + "-" + browser + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccount = new MyAccount(webDriver);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }
}
