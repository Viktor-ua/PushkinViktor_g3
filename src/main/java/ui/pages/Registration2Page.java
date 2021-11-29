package ui.pages;

import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registration2Page extends MainPage {

    public Registration2Page(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='radio-inline'][1]")
    public WebElement genderMr;

    @FindBy(xpath = "//div[@class='radio-inline'][2]")
    public WebElement genderMrs;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstName;

    @FindBy(name = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(name = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "days")
    public WebElement daysDropDown;

    @FindBy(id = "months")
    public WebElement monthsDropDown;

    @FindBy(id = "years")
    public WebElement yearsDropDown;

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
     * annotation for domashka 5
     */
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement validationMessage;

    @Step("Select gender {gender}")
    public Registration2Page selectGender(String gender) {
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMrs, gender);
        }
        return this;
    }

    @Step("Input customer first name {firstName}")
    public Registration2Page inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstName, firstName);
        return this;
    }

    @Step("Input customer last name {lastName}")
    public Registration2Page inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
        return this;
    }

    @Step("Input email {email}")
    public Registration2Page inputEmail(String email) {
        webElements.inputText(emailInput, email);
        return this;
    }

    @Step("Input email {email}")
    public Registration2Page inputPassword(String password) {
        webElements.inputText(passwordInput, password);
        return this;
    }
    @Step("Select birthday {day}")
    public Registration2Page selectBirthday(String day) {
        webElements.selectValueInDropDown(daysDropDown, day);
        return this;
    }

    @Step("Select birthday month {month}")
    public Registration2Page selectBirthMonth(String month) {
        webElements.selectValueInDropDown(monthsDropDown, month);
        return this;
    }
    @Step("Select birthday year {year}")
    public Registration2Page selectBirthYear(String year) {
        webElements.selectValueInDropDown(yearsDropDown, year);
        return this;
    }

    @Step("Input first name {firstName}")
    public Registration2Page inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
        return this;
    }

    @Step("Input last name {lastName}")
    public Registration2Page inputLastName(String lastName) {
        webElements.inputText(lastNameInput, lastName);
        return this;
    }

    @Step("Input street {street}")
    public Registration2Page inputStreet(String street) {
        webElements.inputText(streetInput, street);
        return this;
    }

    @Step("Input city {city}")
    public Registration2Page inputCity(String city) {
        webElements.inputText(cityInput, city);
        return this;
    }

    @Step("Select state {text}")
    public Registration2Page selectState(String text) {
        webElements.selectTextInDropDownByText(stateSelect, text);
        return this;
    }

    @Step("Select country {text}")
    public Registration2Page selectCountry(String text) {
        webElements.selectTextInDropDownByText(idCountry, text);
        return this;
    }

    @Step("Input post code {postCode}")
    public Registration2Page inputPostCode(String postCode) {
        webElements.inputText(postCodeInput, postCode);
        return this;
    }

    @Step("Input phone {phone}")
    public Registration2Page inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
        return this;
    }

    @Step("Input alias {alias}")
    public Registration2Page inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
        return this;
    }

    @Step("Submit account")
    public Registration2Page clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
        return this;
    }

    public String checkTitle() {
        return titleRegisteredAccount.getText();
    }

    /**
     * Method for domashka 5
     */
    public String checkValidationMessage() {
        return validationMessage.getText();
    }

    public Registration2Page registrationNewUser(Account account) {
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
        inputCustomerLN(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPassword());
        selectBirthday(account.getDay());
        selectBirthMonth(account.getMonth());
        selectBirthYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputStreet(account.getAddress1());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostCode(account.getPostCode());
        selectCountry(account.getCountry());
        inputMobilePhone(account.getPhoneMobile());
        inputAlias(account.getAlias());
        return this;
    }
}