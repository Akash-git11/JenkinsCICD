

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Screens.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Base {
	WebDriver driver;
	LoginPage lp;

	public LoginPage initDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
		lp = new LoginPage(driver);
		return lp;
	}

    @AfterTest
    public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
    	driver.quit();
    }
}
