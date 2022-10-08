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
}
