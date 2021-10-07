package simpleTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        webDriver.get("https://www.selenium.dev/");
        logger.info("browser was opened");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void seleniumTest() {
        String exTitle = webDriver.findElement(By.xpath("//*[@id='td-cover-block-0']/div/div/div/div/h1")).getText();
        Assert.assertEquals("Selenium automates browsers. That's it!", exTitle);
        webDriver.findElement(By.xpath("/html/body/div[1]/main/section[2]/div/div/div[1]/div/div[2]/div/a")).click();
        String exTittleWD = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/h1")).getText();
        Assert.assertEquals("WebDriver", exTittleWD);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/a/i")).click();
        String exTittleSponsor = webDriver.findElement(By.xpath("//*[@id='td-cover-block-0']/div/div/div/div/h1")).getText();
        Assert.assertEquals("Sponsors", exTittleSponsor);
    }

    @Test
    public void seleniumTest_2() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id='main_navbar']/div/span/input")).clear();
        webDriver.findElement(By.xpath("//*[@id='main_navbar']/div/span/input")).sendKeys("WebDriver");
        Thread.sleep(3000);
        WebElement dynamicElem = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='algolia-autocomplete-listbox-0']")));
        System.out.println(dynamicElem.getTagName());
        webDriver.findElement(By.xpath("//*[@id='main_navbar']/div/span/input")).sendKeys(Keys.ENTER);
        String exTittleWD = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/main/div/h1")).getText();
        Assert.assertEquals("WebDriver", exTittleWD);
    }
}