package selenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pagesSelenide.MainPage;
import pagesSelenide.MyAccountPage;
import pagesSelenide.RegistrationPage;
import pagesSelenide.SignInPage;

import java.util.HashMap;
import java.util.Map;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class BaseTest {

    public Faker faker = new Faker();

    public SignInPage signInPage = new SignInPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public MainPage mainPage = new MainPage();

    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> pref = new HashMap<>();
        // 1 - Allow, 2 - block, 0 - default
        pref.put("profile.default_content_setting_values.notification", 1);
        options.setExperimentalOption("prefs", pref);
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1920,1080");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().browserVersion("96").setup();
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "http://automationpractice.com";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reopenBrowserOnFail = true;
        setUpBrowser();
        Selenide.open(Configuration.baseUrl);
    }

    @AfterClass
    public void tearDown(){
//        Selenide.closeWebDriver();
        WebDriverRunner.getWebDriver().quit();
    }
}
