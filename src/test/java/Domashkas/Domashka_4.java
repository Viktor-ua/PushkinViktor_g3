package Domashkas;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class Domashka_4 {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    @BeforeEach
    public void setUp() {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("browser was opened");
        webDriver.get("https://finance.i.ua/converter/");
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void selectPlnCurrency() {
        Select drpCurrency = new Select(webDriver.findElement(By.xpath("//*[@id='converter_currency']")));
        drpCurrency.selectByValue("PLN");
    }

    @Test
    public void messageOnConvertingFromUsdToEur(){
        Select drpCurrency = new Select(webDriver.findElement(By.xpath("//*[@id='converter_currency']")));
        drpCurrency.selectByValue("USD");
        String messageUSDtoEUR = webDriver.findElement(By.xpath("//*[@id='EUR']//span[@class='info']")).getText();
        Assertions.assertEquals("Конвертация из одной иностранной валюты в другую происходит через транзитную конвертацию в национальную валюту. Поэтому в данном поле указан курс продажи EUR", messageUSDtoEUR);
    }

    @Test
    public void messageIsNotVisible(){
        Select drpCurrency = new Select(webDriver.findElement(By.xpath("//*[@id='converter_currency']")));
        drpCurrency.selectByValue("UAH");
        boolean messageVisibility = webDriver.findElement(By.xpath("//*[@id='USD']//span[@class='info']")).isDisplayed();
        Assertions.assertFalse(messageVisibility);
    }
}