package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage{

    public RegistrationPage(WebDriver webDriver){
        super(webDriver);
    }
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

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
        openSignInPage();
    }
}
