package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage{

    public RegistrationPage(WebDriver webDriver){
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

    @FindBy(name="passwd")
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
    public By.ByXPath stateSelect;

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
     * Method open SignIn page
     */
    public void clickSignIn(){
        signInLink.click();
    }
    /**
     * Method click to SignIn page
     */
    public void openSignInPage(){
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     *Method input email
     *
     * @param email
     */
    public void inputEmailCreate(String email){
        loginInput.clear();
        loginInput.sendKeys(email);
    }

    public void submitButtonCreate(){
        submitButtonCreate.click();
    }

    public void inputCustomerFN(String firstName){
        customerFirstName.clear();
        customerFirstName.sendKeys(firstName);
    }

    public void inputCustomerLN(String lastName){
        customerLastName.clear();
        customerLastName.sendKeys(lastName);
    }

    public void inputEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void inputPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void inputFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void inputStreet(String street){
        streetInput.clear();
        streetInput.sendKeys(street);
    }

    public void inputCity(String city){
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void selectState(int index){
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_state']")));
        select.selectByIndex(index);
    }

    public void inputPostCode(String postCode){
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
    }

    public void inputMobilePhone(String phone){
        phoneMobileInput.clear();
        phoneMobileInput.sendKeys(phone);
    }

    public void inputAlias(String alias){
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void clickSubmitAccount(){
        submitAccount.click();
    }

    public String checkTitle(){
        return titleRegisteredAccount.getText();
    }
}
