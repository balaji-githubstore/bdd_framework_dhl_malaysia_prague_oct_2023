package com.dhl.steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dhl.base.AutomationWrapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {
	
	private AutomationWrapper wrapper;
	
	public EmployeeSteps(AutomationWrapper wrapper)
	{
		this.wrapper=wrapper;
	}

	@When("I click on PIM menu")
	public void i_click_on_pim_menu() {
		wrapper.driver.findElement(By.xpath("//span[text()='PIM']")).click();
	  
	}
	@When("I click on Add Employee")
	public void i_click_on_add_employee() {
		wrapper.driver.findElement(By.partialLinkText("Add Employ")).click();
	}
	@When("I fill the new employee form")
	public void i_fill_the_new_employee_form(DataTable dataTable) 
	{
		List<Map<String, String>> lists=dataTable.asMaps();
		
		System.out.println(lists.get(0));
		System.out.println(lists.get(0).get("firstname"));
		System.out.println(lists.get(0).get("lastname"));
		System.out.println(lists.get(0).get("middlename"));
		
		wrapper.driver.findElement(By.name("firstName")).sendKeys(lists.get(0).get("firstname"));
		
		wrapper.driver.findElement(By.name("middleName")).sendKeys(lists.get(0).get("middlename"));
	  
	}
	@When("I click on Save")
	public void i_click_on_save() {
	   
	}
	@Then("I should get the profile name as {string}")
	public void i_should_get_the_profile_name_as(String string) {
	
	}
	@Then("I should get firstname in the field {string}")
	public void i_should_get_firstname_in_the_field(String string) {
	  
	}

}
