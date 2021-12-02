package pagesSelenide.pagesDomashkas;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BlousePage {

    public final SelenideElement
            blouseModel = $("#product_reference"),
            blouseCondition = $("#product_condition span"),
            blouseDataSheet = $(".table-data-sheet"),
            blousePrice = $("#our_price_display"),
            blouseQuantity = $("#quantity_wanted"),
            blouseSizeDropDown = $("#group_1"),
            blouseAddToCartButton = $("#add_to_cart button");


//    @Step("Get blouse model")
//    public String getBlouseModel(){
//        return blouseModel.getText();
//    }

}
