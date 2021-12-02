package Domashkas;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenideTests.BaseTest;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class Domashka_9  extends BaseTest {

    @Test
    public void addProductToCart(){
        mainPage.openUrl("http://automationpractice.com");
        mainPage.getProduct("Blouse").clickToProduct("Blouse");
        blousePage.blouseSizeDropDown.selectOptionContainingText("S");
        blousePage.blouseAddToCartButton.click();
        cartPopUpPage.popUpHeader.shouldBe(Condition.visible);
        cartPopUpPage.selectedParams.shouldHave(Condition.exactText("Black, S"));
        cartPopUpPage.totalWithShipping.shouldHave(Condition.exactText("$29.00"));
    }

    @Test
    public void addZeroQuantityToCart(){
        mainPage.openUrl("http://automationpractice.com");
        mainPage.getProduct("Blouse").clickToProduct("Blouse");
        blousePage.blouseQuantity.setValue("0");
        blousePage.blouseAddToCartButton.click();
        cartPopUpPage.popUpNullQuantity.shouldHave(Condition.exactText("Null quantity."));
    }
}
