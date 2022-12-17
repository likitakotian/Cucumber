package stepDefination;

import org.testng.Assert;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.test.TestCucumber.ConfigFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.AddCustomerPom;
import pageObjectModel.LoginPOM;
import pageObjectModel.SearchCustomer;

public class LoginStepDefination extends ConfigFile {

	private WebDriver driver;
	private LoginPOM loginPOM;
	private AddCustomerPom addCustomerPom;
	private SearchCustomer searchCustomer;

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws IOException {
		initializeWebDriver();
		driver = getInitializedDriver();
		loginPOM = new LoginPOM(driver);
		addCustomerPom = new AddCustomerPom(driver);
		searchCustomer = new SearchCustomer(driver);
	}

	@When("user opens URL “https:\\/\\/admin-demo.nopcommerce.com\\/login”")
	public void user_opens_url_https_admin_demo_nopcommerce_com_login() {
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("User enters emails as “admin@yourstore.com” and Password as “admin”")
	public void user_enters_emails_as_admin_yourstore_com_and_password_as_admin() {
		loginPOM.getEmail().clear();
		loginPOM.getEmail().sendKeys("admin@yourstore.com");
		loginPOM.getPassword().clear();
		loginPOM.getPassword().sendKeys("admin");
	}

	@When("click on login")
	public void click_on_login() {
		loginPOM.getLogin().click();
	}

	@Then("Page Tile should be “Dashboard \\/ nopCommerce administration”")
	public void page_tile_should_be_dashboard_nop_commerce_administration() {
		if (driver.getPageSource().contains("Login was unsuccessfull.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
		}
	}

	@When("user click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		loginPOM.getLogout().click();
	}

	@Then("Page Title should be “Your store . Login”")
	public void page_title_should_be_your_store_login() {

	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_menu() {
		addCustomerPom.getcustomerMainMenu().click();
		addCustomerPom.getcustomer().click();
	}

	@When("click on add new button")
	public void click_on_add_new_button() {
		addCustomerPom.getaddNewButton().click();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addCustomerPom.getnewEmail().sendKeys(randomString() + "@gmail.com");
		addCustomerPom.getnewPassword().sendKeys("password");
		addCustomerPom.getfirstName().sendKeys("Albert");
		addCustomerPom.getlastname().sendKeys("brut");
		if (addCustomerPom.getfemaleGender().isDisplayed()) {
			addCustomerPom.getfemaleGender().click();
		} else {
			addCustomerPom.getmalegender().click();
		}
		addCustomerPom.getdob().sendKeys("9/13/1995");
		addCustomerPom.getcompanyname().sendKeys("AutomationLabs");
		addCustomerPom.getcustomerRole().click();
		for (int i = 0; i < addCustomerPom.getRoles().size(); i++) {
			if (addCustomerPom.getRoles().get(i).getText().equalsIgnoreCase("Guests")) {
				addCustomerPom.getguestsRole().click();
			}
		}
		addCustomerPom.getmanagerOfVender().click();
		Select option = new Select(addCustomerPom.getmanagerOfVender());
		option.selectByVisibleText("Vendor 2");
		addCustomerPom.getadminComment().sendKeys("new employee");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addCustomerPom.getsave().click();
	}

	@Then("user can view confirmation message “ the new customer has been added successfully. ”")
	public void user_can_view_confirmation_message_the_new_customer_has_been_added_successfully() {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

	@When("enter customer email")
	public void enter_customer_email() {
		searchCustomer.getSearchEmail().sendKeys("james_pan@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchCustomer.getSerachButton().click();
	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		Assert.assertTrue(searchCustomer.getResultBody().getText().contains("james_pan@nopCommerce.com"));
	}

	@When("enter the firstname and lastname")
	public void enter_the_firstname_and_lastname() {
		searchCustomer.getSerachFirstName().sendKeys("John");
		searchCustomer.getSearchLastName().sendKeys("Smith");
	}

	@When("User should names in the search table")
	public void user_should_names_in_the_search_table() {
		Assert.assertTrue(searchCustomer.getResultBody().getText().contains("admin@yourStore.com"));
	}
}