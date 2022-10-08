package com.dealX.pages;

import com.dealX.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
        public WebElement usernameInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(xpath =  "//div[@class='alert alert-danger']")
    public WebElement alert;

}
