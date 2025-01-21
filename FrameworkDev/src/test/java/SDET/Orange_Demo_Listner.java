package SDET;

import java.time.Duration;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

//@Listeners(SDET.MyListener.class)

public class Orange_Demo_Listner {

	WebDriver driver;

	@BeforeSuite
	void Setup() throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

	@Test(priority = 1)
	void testLogo() {

		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);

	}

	@Test(priority = 2)
	void testUrl() {

		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/");

	}

	@Test(priority = 3, dependsOnMethods = { "testUrl" })
	void testHomePageTitle() {

		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@AfterSuite
	void tearDown() {

		driver.quit();

	}

}
