package com.genericmethods;

import com.testdata.ReadJsonFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class GenericMethods extends ReadJsonFile {

    public static WebDriver driver;
    public static String currentTestCase;

    /**
     * @Method name: launchBrowser
     * @param browserType,url
     * @Purpose: This method will launch the browser given by the user
     * @Return Type: NA
     */

@Step("Launch The {0} Browser and Open the URL {1}")
    public void launchBrowser(String browserType, String url){

        switch(browserType.toUpperCase()){

            case "CHROME":
                //logic for chrome
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;

            case "FF":
                //logic for firefox
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

            case "EDGE":
                //logic for Edge
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;

            case "OPERA":
                //logic for Opera
                WebDriverManager.operadriver().setup();
                driver=new OperaDriver();
                break;

            default:
                System.out.println("Invalid Browser");
        }
        driver.get(url);
        driver.manage().window().maximize();
        getScreenshot();
    }

    //Selecting the Drop down
    /**
     * @method selectDropDownByVisibleText
     * @purpose selects an option from the dropdown by using the Visible Text given by the user
     * @param element
     * @param selectOption
     */
    @Step("Select an option from the Dropdown Element {0} by using the Option {1} given by the user")

    public void selectDropDownByVisibleText(WebElement element, String selectOption){

        Select option= new Select(element);
        option.selectByVisibleText(selectOption);
    }

    /**
     * @method selectDropDownByValue
     * @purpose selects an option from the dropdown by using the Value given by the user
     * @param element
     * @param selectOption
     */
    @Step("Select an option from the Dropdown Element {0} by using the Option {1} given by the user")
    public void selectDropDownByValue(WebElement element, String selectOption){

        Select option= new Select(element);
        option.selectByValue(selectOption);
    }

    /**
     * @method selectDropDownByIndex
     * @purpose Selects an option from the dropdown by using the Index given by the user
     * @param element
     * @param selectOption
     */
    @Step("Selects an option from the Dropdown Element {0} by using the Option {1} given by the user")
    public void selectDropDownByIndex(WebElement element, int selectOption){

        Select option= new Select(element);
        option.selectByIndex(selectOption);
    }

    /**
     * @method checkIfTheDropDownSelected
     * @param element
     * @param valueToCompare
     * @return
     */
    @Step("Check, if the Dropdown Element {0} is Selected or not")
    public boolean checkIfTheDropDownSelected(WebElement element,String valueToCompare){

        boolean selected=false;
        Select dropDownOption=new Select(element);
        String dropDownValue=dropDownOption.getFirstSelectedOption().getText();

        // check if the dropdown option is not --select--. or length is 0 or string is empty
        if(!(dropDownValue.equalsIgnoreCase(valueToCompare) || dropDownValue.length()==0 || dropDownValue.isEmpty())){
            System.out.println("Drop Down is selected");
            selected=true;
        }
        else {
            System.out.println("Drop Down is not selected with any option");
        }
        return selected;
    }


    /**
     * @method waitForElementVisible
     * @param element
     * @param seconds
     */
    @Step("Wait for the Element {0} for {1} Seconds")
    public void waitForElementVisible (WebElement element, int seconds){

        //Get the element from the WebElement
        System.out.println(element);

        String xpath= element.toString();
        xpath= xpath.substring(xpath.lastIndexOf(" ")+1,xpath.length()-1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * @method hoverAndClick
     * @param pageName
     * @param elementName
     * @param element
     */
    @Step("Click on the Element {2}")
    public void hoverAndClick(String pageName, String elementName,WebElement element){
        Actions acc=new Actions(driver);
        waitForElementVisible(element,5);
        acc.moveToElement(element).click().build().perform();
        System.out.println("Element "+elementName+" is Clicked Successfully on the "+pageName);
    }

    /**
     * @method clickAndSendData
     * @param pageName
     * @param elementName
     * @param element
     */
    @Step("Enter the Data {3} on the {0}")
    public void clickAndSendData(String pageName, String elementName,WebElement element,String data){
        Actions acc=new Actions(driver);
        waitForElementVisible(element,5);
        acc.moveToElement(element).click().build().perform();
        element.clear();
        element.sendKeys(data);
        System.out.println("Element "+elementName+" is Entered with "+data+" Successfully on the "+pageName);
    }


    /**
     * @method forceClick
     * @param element
     */
    @Step("Click the Element {0}")
    public void forceClick(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    /**
     * @method dragAndDrop
     * @param element1
     * @param element2
     */
    @Step("Drag the Element {0} to the {1}")
    public void dragAndDrop(WebElement element1,WebElement element2){

        Actions drag= new Actions(driver);
        drag.dragAndDrop(element1, element2);
    }

    @Step("Closes The Application")
    public void closeApplication(){
        driver.close();
        driver.quit();
    }

    public byte[] getScreenshot(){
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

}
