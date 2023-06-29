package comm.stepDefinations;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import comm.base.Base;
import comm.common.utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class searchPage {
    Base baseclass;
    WebDriver driver;
    ExtentCucumberAdapter Extent;

    public searchPage(Base base){
        this.baseclass=base;
        this.driver=base.getDriver();
    }

    /**
     * Users enters text in web element and press enters
     * @param element
     * @param page
     */
    @Then("user {string} on {string} page")
    public void user_on_page(String element, String page) {
        try{
             utility.byIdentifierType(utility.extractOR(element,page)).sendKeys("Piyush",Keys.ENTER);
            ExtentCucumberAdapter.addTestStepLog("User searches for Piyush");
             Thread.sleep(500);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Stores are the heading in the report
     * @param element
     * @param page
     */
    @And("user stores all the {string} on {string} page in report")
    public void userStoresAllTheOnPageInReport(String element, String page) throws IOException, InterruptedException {

        Thread.sleep(3000);
        List<WebElement> myList;
        myList =  utility.IdentifiersType(utility.extractOR(element,page));

        for(int i=1; i<=myList.size()-1; i++){

            String value = (myList.get(i).getText().trim());
            ExtentCucumberAdapter.addTestStepLog(value);
        }
    }
}
