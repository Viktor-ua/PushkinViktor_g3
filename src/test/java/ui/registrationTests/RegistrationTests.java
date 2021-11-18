package ui.registrationTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;


public class RegistrationTests extends BaseTest {

    private final String EMAIL = faker.internet().emailAddress();
    private final String FIRST_NAME = "Vitya";
    private final String LAST_NAME = "Pushkin";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final String STATE = "New York";
    private final String COUNTRY = "United States";
    private final String POST_CODE = "12345";
    private final String MOBILE_PHONE = "1234567890";

    public RegistrationTests(String browser) {
        super(browser);
    }

    @Test
    public void registrationTest() {
        mainPage.openUrl("http://automationpractice.com/");
        registrationPage.clickSignIn();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN(FIRST_NAME);
        registrationPage.inputCustomerLN(LAST_NAME);
        registrationPage.inputEmail(EMAIL);
        registrationPage.inputPassword(PASSWORD);
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputStreet(STREET);
        registrationPage.inputCity(CITY);
        registrationPage.selectState(STATE);
        registrationPage.selectCountry(COUNTRY);
        registrationPage.inputPostCode(POST_CODE);
        registrationPage.inputMobilePhone(MOBILE_PHONE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccount.checkTitle());
        myAccount.checkTitle("Title",
                myAccount.checkTitleTextOnPage("My account - My Store"), true);
    }

    @Test
    public void registrationPage2() {
        mainPage.openUrl("http://automationpractice.com/");
        registration2Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFN(FIRST_NAME)
                .inputCustomerLN(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputStreet(STREET)
                .inputCity(CITY)
                .selectState(STATE)
                .selectCountry(COUNTRY)
                .inputPostCode(POST_CODE)
                .inputMobilePhone(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccount.checkTitle());
    }
}
