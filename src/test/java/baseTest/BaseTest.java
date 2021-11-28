package baseTest;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import ui.pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public MyAccountPage myAccountPage;
    public SignInPage signInPage;
    public Utils utils = new Utils();
    public Faker faker = new Faker();
    public String patchToScreenShot;

    public BaseTest() {
    }

    @Parameters("browserName")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome")  String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            logger.info(browser + " will be started");
            File fileChromeDriver = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + " is started");
        } else if (browser.toLowerCase().equals("firefox")){
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
                this.getClass().getSimpleName() + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        signInPage = new SignInPage(webDriver);
    }

    @AfterClass
    public void tearDown() {
        if (!(webDriver == null)) {
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }

}