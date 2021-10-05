package simpleTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SimpleTests {

    WebDriver webDriver;
    Logger logger;

    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Wait seconds: 10");
        webDriver.get("https://dou.ua/");
        logger.info("browser was opened");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void checkElementsInDou() {
        String douTitle = webDriver.getTitle();
        Assert.assertEquals("Спільнота програмістів | DOU", douTitle);
        webDriver.findElement(By.xpath("(//a[contains(text(),'Календар')])[1]")).click();
        String podii = webDriver.findElement(By.xpath("(//span[@class='m-hide'])[1]")).getText();
        Assert.assertEquals("Події", podii);
        webDriver.findElement(By.xpath("(//a[normalize-space()='Legal'])[1]")).click();
        String rules = webDriver.findElement(By.xpath("(//h1[contains(text(),'Правила пользования вебсайтом')])[1]")).getText();
        Assert.assertEquals("Правила пользования вебсайтом", rules);
    }

}
