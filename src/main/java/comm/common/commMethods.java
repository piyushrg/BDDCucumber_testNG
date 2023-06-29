package comm.common;

import comm.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class commMethods {

    Base base;
    WebDriver driver;

    commMethods(Base baseclass){
        this.base=baseclass;
        this.driver=base.getDriver();
    }




}
