package com.amazon.mdi.screen;

import org.openqa.selenium.By;

public class GoCartShopScreen extends BaseScreen {

    private final By totalAmount = By.id("sc-subtotal-amount-buybox");
    private final By numberOfQuantity = By.id("sc-subtotal-label-activecart");

    public Double getTotalAmount(){
        return Double.parseDouble(getElementText(totalAmount).split("\\$")[1]);
    }
    public int getNumberOfQuantity(){
        return Integer.parseInt(getElementText(numberOfQuantity).split("Subtotal \\(")[1].split(" items\\)")[0]);
    }
}