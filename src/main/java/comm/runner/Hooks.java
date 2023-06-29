package comm.runner;

import comm.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks extends Base {

    @Before
    public void before() throws IOException {
        Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
        launchbrowser();
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            TakesScreenshot ss = (TakesScreenshot)driver;
            byte[] src = ss.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png","screenshot");
        }
        driver.close();
        driver.quit();
    }

}
