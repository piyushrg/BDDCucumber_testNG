package comm.stepDefinations;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import comm.base.Base;
import comm.common.utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class commonStepDefination {

    Base baseclass;
    WebDriver driver;
    ExtentCucumberAdapter Extent;

    public commonStepDefination(Base base){
        this.baseclass=base;
        this.driver=base.getDriver();
    }

    /**
     * Launches the URL
     * @param url
     */
    @Given("User launches {string}")
    public void user_launches(String url) {
        driver.get(url);
        ExtentCucumberAdapter.addTestStepLog(url + " is opened");
    }

    /**
     * Clicks on the WebElement
     * @param element
     * @param page
     * @throws IOException
     */
    @Given("user clicks on {string} on {string} page")
    public void user_clicks_on_on_page(String element, String page) throws IOException, InterruptedException {

        switch (element.toUpperCase()){
            default:
                utility.byIdentifierType(utility.extractOR(element,page)).click();
        }
        Thread.sleep(1000);
    }

    /**
     * User enters text in some text field
     * @param text
     * @param elm
     * @param page
     */
    @Then("user enters {string} in element {string} on {string} page")
    public void userEntersInElementOnPage(String text, String elm, String page) {

        try{
            utility.byIdentifierType(utility.extractOR(elm,page)).sendKeys(text);
        }catch(Exception e){
            ExtentCucumberAdapter.addTestStepLog(e.getMessage());
        }
    }
}
