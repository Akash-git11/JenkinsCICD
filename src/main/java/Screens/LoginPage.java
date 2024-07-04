package Screens;

import Utility.MyUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MyUtility {


    WebDriver driver;
    private static Logger log;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        log = LogManager.getLogger(Products.class);
    }

    @FindBy(xpath = "//input[@type='text']")
    WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassword;

    @FindBy(css = ".btn_action")
    WebElement btnLogin;



    public void navigateTo() {

        try {
            driver.get("https://www.saucedemo.com/v1/");
         
            log.error("URL loading failed");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("URLl loading failed");

        }
    }



    public void enterUsernameAndPassword(String username, String password) {
        sendKeys(this.username,username);
     sendKeys(txtPassword,password);

    }

    public Products clickLoginButton() {
        click(btnLogin);
        Products products;
        return products = new Products(driver);
    }
}
