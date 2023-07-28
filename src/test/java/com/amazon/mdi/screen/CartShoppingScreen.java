package com.amazon.mdi.screen;

import org.openqa.selenium.By;


public class CartShoppingScreen extends BaseScreen {

    private final By productTitle  = By.xpath("//span[@class='a-truncate-cut']");
    private final By shoppingCart = By.id("nav-cart-count");

    public Integer getShoppingCartNumber(){
        return Integer.parseInt(getElementText(shoppingCart));
    }
    public CartShoppingScreen scrollToShoppingCart() {
        scrollToElement(shoppingCart);
        return this;
    }

    public String getProductTitleNameIsExistedInCartSopping(String name){
        String nameExpected = "";
        String text = getElementText(productTitle);
            if (name.substring(0,15).contains(text.substring(0,15))){
                nameExpected = name;
            }
        return nameExpected;
    }
}
