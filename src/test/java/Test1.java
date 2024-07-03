

import Screens.Products;
import org.testng.Assert;
import org.testng.annotations.Test;

import Screens.LoginPage;

public class Test1 extends Base {
	
	@Test
	public void TestCase1() {
		
		//LoginPage
		LoginPage lp = initDriver();
		lp.navigateTo();
		lp.enterUsernameAndPassword("standard_user","secret_sauce");
		Products products =lp.clickLoginButton();


		//Productpage
		boolean status = products.getProduct_label();
		Assert.assertTrue(status);
		products.getInventory_item_labels("Sauce Labs Bolt T-Shirt");
		products.applyFilter("lohi");
	}

}
