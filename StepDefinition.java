package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	public ChromeDriver driver;
	Set<String> allWindows;
	List<String> allhandles;
	Set<String> allWindows2;
	List<String> allhandles2;

	@Given("Open Chrome browser")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("Load the application URL")
	public void loadApplication() {
		driver.get("http://leaftaps.com/opentaps");
	}

	@Given("Enter the username as 'Demosalesmanager'")
	public void enterUsername() {
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

	}

	@Given("Enter the password as 'crmsfa'") // crmsfa
	public void enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");

	}

	@When("Click on Login button")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@Then("Homepage should be displayed")
	public void verifyHomePage() {
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if (displayed) {
			System.out.println("Homepage displayed");
		} else {
			System.out.println("Homepage is not displayed");
		}
	}

	@But("Error message should be displayed")
	public void verifyErroeMessage() {
		boolean displayed = driver.findElement(By.id("errorDiv")).isDisplayed(); // true / false
		if (displayed) {
			System.out.println("Error message is displayed");
		} else {
			System.out.println("Error message is not displayed");

		}
	}

	@When("Click on CRMSFA link")
	public void clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@Then("MyHomePage should be displayed")
	public void verifyMyHomePage() {
		boolean displayed = driver.findElement(By.xpath("//div[text()='My Home']")).isDisplayed();
		if (displayed) {
			System.out.println("My Homepage displayed");
		} else {
			System.out.println("My Homepage is not displayed");

		}
	}

	@When("Click on Leads")
	public void clickLeads() {
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	}

	@When("Click on Create Lead link")
	public void clickCreateLead() {
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
	}

	@When("Enter the Company name as {string}")
	public void enterCname(String companyname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}

	@When("Enter First name as {string}")
	public void enterfname(String firstname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
	}

	@When("Enter Last name as {string}")
	public void enterlname(String lastname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
	}

	@When("Click on Create Lead button")
	public void clickCreateLeadbutton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Get the title of the page")
	public void getTitle() {
		System.out.println("The page title is: " + driver.getTitle());
	}

	@When("Click on Find Lead link")
	public void click_on_find_lead_link() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("Click on Phone")
	public void click_on_phone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@When("Enter the Phone number as 99")
	public void enter_the_phone_number_as() {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
	}

	@When("Click on Find Leads button")
	public void click_on_find_leads_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@When("Click on Lead ID link")
	public void click_on_lead_id_link() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@When("Click on Delete button")
	public void click_on_delete_button() {
		driver.findElement(By.linkText("Delete")).click();

	}

	@When("Click on Edit button")
	public void click_on_edit_button() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@When("Change the company name as 'ABC'")
	public void change_the_company_name_as() {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("ABC");
	}

	@When("Click on Update button")
	public void click_on_update_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@When("Click on Duplicate button")
	public void click_on_duplicate_button() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}

	@When("Click on Merge Leads link")
	public void click_on_merge_leads_link() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}

	@When("Click on From Lead lookup")
	public void click_on_from_lead_lookup() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}

	@When("Enter the firstname in From Lead lookup as 'Vaishnavi'")
	public void enter_the_firstname_in_from_lead_lookup_as() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Vaishnavi");
	}

	@When("Click on To Lead lookup")
	public void click_on_to_lead_lookup() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		allWindows2 = driver.getWindowHandles();
		allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
	}

	@When("Enter the firstname in To Lead lookup as 'Lakshanya'")
	public void enter_the_firstname_in_to_lead_lookup_as() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Lakshanya");
	}

	@When("Click on Merge button")
	public void click_on_merge_button() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	@When("Click on Lead ID link in From Lead lookup")
	public void click_on_lead_id_link_in_from_lead_lookup() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
	}
	
	@When("Click on Lead ID link To Lead lookup")
	public void click_on_lead_id_link_to_lead_lookup() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	   
	}
}

