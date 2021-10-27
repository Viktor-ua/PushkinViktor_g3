package ui.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver webDriver;
    Logger logger;

    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Method open url
     *
     * @param url
     */
    public void openUrl(String url){
        try{
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e){
            e.printStackTrace();
            logger.error("Page can't opened " + url);
            Assert.fail("Page can't opened " + url);
        }
    }
}
