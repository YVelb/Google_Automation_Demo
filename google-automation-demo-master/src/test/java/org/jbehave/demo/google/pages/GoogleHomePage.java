package org.jbehave.demo.google.pages;

import com.thoughtworks.selenium.Selenium;

/**
 * @author Yana_Velbovets
 *
 */
public class GoogleHomePage {
	
	private Selenium selenium;
	private static final String TIMEOUT = "10000";
	
	public GoogleHomePage(Selenium selenium) {
		this.selenium = selenium;
		if(!selenium.getTitle().equals("Google")) {
            throw new IllegalStateException("This is not home page, current page is: " 
            		+ selenium.getLocation());
		}
	}
	
	public void openHomePage(String url) {
		selenium.open(url);
	}
	
	public GoogleServiceLogin clickLoginButton() {
		selenium.click("id=gb_70");
		selenium.waitForPageToLoad(TIMEOUT);
		return new GoogleServiceLogin(selenium);
	}
}
