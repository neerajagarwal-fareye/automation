package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.CartPage;
import pageobject.ContactusPage;
import pageobject.HomePage;
import utils.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver=null;
    public static BasePage basePage;
    public static ContactusPage contactusPage;
    public static HomePage homePage;
    public static CartPage cartPage;
    public static Properties prop = new Properties();

    public BaseTest(){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"testdata"+File.separator+"config.properties");
            prop.load(file);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e1) {
            e1.printStackTrace();
        }
    }

    @BeforeClass
    public static void tearUP(){
        driver = setBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
        basePage = new BasePage(driver);
        contactusPage = new ContactusPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 1)
    public void VerifyUserNavigatesToHomePageByDefault(){
        System.out.println("Value of environment variable is  - "+prop.getProperty("environment"));
        Assert.assertTrue(homePage.checkIfHomePageLoaded());
    }

    @Test(priority = 2)
    public void selectMobileOnHomePage(){
        homePage.clickOnMobileTab();
        homePage.clickOnProduct();
    }

    @Test(priority = 3)
    public void addProductIntoCart(){
        homePage.clickOnAddToCartButton();


    }

    @Test(priority = 4)
    public void VerifyUserPlaceOrderSuccessfully(){
        cartPage.clickOnCartMenu();
        cartPage.clickOnPlaceOrderButton();


    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public static WebDriver setBrowser(String browser){
        WebDriver driver1=null;
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver");
            driver1 = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"resources"+File.separator+"drivers"+File.separator+"geckodriver");
            driver1 = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("safari")){
            driver1 = new SafariDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+File.separator+"resources"+File.separator+"drivers"+File.separator+"msedgedriver.exe");
            driver1 = new EdgeDriver();
        }
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Constants.implicitTime, TimeUnit.SECONDS);
        return driver1;
    }

}
