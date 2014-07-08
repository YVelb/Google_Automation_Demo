package org.jbehave.demo.google.steps;

import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.demo.google.BaseSeleniumActions;
import org.jbehave.demo.google.pages.GoogleHomePage;

import org.jbehave.demo.google.pages.GoogleServiceLogin;
import org.junit.Assert;

/**
 * @author Yana_Velbovets
 *
 */
public class GoogleLoginSteps extends BaseSeleniumActions {

	public GoogleLoginSteps() throws Exception {
		super();
	}

	private GoogleHomePage homePage;
	private GoogleServiceLogin loginPage;
	private Map<String, String> message;
	private String pass = "validtestpassword";
	private String wrongPass = "wrong";
	private String login = "validtestjbehave@gmail.com";
	private String wrongLogin = "wrong@gmail.com";

	@Given("home google page $url")
	public void givenGoogleBasePase(String url) {
		open(url);
		homePage = new GoogleHomePage(getSelenium());
	}
	
	@Given("gmail authentication form")
	public void givenGoogleAuthenticationForm() {
		loginPage = homePage.clickLoginButton();
	}

	@When("the user has entered wrong username and password")
	public void whenEnteredWrongAccount() {
		loginPage.enterUserName(wrongLogin);
		loginPage.enterPassord(wrongPass);
	}

	@When("the user has entered wright username and password")
	public void whenEnteredWrightAccount() {
		loginPage.enterUserName(login);
		loginPage.enterPassord(pass);
	}

	@When("log-in button has been pressed")
	public void whenPressedLoginButton() {
		loginPage.pressEnterButton();
	}

	@Then("the user should see corresponding error message: $examplesTable")
	public void thenExpectingErrorMessage(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		Assert.assertTrue(loginPage.isLoginErrorMessage(message.get("message")));
	}
	
	@Then("logged in user should be able to press Logout button")
	public void thenLoginSuccessFull() {
		Assert.assertEquals(login, loginPage.findAndClickLogout());
	}
	
}
