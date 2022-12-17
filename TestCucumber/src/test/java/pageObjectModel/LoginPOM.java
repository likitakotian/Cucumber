package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {

	public WebDriver driver;

	public LoginPOM(WebDriver driver) {
		this.driver = driver;
	}

	private By email = By.id("Email");
	private By password = By.id("Password");
	private By login = By.xpath("//button[@type='submit']");
	private By logout = By.xpath("//a[@href='/logout']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getLogout() {
		return driver.findElement(logout);
	}
}
