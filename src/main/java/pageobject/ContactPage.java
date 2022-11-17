package pageobject;

import TestCases.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BaseTest {
    protected WebDriver driver;
    private static Logger logger = LogManager.getLogger(BasePage.class);

    public ContactPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

}
