package com.amazon.mdi.screen;

import com.amazon.mdi.driver.DriverManager;
import org.openqa.selenium.By;


public class ProductsDetailsScreen extends BaseScreen{

    private final By results = By.xpath("//a[@class = 'a-size-base a-color-base a-link-normal a-text-normal']");
    private final By productsTitle = By.id("productTitle");
    private final By prices = By.xpath("//span[@class=\"a-price aok-align-center\"]");
    private final By addToCardButton = By.id("add-to-cart-button");
    private final By closeShoppingCart = By.id("attach-close_sideSheet-link");
    private final By goToCartButton = By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)");
    private final By quantityNumber = By.xpath("//span[@class='a-dropdown-prompt']");
    private final By quantitySelector = By.cssSelector("#a-autoid-0-announce");
    public ProductsDetailsScreen clickOnAddToCardButton(){
        waitUtils.waitUntilElementUntilIsClickable(addToCardButton).click();
        return this;
    }
    public ProductsDetailsScreen clickOnResult(int index){
        getElements(results).get(index - 1).click();
        return new ProductsDetailsScreen();
    }

    public ProductsDetailsScreen clickOnCloseCartShopping() throws InterruptedException {
        if(elementIsExisted(closeShoppingCart))
        {
            waitUtils.waitUntilElementUntilIsClickable(closeShoppingCart).click();
            waitUtils.sleep(5000);
        }
        return new ProductsDetailsScreen();
    }

    public void clickOnGoToCartButton(){
        waitUtils.waitUntilElementUntilIsClickable(goToCartButton).click();
    }
    public String getProductTitle(){
        return getElementText(productsTitle);
    }

    public int getQuantityProduct(){
        return Integer.parseInt(getElements(quantityNumber).get(0).getText());
    }

    public Double getPrice(){
        System.out.println(getElementText(prices));
        String[] priceValueList = getElementText(prices).split("//$");
        String priceValue =   priceValueList[0].split("\\$")[1].trim().split("\\n")[0] +"."+ priceValueList[0].split("\\$")[1].trim().split("\\n")[1];
        return Double.parseDouble(priceValue);
    }

    public ProductsDetailsScreen clickOnQuantitySeclector() {
        waitUtils.waitUntilElementUntilIsClickable(quantitySelector).click();
        return this;
    }


    public ProductsDetailsScreen chooseQuantity(int quantityNumber) throws InterruptedException {
        waitUtils.sleep(3000);
        DriverManager.getWebDriver().findElement(By.id("quantity_"+(quantityNumber - 1))).click();
        return this;
    }
}
