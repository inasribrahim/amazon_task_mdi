package com.amazon.mdi.platform;

import com.amazon.mdi.screen.*;

public class Amazon {

    public HomeScreen home;
    public CaptchaScreen captchaScreen;

    public ProductsDetailsScreen productsDetails;

    public GoCartShopScreen goCartShopScreen;

    public Amazon(){
        home = new HomeScreen();
        captchaScreen = new CaptchaScreen();
        productsDetails = new ProductsDetailsScreen();
        goCartShopScreen = new GoCartShopScreen();
    }
}
