package Domashkas;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.MyAccountPage;
import ui.pagesDomashkas.RegistrationPageDomashka5;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

public class Domashka_5 {


    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPageDomashka5 registrationPageDomashka5;
    public MyAccountPage myAccountPage;


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
        myAccountPage = new MyAccountPage(webDriver);
        registrationPageDomashka5 = new RegistrationPageDomashka5(webDriver);
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
        registrationPageDomashka5
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
        Assert.assertThat(registrationPageDomashka5.checkValidationMessage(),
                startsWith("There is 1 error"));
        Assert.assertThat(registrationPageDomashka5.checkValidationMessage(),
                endsWith("This country requires you to choose a State."));
    }
}
