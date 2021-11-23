package ui.pagesDomashkas;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePageRandomOrg extends MainPageDomashkas {

    public HomePageRandomOrg(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[normalize-space()='Allow Selected']")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//iframe[contains(text(),'number generator')]")
    public WebElement iframeElement;

    @FindBy(xpath = "//input[contains(@name,'min')]")
    public WebElement randomMinNumber;

    @FindBy(xpath = "//input[contains(@name,'max')]")
    public WebElement randomMaxNumber;

    @FindBy(xpath = "//input[contains(@name,'button')]")
    public WebElement generateButton;

    @FindBy(xpath = "//span[contains(@id,'result')]//span[1]")
    public WebElement resultValue;

    @FindBy(xpath = "//ul[@id='navigation']/li[3]")
    public WebElement sequencesTopBar1;

    @FindBy(xpath = "//ul[@id='navigation']/li[3]/ul/li[2]")
    public WebElement sequencesTopBar2;

    @FindBy(xpath = "//h2[text()='Random Sequence Generator']")
    public WebElement titleSequenceGenerator;

    @FindBy(xpath = "//a[text()='Sequence Generator']")
    public WebElement sequenceGeneratorLink;


    public HomePageRandomOrg clickAcceptCookieButton(){
        acceptCookiesButton.click();
        return this;
    }

    public HomePageRandomOrg switchToIframeRandomGen(){
        webDriver.switchTo().frame(iframeElement);
        return this;
    }

    public HomePageRandomOrg inputMinNumber(String minN){
        randomMinNumber.clear();
        randomMinNumber.sendKeys(minN);
        return this;
    }
    public HomePageRandomOrg inputMaxNumber(String maxN){
        randomMaxNumber.clear();
        randomMaxNumber.sendKeys(maxN);
        return this;
    }

    public HomePageRandomOrg clickGenerateButton(){
        generateButton.click();
        return this;
    }

    public String checkResult(){
        return resultValue.getText();
    }

    public HomePageRandomOrg clickSequenceTopBar()  {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(sequencesTopBar1).perform();
//        Thread.sleep(5000L);
        sequencesTopBar2.click();
        return this;
    }

    public String checkSequenceGeneratorTitle(){
        return titleSequenceGenerator.getText();
    }

    public HomePageRandomOrg clickSequenceGeneratorLink(){
        sequenceGeneratorLink.click();
        return this;
    }
}
