package comm.base;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    public void launchbrowser(){

        System.setProperty("webdriver.chrome.driver", "H:\\Jars\\Chrome\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        ExtentCucumberAdapter.addTestStepLog("Chrome browser opened");

        getDriver();
    }
}
