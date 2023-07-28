package com.amazon.mdi.tests;

import com.amazon.mdi.utils.generate_data.GenerateData;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AmazonTest extends BaseTest{
    GenerateData generateData = new GenerateData();
    static int cardShoppingActualNumber = 0 ;

    @Test
    public void verifyThatUserCannotLoginWithValidButNotRegisteredEmail(){
        String actualEmailNotFoundErrorMessage = "We cannot find an account with that email address";
        browser.amazon.home.clickOnSignInButton();
        assertEquals(browser.amazon.home.getSignIn()
                    .enterEmailAddress(generateData.generateEmail())
                    .clickOnContinueButton()
                    .emailNotFoundErrorMessage(),actualEmailNotFoundErrorMessage);
    }

    @Test
    public void verifyThatItemsAreAddedToCartCorrectly() throws TesseractException, IOException, InterruptedException {
        browser.amazon.captchaScreen.solveCaptcha();
        int quantityActualNumber = 1;
        String categoryName = "Back to School"; //Second element in category
        int productNumberOne = 1;
        int productNumberTwo = 2;
        browser.amazon.captchaScreen.solveCaptcha();
        browser.amazon.home.getRobbinMenu().clickOnTodayDetailsLink();
        browser.amazon.home.getRobbinMenu().getTodaysDealsScreen()
                                           .clickOnCategoryName(categoryName)
                                           .clickOnProduct(productNumberOne);

        browser.amazon.productsDetails.clickOnResult(productNumberTwo);

        //Get product name and price
         String productChoose = browser.amazon.productsDetails.getProductTitle();
        double price = browser.amazon.productsDetails.getPrice();


        //check quantity is increased or not
        assertEquals( browser.amazon.productsDetails.getQuantityProduct(),quantityActualNumber); // it should be 1

        int quantityNumber = 2;
        browser.amazon.productsDetails.clickOnQuantitySeclector().chooseQuantity(quantityNumber);
        assertEquals( browser.amazon.productsDetails.getQuantityProduct(),++quantityActualNumber); // it should be 2

        browser.amazon.productsDetails.clickOnAddToCardButton().clickOnGoToCartButton();

        //check cartNumber increased or not
        int cartNumber =  browser.amazon.home.getCartShoppingScreen().scrollToShoppingCart().getShoppingCartNumber();
        cardShoppingActualNumber++;
        assertEquals(cartNumber , quantityNumber);

        assertEquals(productChoose,browser.amazon.home.getCartShoppingScreen()
                                                      .getProductTitleNameIsExistedInCartSopping(productChoose));

        double actualTotalAmount = browser.amazon.goCartShopScreen.getTotalAmount();

        double expectedTotalAmount = price * quantityNumber;
        assertEquals(expectedTotalAmount,actualTotalAmount);

        assertEquals(quantityNumber,browser.amazon.goCartShopScreen.getNumberOfQuantity());
    }


    @Test
    public void VerifyThatYouCannotSeeYourOrdersAndYourAddressesIfYouAreNotSigned() throws TesseractException, IOException, InterruptedException {
       // browser.amazon.captchaScreen.solveCaptcha();
        Thread.sleep(10000);
        String refOrderNotSignedLink = "https://www.amazon.com/ap/signin";
        assertEquals(refOrderNotSignedLink,browser.amazon.home.mouseHoverOnAccountList().clickOnOrders().getCurrentUrl().split("\\?")[0]);

        browser.amazon.home.back();
        assertEquals(false,browser.amazon.home.mouseHoverOnAccountList().yourAddressIsExistedOrNot());

        assertEquals("Your Lists",browser.amazon.home.mouseHoverOnAccountList().getYourListIsExisted());

    }
}
