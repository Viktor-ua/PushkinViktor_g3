package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registration2Page extends MainPage {

    public Registration2Page(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement loginInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstName;

    @FindBy(name = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(name = "passwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement stateSelect;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement postCodeInput;

    @FindBy(xpath = "//select[@id='id_country']")
    public WebElement idCountry;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement phoneMobileInput;

    @FindBy(xpath = "//input[@id='alias']")
    public WebElement aliasInput;

    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement submitAccount;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    /**
     *annotation for domashka 5
     */
    @FindBy(xpath = "//div[@class='alert alert-danger']" )
    public WebElement validationMessage;

    /**
     * Method open SignIn page
     */
    public Registration2Page clickSignIn() {
        signInLink.click();
        return this;
    }

    /**
     * Method click to SignIn page
     */
    public Registration2Page openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    /**
     * Method input email
     *
     * @param email
     */
    public Registration2Page inputEmailCreate(String email) {
        loginInput.clear();
        loginInput.sendKeys(email);
        return this;
    }

    public Registration2Page submitButtonCreate() {
        submitButtonCreate.click();
        return this;
    }

    public Registration2Page inputCustomerFN(String firstName) {
        customerFirstName.clear();
        customerFirstName.sendKeys(firstName);
        return this;
    }

    public Registration2Page inputCustomerLN(String lastName) {
        customerLastName.clear();
        customerLastName.sendKeys(lastName);
        return this;
    }

    public Registration2Page inputEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public Registration2Page inputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public Registration2Page inputFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public Registration2Page inputLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public Registration2Page inputStreet(String street) {
        streetInput.clear();
        streetInput.sendKeys(street);
        return this;
    }

    public Registration2Page inputCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }

    public Registration2Page selectState(String text) {
        webElements.selectTextInDropDownByText(stateSelect, text);
        return this;
    }

    public Registration2Page selectCountry(String text){
        webElements.selectTextInDropDownByText(idCountry, text);
        return this;
    }


    public Registration2Page inputPostCode(String postCode) {
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
        return this;
    }

    public Registration2Page inputMobilePhone(String phone) {
        phoneMobileInput.clear();
        phoneMobileInput.sendKeys(phone);
        return this;
    }

    public Registration2Page inputAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        return this;
    }

    public Registration2Page clickSubmitAccount() {
        submitAccount.click();
        return this;
    }

    public String checkTitle() {
        return titleRegisteredAccount.getText();
    }

    /**
     *Method for domashka 5
     */
    public String checkValidationMessage(){
        return validationMessage.getText();
    }
}
