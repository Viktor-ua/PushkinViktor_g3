package Domashkas;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pagesDomashkas.HomePageRandomOrg;
import ui.pagesDomashkas.MainPageDomashkas;
import ui.pagesDomashkas.SequenceGeneratorPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

public class Domashka_6 {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public MainPageDomashkas mainPageDomashkas;
    public HomePageRandomOrg homePageRandomOrg;
    public SequenceGeneratorPage sequenceGeneratorPage;

    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("./" +
                "drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("browser was opened");
        mainPageDomashkas = new MainPageDomashkas(webDriver);
        homePageRandomOrg = new HomePageRandomOrg(webDriver);
        sequenceGeneratorPage = new SequenceGeneratorPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private final String MINNUMBER = "23";
    private final String MAXNUMBER = "24";

    @Test
    public void checkRandomNumberGenerator() {
        mainPageDomashkas.openUrl("https://www.random.org/");
        homePageRandomOrg.clickAcceptCookieButton()
                .switchToIframeRandomGen()
                .inputMinNumber(MINNUMBER)
                .inputMaxNumber(MAXNUMBER)
                .clickGenerateButton();
        Assert.assertThat(homePageRandomOrg.checkResult(),
                anyOf(is(MINNUMBER), is(MAXNUMBER)));
    }

    @Test
    public void checkTopBarWorking() {
        mainPageDomashkas.openUrl("https://www.random.org/");
        homePageRandomOrg.clickAcceptCookieButton()
                .clickSequenceTopBar();
        Assert.assertEquals("Random Sequence Generator",
                homePageRandomOrg.checkSequenceGeneratorTitle());
    }

    @Test
    public void checkSequenceGeneratorPage() {
        mainPageDomashkas.openUrl("https://www.random.org/");
        homePageRandomOrg.clickSequenceGeneratorLink();
        sequenceGeneratorPage.inputSmallestValue(MINNUMBER)
                .inputLargestValue(MAXNUMBER)
                .clickGetSequenceButton();
        Assert.assertThat(sequenceGeneratorPage.checkSequenceResults(), allOf(containsString(MINNUMBER), containsString(MAXNUMBER)));
    }
}
