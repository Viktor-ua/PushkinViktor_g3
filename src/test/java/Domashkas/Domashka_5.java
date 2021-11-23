package Domashkas;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.MyAccount;
import ui.pages.Registration2Page;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

public class Domashka_5 {


    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public Registration2Page registration2Page;
    public MyAccount myAccount;


    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./" +
                "drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("browser was opened");
        mainPage = new MainPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccount = new MyAccount(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private final String EMAIL = "9283asd89_2398@gmail.com";
    private final String FIRST_NAME = "Vitya";
    private final String LAST_NAME = "Pushkin";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "streen New York, 12";
    private final String CITY = "New York";
    private final int STATE = 32;
    private final String POST_CODE = "12345";
    private final String MOBILE_PHONE = "1234567890";


    @Test
    public void checkValidationMessage() {
        mainPage.openUrl("http://automationpractice.com/");
        registration2Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputStreet(STREET)
                .inputCity(CITY)
//                .selectState(STATE)
                .inputPostCode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();
        Assert.assertThat(registration2Page.checkValidationMessage(),
                startsWith("There is 1 error"));
        Assert.assertThat(registration2Page.checkValidationMessage(),
                endsWith("This country requires you to choose a State."));
    }
}
