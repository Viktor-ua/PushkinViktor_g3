package seleniumTests.simpleTests;

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
        String exTitle = webDriver.findElement(By.xpath("//div[@class='text-center']/h1")).getText();
        Assert.assertEquals("Selenium automates browsers. That's it!", exTitle);
        webDriver.findElement(By.xpath("//div[@class='selenium-button-container']/a[@href='/documentation/webdriver/']")).click();
        String exTittleWD = webDriver.findElement(By.xpath("//div[@class='td-content']/h1")).getText();
        Assert.assertEquals("WebDriver", exTittleWD);
        webDriver.findElement(By.xpath("//div[@class='selenium-button-container']/a")).click();
        String exTittleSponsor = webDriver.findElement(By.xpath("//div[@class='text-center']/h1 ")).getText();
        Assert.assertEquals("Sponsors", exTittleSponsor);
    }

    @Test
    public void seleniumTest_2() throws InterruptedException {
        webDriver.findElement(By.xpath("//input[@type='search']")).clear();
        webDriver.findElement(By.xpath("//input[@type='search']")).sendKeys("WebDriver");
        Thread.sleep(3000);
        WebElement dynamicElem = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='algolia-autocomplete-listbox-0']")));
        System.out.println(dynamicElem.getTagName());
        webDriver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
        String exTittleWD = webDriver.findElement(By.xpath("//div[@class='td-content']/h1")).getText();
        Assert.assertEquals("WebDriver", exTittleWD);
    }
}