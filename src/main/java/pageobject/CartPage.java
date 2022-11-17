package pageobject;

import TestCases.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Util;

public class CartPage extends BaseTest {

    protected WebDriver driver;
    private static Logger logger = LogManager.getLogger(BasePage.class);

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement cartMenu;
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrderButton;

    public void clickOnCartMenu(){
        cartMenu.click();
    }

    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
        Util.pauseExecutionForSeconds(2);

    }

}
