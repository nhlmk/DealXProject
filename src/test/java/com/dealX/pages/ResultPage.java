package com.dealX.pages;

import com.dealX.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    public ResultPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy(xpath = "(//li[contains(@class, 'first-item')]//following::h5//a[contains(.,'Dress')])[1]")
    public WebElement firstItem;

}
