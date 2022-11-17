package pageobject;

import TestCases.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Util;

public class HomePage extends BaseTest {

    protected WebDriver driver;
    private static Logger logger = LogManager.getLogger(BasePage.class);

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitButtonOnHomePage;
    @FindBy(xpath = "//ul[@id='top-menu']//a[normalize-space()='Contact Us']")
    WebElement contactUsMenuItem;
    @FindBy(xpath = "//a[@id='cat']")
    WebElement CategoriesTestOnHomePage;
    @FindBy(xpath = "//div[@id='contcont']//a[2]")
    WebElement mobilPhoneMenu;

    @FindBy(xpath = "//div[@class='card-block']//a[text()='Samsung galaxy s6']")
    WebElement selectMobile;

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addTopCartButton;

    public boolean checkIfHomePageLoaded(){
        return CategoriesTestOnHomePage.isDisplayed();
    }

    public void clickOnMobileTab(){
        mobilPhoneMenu.click();
    }

    public void clickOnProduct(){
        selectMobile.click();
    }


    public void clickOnAddToCartButton(){
        addTopCartButton.click();
        Util.pauseExecutionForSeconds(2);
        driver.switchTo().alert().accept();
    }
}
