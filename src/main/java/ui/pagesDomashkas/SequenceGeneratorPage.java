package ui.pagesDomashkas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SequenceGeneratorPage extends MainPageDomashkas{

    public SequenceGeneratorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "min")
    public WebElement smallestValue;

    @FindBy(name = "max")
    public WebElement largestValue;

    @FindBy(xpath = "//input[@value='Get Sequence']")
    public WebElement getSequenceButton;

    @FindBy(xpath = "//pre[@class='data']")
    public WebElement sequenceResults;

    public SequenceGeneratorPage inputSmallestValue (String minN){
        smallestValue.clear();
        smallestValue.sendKeys(minN);
        return this;
    }

    public SequenceGeneratorPage inputLargestValue (String maxN){
        largestValue.clear();
        largestValue.sendKeys(maxN);
        return this;
    }

    public SequenceGeneratorPage clickGetSequenceButton (){
        getSequenceButton.click();
        return this;
    }

    public String checkSequenceResults(){
        return sequenceResults.getText();
    }
}
