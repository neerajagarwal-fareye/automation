package pageobject;

import TestCases.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactusPage extends BaseTest {

    protected WebDriver driver;
    private static Logger logger = LogManager.getLogger(BasePage.class);

    public ContactusPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameTextBox;
    @FindBy(xpath = "//input[@placeholder='Email Address']")
    WebElement emailTestBox;
    @FindBy(xpath = "//textarea[@placeholder='Message']")
    WebElement messageTextBox;
    @FindBy(xpath = "//input[@value='SEND MESSAGE']")
    WebElement sendMessage;

    @FindBy(xpath = "(//div[text()='One or more fields have an error. Please check and try again.'])[1]")
    WebElement errorVerification;


    public void enterTextInNameBox(String text){
        nameTextBox.clear();
        nameTextBox.sendKeys(text);
    }

    public void enterTextInEmailBox(String text){
        emailTestBox.clear();
        emailTestBox.sendKeys(text);
    }

    public void enterTextInMessageBox(String text){
        messageTextBox.clear();
        messageTextBox.sendKeys(text);
    }

    public void clickOnSendMessage(){
        sendMessage.click();
    }

    public boolean verifyErrorMessaseDisplayed(){
        return errorVerification.isDisplayed();
    }







}
