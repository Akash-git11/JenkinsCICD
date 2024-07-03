package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyUtility {

    WebDriver driver;

    public MyUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(WebElement element, String key) {
        element.clear();
        element.sendKeys(key);
        System.out.println("Entered " + element.getAttribute("value"));

    }

    public void sendMaskedKeys(WebElement element, String key) {
        element.clear();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value=key;", element);
    }

    public boolean click(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return true;
    }

    public boolean getStatus(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getReqItemFromList(List<WebElement> elements, String key) {


        WebElement reqElement = elements.stream().filter(x -> x.getText().contains(key)).findFirst().orElse(null);
        if (reqElement == null) {
            System.out.println("Element "+ key +" not found : " + "Returned Null");
        }

        return reqElement;
    }

    public void selectFromDropdown(WebElement element, String key){
        Select dropdown = new Select(element);
        dropdown.selectByValue(key);

    }

}
