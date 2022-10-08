package com.dealX.stepDefinitions;

import com.dealX.pages.BasePage;
import com.dealX.pages.LogInPage;
import com.dealX.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.logging.Log;
import org.junit.Assert;

public class LogInStepDefinitions {
    BasePage basePage = new BasePage();
    LogInPage logInPage = new LogInPage();

    @And("user clicks sign-in link from the top right of the application")
    public void userClicksSignInLinkFromTheTopRightOfTheApplication() {
basePage.signInLink.click();
    }

    @And("user enters {string}, {string} in related field")
    public void userEntersInRelatedField(String arg0, String arg1) {
        logInPage.usernameInput.sendKeys(arg0);
        logInPage.passwordInput.sendKeys(arg1);
    }

    @And("user clicks sign-in button")
    public void userClicksSigninButton(){
        logInPage.signInButton.click();
    }

    @Then("user logs in successfully")
    public void userLogsInSuccessfully() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("My account"));
    }
}
