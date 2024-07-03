package Screens;

import Utility.MyUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Products extends MyUtility {
    WebDriver driver;



    public Products(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(className = "product_label")
    WebElement product_label;

    @FindBy(className = "inventory_container")
    WebElement inventory_container;

    @FindBy(className = "inventory_item_label")
    WebElement inventory_item_label;

    @FindBy(css = ".product_sort_container")
    WebElement dropdown;



    public boolean getProduct_label() {
        boolean status = getStatus(product_label);
        return status;
    }

    public void getInventory_item_labels(String product) {

        List<WebElement> elements = inventory_container.findElements(By.className("inventory_item"));


       WebElement Reqelement =  getReqItemFromList(elements,product);
       try{
           Reqelement.findElement(By.cssSelector(".btn_primary")).click();
       }catch(Exception e){
           System.out.println("Exception : " + e.getMessage());
       }
    }

    public void applyFilter(String key){

    selectFromDropdown(dropdown,key);
    }



}
