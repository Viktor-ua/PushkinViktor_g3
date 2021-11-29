package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends MainPage {
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(xpath = "//a[@class='account']/span")
    public WebElement accountBtn;

    @Step("Check title")
    public String checkTitle() {
        return titleRegisteredAccount.getText();
    }

    @Step("Check title {actual}, {expected}")
    public void checkTitle(boolean actual, boolean expected){
        webElements.checkAC(actual, expected);
    }
    @Step("Get account user name")
    public String getAccountName(){
        return accountBtn.getText();
    }

    public void getHeaderName(String text){
        webElements.isElementPresent(text);
    }
}
