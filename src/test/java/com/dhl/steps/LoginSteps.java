package com.dhl.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.dhl.base.AutomationWrapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private AutomationWrapper wrapper;
	
	public LoginSteps(AutomationWrapper wrapper)
	{
		this.wrapper=wrapper;
	}
	
	@Given("I have browser with OrangeHRM application")
	public void i_have_browser_with_orange_hrm_application() 
	{
		wrapper.driver = new ChromeDriver();
		wrapper.driver .manage().window().maximize();
		wrapper.driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		wrapper.driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) 
	{
		wrapper.driver .findElement(By.name("username")).sendKeys(username);
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) 
	{
		wrapper.driver .findElement(By.name("password")).sendKeys(password);
	}
	
	@When("I click on login")
	public void i_click_on_login() 
	{
		wrapper.driver .findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Then("I should get access to dashboard with header {string}")
	public void i_should_get_access_to_dashboard_with_header(String expectedHeader) 
	{
	   System.out.println(expectedHeader);
	}

	@Then("I should not get access to the portal with error {string}")
	public void i_should_not_get_access_to_the_portal_with_error(String expectedError) {
	 
		String actualError=wrapper.driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}
}
