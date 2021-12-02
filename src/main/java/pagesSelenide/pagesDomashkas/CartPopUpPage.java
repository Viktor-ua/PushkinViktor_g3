package pagesSelenide.pagesDomashkas;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CartPopUpPage {

    public final SelenideElement
        popUpHeader = $x("//h2[normalize-space()='Product successfully added to your shopping cart']"),
        selectedParams = $("#layer_cart_product_attributes"),
        totalWithShipping = $("span[class='ajax_block_cart_total']"),
        popUpNullQuantity = $(".fancybox-error");
}
