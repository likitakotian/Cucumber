package pageObjectModel;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomerPom {

	public WebDriver driver;

	public AddCustomerPom(WebDriver driver) {
		this.driver = driver;
	}

	private By menu = By.id("nopSideBarPusher");
	private By customerMainMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	private By customer = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	private By addNewButton = By.xpath("//a[@class='btn btn-primary']");
	private By newEmail = By.xpath("//input[@id='Email']");
	private By newPassword = By.xpath("//input[@id='Password']");
	private By customerRole = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	private By adminRole = By.xpath("//li[contains(.,'Administrators')]");
	private By forumModeratorsRole = By.xpath("//li[contains(.,'Forum Moderators')]");
	private By guestsRole = By.xpath("//li[contains(.,'Guests')]");
	private By vendorsRole = By.xpath("//li[@id='0976369b-1ff0-4a00-8892-5de4b5ab4150']");
	private By managerOfVender = By.xpath("//select[@id='VendorId']");
	private By malegender = By.xpath("//input[@id='Gender_Male']");
	private By femaleGender = By.xpath("//input[@id='Gender_Female']");
	private By firstName = By.xpath("//input[@id='FirstName']");
	private By lastname = By.xpath("//input[@id='LastName']");
	private By dob = By.xpath("//input[@id='DateOfBirth']");
	private By companyname = By.xpath("//input[@id='Company']");
	private By adminComment = By.xpath("//textarea[@id='AdminComment']");
	private By save = By.xpath("//button[@name='save']");
	private By roles = By.xpath("//li[@role='option']");
	
	public WebElement getmenu() {
		return driver.findElement(menu);
	}

	public WebElement getcustomerMainMenu() {
		return driver.findElement(customerMainMenu);
	}

	public WebElement getcustomer() {
		return driver.findElement(customer);
	}

	public WebElement getaddNewButton() {
		return driver.findElement(addNewButton);
	}

	public WebElement getnewEmail() {
		return driver.findElement(newEmail);
	}

	public WebElement getnewPassword() {
		return driver.findElement(newPassword);
	}

	public WebElement getcustomerRole() {
		return driver.findElement(customerRole);
	}

	public WebElement getadminRole() {
		return driver.findElement(adminRole);
	}

	public WebElement getforumModeratorsRole() {
		return driver.findElement(forumModeratorsRole);
	}

	public WebElement getguestsRole() {
		return driver.findElement(guestsRole);
	}

	public WebElement getvendorsRole() {
		return driver.findElement(vendorsRole);
	}

	public WebElement getmanagerOfVender() {
		return driver.findElement(managerOfVender);
	}

	public WebElement getmalegender() {
		return driver.findElement(malegender);
	}

	public WebElement getfemaleGender() {
		return driver.findElement(femaleGender);
	}

	public WebElement getfirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getlastname() {
		return driver.findElement(lastname);
	}

	public WebElement getdob() {
		return driver.findElement(dob);
	}

	public WebElement getcompanyname() {
		return driver.findElement(companyname);
	}

	public WebElement getadminComment() {
		return driver.findElement(adminComment);
	}

	public WebElement getsave() {
		return driver.findElement(save);
	}
	
	public List<WebElement> getRoles(){
		return driver.findElements(roles);
	}
}
