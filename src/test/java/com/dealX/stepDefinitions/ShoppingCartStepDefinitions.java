package com.dealX.stepDefinitions;

import com.dealX.pages.BasePage;
import com.dealX.pages.ShoppingCartPage;
import com.dealX.utilities.BrowserUtilities;
import com.dealX.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartStepDefinitions {
    BasePage basePage = new BasePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @When("user adds any item to the cart")
    public void userAddsAnyItemToTheCart() {

        jse.executeScript("window.scrollBy(0,750)");
        BrowserUtilities.waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.firstProduct).perform();
        BrowserUtilities.waitFor(2);
        basePage.addToCart.click();
        BrowserUtilities.waitFor(3);
    }


    @And("user goes to checkout page")
    public void userGoesToCheckoutPage() {
        basePage.proceedToCheckout.click();
        BrowserUtilities.waitFor(3);
    }

    @And("user clicks the plus icon to increase amount")
    public void userClicksThePlusIconToIncreaseAmount() {
        jse.executeScript("window.scrollBy(0,100)");
        shoppingCartPage.plusIcon.click();
    }

    @Then("user calculates total price and verifies it is matching with actual one")
    public void userCalculatesTotalPrice() {
        try {
            String unitPrice = shoppingCartPage.unitPrice.getText();
            double price = Double.parseDouble(unitPrice);
            String quantity = shoppingCartPage.quantity.getAttribute("value");
            int count = Integer.parseInt(quantity);
            double expectedTotalPrice = BrowserUtilities.calculateTotalPrice(price, count);
            String displayedTotalPrice = shoppingCartPage.totalPrice.getText();
            double actualTotalPrice = Double.parseDouble(displayedTotalPrice);
            Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }finally {
            BrowserUtilities.waitFor(3);
        }



    }

}
