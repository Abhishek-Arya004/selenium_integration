package Object_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='firstname']")
	WebElement txtFname;

	@FindBy(xpath = "//*[@id='lastname']")
	WebElement txtLname;
	@FindBy(xpath = "//*[@id='signupForm']/div[5]/input")
	WebElement btnRegister;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;

		// initializing all page objects
		PageFactory.initElements(driver, this);
	}

	public void inputFirstname(String fname) {
		txtFname.sendKeys(fname);
	}

	public void inputLastname(String lname) {
		txtLname.sendKeys(lname);
	}

	public void clickRegister() {
		btnRegister.click();
	}

	public String getFirstName() {
		return txtFname.getAttribute("value");
	}

	public String getLastName() {
		return txtLname.getAttribute("value");
	}
}
