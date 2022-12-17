package pageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchCustomer {

	public WebDriver driver;
	
	public SearchCustomer(WebDriver driver) {
		this.driver = driver;
	}
	
	private By serachEmail = By.id("SearchEmail");
	private By serachButton = By.id("search-customers");
	private By resultBody = By.id("customers-grid_wrapper");
	private By searchFirstName = By.id("SearchFirstName");
	private By searchLastName = By.id("SearchLastName");
	
	public WebElement getSearchEmail() {
		return driver.findElement(serachEmail);
	}
	
	public WebElement getSerachButton() {
		return driver.findElement(serachButton);
	}
	
	public WebElement getResultBody() {
		return driver.findElement(resultBody);
	}
	
	public WebElement getSerachFirstName() {
		return driver.findElement(searchFirstName);
	}
	
	public WebElement getSearchLastName() {
		return driver.findElement(searchLastName);
	}
}
