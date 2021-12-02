package selenideTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import dataProviders.RegistrationPageDataProvider;
import io.qameta.allure.*;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.withText;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class RegistrationTest extends BaseTest {

    @Epic(value = "Registration")
    @Story(value = "User can registration for this test")
    @Description(value = "Test registration new user account")
    @Issue("GS-213")
    @TmsLink(value = "TL-2134")
    @Link(value = "link", url = "url")
    @Owner(value = "Vitya")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        signInPage
                .clickSignIn()
                .inputEmailCreate(userAccount.getEmail())
                .submitButtonCreate();
        registrationPage.registrationNewUser(userAccount);
        registrationPage.clickSubmitAccount();
        myAccountPage.titleRegisteredAccount.shouldHave(Condition.visible);
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }

    @Test
    public void testFindProduct(){
//        Selenide.open(Configuration.baseUrl);
        mainPage.getProduct("Blouse").clickToProduct("Blouse");
        blousePage.blouseModel
                .shouldHave(Condition.text("Model"),Condition.text("demo_2"));
        blousePage.blouseCondition
                .shouldHave(Condition.exactText("New"));
        blousePage.blouseDataSheet.shouldHave(
                Condition.text("Compositions"), Condition.text("Cotton"),
                Condition.text("Styles"), Condition.text("Casual"),
                Condition.text("Properties"), Condition.text("Short Sleeve"));
        blousePage.blousePrice.shouldBe(Condition.text("$27.00"), Condition.visible);
        blousePage.blouseAddToCartButton.shouldBe(Condition.visible, Condition.enabled);
    }
}
