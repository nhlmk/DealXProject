package com.dealX.pages;
import com.dealX.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "search_query_top")
    public WebElement searchInput;

    @FindBy(className = "login")
    public WebElement signInLink;

    @FindBy(xpath = "(//li[contains(@class,'first-item')])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//a[contains(.,'Add to cart')])[1]")
    public WebElement addToCart;

    @FindBy(xpath = "(//span[contains(.,'checkout')])")
    public WebElement proceedToCheckout;
}
