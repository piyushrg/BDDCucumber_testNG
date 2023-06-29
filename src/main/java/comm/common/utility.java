package comm.common;

import comm.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class utility {

    static int TimeOut = 30;

    /**
     * Retrieves the locator from the given pages in the parameters provided as the arguments.
     * @param locator
     * @param page
     */
    public static String extractOR(String locator, String page) throws IOException {

        FileInputStream stream = new FileInputStream(".\\src\\test\\java\\OR\\"+page+".properties");
        Properties prop = new Properties();
        prop.load(stream);

        String temp_locator = (String) prop.get(locator);
        String[] temp_arr_locator = temp_locator.trim().split("\\(",2);
        String identifier = temp_arr_locator[0].trim();
        System.out.println(identifier);
        String locatorValue = temp_arr_locator[1].trim();
        System.out.println(locator);

        StringBuffer strBuffer = new StringBuffer(locatorValue);
        locatorValue = String.valueOf(strBuffer.deleteCharAt(locatorValue.length()-1));

        String response = identifier+" "+locatorValue;
        System.out.println("print--"+ response);
        return response;
    }

    /**
     * Methods used identifier type like By.Name , By.Xpath to identify the WebElement with locator value
     * <li> @param input : Response from the method extractOR()
     * <li> @return : returns a WebElement
     */
    public static WebElement byIdentifierType(String input){

        WebElement elm;
        String[] temp_arr = input.split(" ",2);
        String Identifier = temp_arr[0].trim();
        String Locator  = temp_arr[1].trim().replaceAll("\"","");

        switch (Identifier.toUpperCase()){
            case "BY.NAME":
                Wait(Base.driver.findElement(By.name(Locator)));
                 elm = Base.driver.findElement(By.name(Locator));
                break;
            default:
                Wait(Base.driver.findElement(By.xpath(Locator)));
                 elm = Base.driver.findElement(By.xpath(Locator));
        }
        return elm;
    }

    /**
     * Methods used identifiers type like By.Name , By.Xpath from driver.findelements()
     * <li> @param input : Response from the method extractOR()
     * <li> @return : returns a WebElement
     */
    public static List IdentifiersType(String input){

        String[] temp_arr = input.split(" ",2);
        String Identifier = temp_arr[0].trim();
        String Locator  = temp_arr[1].trim().replaceAll("\"","");

        List<WebElement> mylist = new ArrayList<>();
        switch (Identifier.toUpperCase()){
            case "BY.NAME":
                mylist = Base.driver.findElements(By.name(Locator));
                break;
            default:
                mylist = Base.driver.findElements(By.xpath(Locator));
        }
        return mylist;
    }

    /**
     * Explicit Wait with timeout of 30 seconds
     * @param elm
     */
    public static void Wait(WebElement elm){

        WebDriverWait wait = new WebDriverWait(Base.driver, TimeOut);
        wait.until(ExpectedConditions.visibilityOf(elm));
    }
}
