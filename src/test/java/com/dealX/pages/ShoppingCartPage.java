package com.dealX.pages;

import com.dealX.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//i[contains(@class,'plus')]")
    public WebElement plusIcon;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']//input[@type='hidden']")
    public WebElement quantity;

    @FindBy(xpath = "//span[@class='price']")
    public WebElement unitPrice;

    @FindBy(xpath = "//td[@class='price']")
    public WebElement totalPrice;

}
