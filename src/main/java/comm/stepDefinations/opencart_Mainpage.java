package comm.stepDefinations;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import comm.base.Base;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class opencart_Mainpage {

    Base baseclass;
    WebDriver driver;
    ExtentCucumberAdapter Extent;

    public opencart_Mainpage(Base base){
        this.baseclass=base;
        this.driver=base.getDriver();
    }

    @Then("user validates the title of the page")
    public void userValidatesTheTitleOfThePage() {

        String title = driver.getTitle();
        Assert.assertEquals(title,"Your Store");
    }


}
