package com.dealX.stepDefinitions;

import com.dealX.utilities.BrowserUtilities;
import com.dealX.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationMenuStepDefinitions {
    Actions actions = new Actions(Driver.getDriver());
    Hooks hooks = new Hooks();

    @When("user hovers over different {string} from main navigation menu, user should be able to see {string} under the related menus")
    public void userHoversOverDifferentFromMainNavigationMenu(String arg0, String arg1) {
        if (arg0 == "Women") {
            WebElement mainMenu = Driver.getDriver().findElement(By.xpath("(//a[.='" + arg0 + "'])[1]"));
            actions.moveToElement(mainMenu).perform();
            BrowserUtilities.waitFor(3);
            WebElement subcategory = Driver.getDriver().findElement(By.xpath("//a[contains(@title,'" + arg1 + "')]"));
            Assert.assertTrue(subcategory.isDisplayed());
            BrowserUtilities.waitFor(3);
        } else if (arg0 == "Dresses") {
            WebElement mainMenu = Driver.getDriver().findElement(By.xpath("(//a[.='" + arg0 + "'])[2]"));
            actions.moveToElement(mainMenu).perform();
            BrowserUtilities.waitFor(3);
            WebElement subcategory = Driver.getDriver().findElement(By.xpath("//a[contains(@title,'" + arg1 + "')]"));
            Assert.assertTrue(subcategory.isDisplayed());
            BrowserUtilities.waitFor(3);
        }

    }

}
