package com.dhl.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class AutomationWrapper {
	public WebDriver driver;
	
	
	/**
	 * runs after each scenario
	 */
	@After
	public void endScenario()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
	}

}
