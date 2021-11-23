package ui.pagesDomashkas;

import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPageDomashkas {

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;

    public MainPageDomashkas(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Method open url
     *
     * @param url
     */
    public void openUrl(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Page can't opened " + url);
            Assert.fail("Page can't opened " + url);
        }
    }

}
