package org.jbehave.demo.google.pages;


import com.thoughtworks.selenium.Selenium;

/**
 * @author Yana_Velbovets
 *
 */
public class GoogleServiceLogin {

	private Selenium selenium;
	private static final String TIMEOUT = "10000";

	public GoogleServiceLogin(Selenium selenium) {
		this.selenium = selenium;
		if(!selenium.getTitle().equals("Вхід – Облікові записи Google")) {
            throw new IllegalStateException("This is not home page, current page is: " 
            		+ selenium.getLocation());
		}
	}
	
	public void enterUserName(String userName) {
		selenium.type("id=Email", userName);
	}
	
	public void enterPassord(String password) {
		selenium.type("id=Passwd", password);
	}
	
	public void pressEnterButton() {
		selenium.click("id=signIn");
		selenium.waitForPageToLoad(TIMEOUT);
	}
	
	public boolean isLoginErrorMessage(String message) {
		//return selenium.isElementPresent("errormsg_0_Passwd");
		selenium.isElementPresent("errormsg_0_Passwd");
		System.out.println(selenium.getText("errormsg_0_Passwd"));
		return selenium.getText("errormsg_0_Passwd").contains(message);
	}
	
	public void enterCorrectUserName(String userName) {
		selenium.type("id=Email", userName);
	}
	
	public void enterCorrectPassord(String password) {
		selenium.type("id=Passwd", password);
	}
	
	public String findAndClickLogout(){
		
		return selenium.getText("//a[@class='gb_y gb_4 gb_e gb_X']");
		}

	
}
