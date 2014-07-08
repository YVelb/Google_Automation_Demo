package org.jbehave.demo.google;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.DefaultSelenium;

import org.openqa.selenium.server.SeleniumServer;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;


/**
 * @author Yana_Velbovets
 *
 */
public class BaseSeleniumActions {

	private Selenium selenium;
	private SeleniumServer seleniumServer;

	private static final int PORT = 4444;
	private static final String HOST = "localhost";
	private static final String BROWSER = "*firefox";
	private static final String BASE_URL = "https://google.com/";
	
	public BaseSeleniumActions() throws Exception {
		seleniumServer = new SeleniumServer();
		seleniumServer.start();
	}

	@BeforeScenario
	public void startSelenium() throws Exception {
		selenium = new DefaultSelenium(HOST, PORT, BROWSER, BASE_URL);
		selenium.start();
		selenium.windowFocus();
		selenium.windowMaximize();
	}

	@AfterStory
	public void stopSelenium() throws Exception {
		selenium.stop();
		seleniumServer.stop();
	}
		
	public Selenium getSelenium() {
		return selenium;
	}
	
	public void open(String url) {
		selenium.open(url);
	}
}
