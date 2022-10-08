package com.dealX.stepDefinitions;

import com.dealX.pages.BasePage;
import com.dealX.pages.ResultPage;
import com.dealX.utilities.BrowserUtilities;
import com.dealX.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;

public class SearchStepDefinitions {
    BasePage basePage = new BasePage();
    ResultPage resultPage = new ResultPage();
    Hooks hooks = new Hooks();


    @Given("user is on the home page of the application")
    public void userIsOnTheHomePageOfTheApplication() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("My Store"));
    }

    @When("user enters below search {string} and clicks enter")
    public void userEntersBelowSearchAndClicksEnter(String arg0) {
        basePage.searchInput.sendKeys(arg0, Keys.ENTER);
        // BrowserUtilities.waitFor(3);
    }

    @Then("user should see the item related to search {string} in the first result")
    public void userShouldSeeTheItemRelatedToSearchInTheFirstResult(String arg0) {
        Assert.assertTrue(Driver.getDriver().findElement
                (By.xpath("(//li[contains(@class, 'first-item')]//following::h5//a[contains(.,'" + arg0 + "')])[1]")).getText().contains(arg0));
    }

    @When("user enters search keyword and user see the item related to search keyword in the first result")
    public void userEntersSearchItemAndClicksEnter() {
        String searchItem = "Dress,Blouse,T-shirt";
        String[] keyword = searchItem.split(",");
        for (String each : keyword) {
            basePage.searchInput.sendKeys(each, Keys.ENTER);
            Assert.assertTrue(Driver.getDriver().findElement
                    (By.xpath("(//li[contains(@class, 'first-item')]//following::h5//a[contains(.,'" + each + "')])[1]")).getText().contains(each));
            hooks.setDriver();
            BrowserUtilities.waitFor(1);

        }
    }


    @When("user enters search keyword from excel file, user sees the item related to search keyword in the first result")
    public void userEntersSearchKeywordFromExcelFileUserSeesTheItemRelatedToSearchKeywordInTheFirstResult() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        for(int i = 1; i<=3;i++){
            String searchItem = sheet.getRow(i).getCell(0).toString();
            basePage.searchInput.sendKeys(searchItem, Keys.ENTER);
            Assert.assertTrue(Driver.getDriver().findElement
                    (By.xpath("(//li[contains(@class, 'first-item')]//following::h5//a[contains(.,'" + searchItem + "')])[1]")).getText().contains(searchItem));
            hooks.setDriver();
            BrowserUtilities.waitFor(1);

        }



    }
}
