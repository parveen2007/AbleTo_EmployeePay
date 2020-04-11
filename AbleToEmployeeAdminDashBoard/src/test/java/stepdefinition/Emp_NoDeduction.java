package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Emp_NoDeduction extends DriverClass {
	
	@Given("^I am an Admin$")
	public void i_am_an_Admin() {
		// app folder is located locally under desktop/AbleTo folder
		driver.get("file:///C:/Users/tanvi/Desktop/AbleTo/app/login.html");
		
		driver.findElement(By.xpath(".//*[@name='form-username']")).sendKeys("admin123");
		driver.findElement(By.xpath(".//*[@name='form-password']")).sendKeys("foobar123");
		driver.findElement(By.id("btnLogin")).submit();
	}

	@Given("^I am on the Admin Dashboard page$")
	public void i_am_on_the_Admin_Dashboard_page() {
		String actualtitle = driver.getTitle();
		String expectedtitle = "AbleTo Admin Dashboard";
		
		if ((actualtitle!=null) && (expectedtitle!=null)) {
			Assert.assertEquals(expectedtitle, actualtitle);
		}
		else {
			Assert.fail("AbleTo admin dashboard not found");
		}
	}

	@When("^I select Add New Employee$")
	public void i_select_Add_New_Employee() {
			driver.findElement(By.id("btnAddEmployee")).click();
	}

	@Then("^I should be able to enter employee details$")
	public void i_should_be_able_to_enter_employee_details() {
		String expectedText = "Add New Employe";
		WebElement actualTextPath = driver.findElement(By.xpath(".//*[@class='modal-title']"));
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOf(actualTextPath));
		String actualText = actualTextPath.getText();
		System.out.println("actualText: " + actualText);
		
		if ((actualText!=null) && (expectedText!=null)) {
			Assert.assertEquals(actualText, expectedText);
		}
		else {
			Assert.fail("Employee detail page not shown");
		}
	}

	@Then("^First Name does not begin with “A” or “a”$")
	public void first_Name_does_not_begin_with_A_or_a() throws InterruptedException {
		WebElement b = driver.findElement(By.xpath(".//*[@id='employees-form']/div[1]/div/input"));
		WebDriverWait w = new WebDriverWait(driver, 3000);
		w.until(ExpectedConditions.visibilityOf(b));
		b.sendKeys("John");
		driver.findElement(By.xpath(".//*[@id='employees-form']/div[2]/div/input")).sendKeys("Adam");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='employees-form']/div[3]/div/input")).sendKeys("1");
	}

	@Then("^the employee should save$")
	public void the_employee_should_save() throws InterruptedException {
		WebElement cl = driver.findElement(By.xpath(".//*[@id='employees-form']//*[@class='form-group']//button[contains(text(), 'Submit')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOf(cl));
		cl.click();
		Thread.sleep(3000);
	}

	@Then("^I should see the employee in the table$")
	public void i_should_see_the_employee_in_the_table() {
		String expectedFirstName = "John";
		String expectedLastName = "Adam";
		WebElement FN = driver.findElement(By.xpath(".//*[@id='employee-table']/tbody/tr[2]/td[2]"));
		String actualFirstName = FN.getText();
		System.out.println(actualFirstName);
		WebElement LN = driver.findElement(By.xpath(".//*[@id='employee-table']/tbody/tr[2]/td[3]"));
		String actualLastName = LN.getText();
		System.out.println(actualLastName);
		if ((actualFirstName!=null) && (expectedFirstName!=null)&&(actualLastName!=null) && (expectedLastName!=null)) {
			Assert.assertEquals(actualFirstName+actualLastName, expectedFirstName+expectedLastName);
		}
		else {
			Assert.fail("Employee can not be seen in the table");
		}
	}

	@Then("^the Program Bonus amount is correct$")
	public void the_Program_Bonus_amount_is_correct() {
		String Bonus = driver.findElement(By.xpath(".//*[@id='employee-table']/tbody/tr[2]/td[7]")).getText();
		System.out.println(Bonus);
	}

	@Then("^the Total Biweekly Pay calculation is correct$")
	public void the_Total_Biweekly_Pay_calculation_is_correct() {
		String firstName = "John";
		String lastName = "Adam";
		int programId = 1;
		float expectedByWeeklyPay = getExpectedByWeeklyPay(firstName, programId, 0);
		String expectedByWeeklyPayStr = String.format("%.2f", expectedByWeeklyPay);
		System.out.println("expectedByWeeklyPay: " + expectedByWeeklyPayStr);

		String actualByWeeklyPayStr = driver.findElement(By.xpath(".//*[@id='employee-table']/tbody/tr[2]/td[8]")).getText();
		System.out.println("actualByWeeklyPay: " + actualByWeeklyPayStr);
		
		if ((actualByWeeklyPayStr!=null) && (expectedByWeeklyPayStr!=null)) {
			Assert.assertEquals(actualByWeeklyPayStr, expectedByWeeklyPayStr);
		}
		else {
			Assert.fail("Byweekly pay calculation is not correct for employee who's first name does not starts with 'a'");
		}
	}

	public static float getExpectedByWeeklyPay(String firstName, int programId, int deduction) {
		float baseSalary = 52000;
		float bonus = 0;
		
		if (programId == 1) {
			bonus = 5000;
		} else if (programId == 2) {
			bonus = 10000;
		} else if (programId == 3) {
			bonus = 15000;
		}

		if (firstName.toLowerCase().startsWith("a")) {
			bonus = bonus*(100-deduction)/100;
		}

		return (baseSalary + bonus) / 26;
	}
}
