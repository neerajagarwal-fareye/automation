package pageobject;

import TestCases.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BasePage extends BaseTest {
    protected WebDriver driver;
    private static Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }




    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitButtonOnHomePage;
    @FindBy(xpath = "//ul[@id='top-menu']//a[normalize-space()='Contact Us']")
    WebElement contactUsMenuItem;



    public boolean verifySubmitButtonOnHomePageDisplayed(){
        return submitButtonOnHomePage.isDisplayed();
    }

    public void verifyContactUsPageClickable(){
        contactUsMenuItem.click();
    }


    @Test
    public void propertiesValue(){
        System.out.println(prop.getProperty("username"));
    }

}
