package com.pkg.stepDefination;

import baseUtil.base;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class google {

    base baseclass;
    ExtentCucumberAdapter extent;
    public google(base base){
        this.baseclass=base;
        this.driver=base.getDriver();
    }

    WebDriver driver;

    @Given("User launches {string}")
    public void user_launches(String url) {
        driver.get(url);
        extent.addTestStepLog(url + " is opened");
        Assert.assertEquals(driver.getTitle(),"Google");
    }
    @Then("User search on google page")
    public void user_search_on_google_page() {
        driver.findElement(By.name("q")).sendKeys("piyush");
        extent.addTestStepLog("Piyush is searched");
    }
}
