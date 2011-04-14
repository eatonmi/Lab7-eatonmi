

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

import java.util.regex.Pattern;

public class SeleniumScheduleTest extends SeleneseTestCase {
	static SeleniumServer server = null;
	@Before
	public void setUp() throws Exception {
		try {
			if(server == null) {
			server = new SeleniumServer();
			server.start();
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			setUp("http://www.rose-hulman.edu/", "*firefox");
	}

	@Test
	public void testSeleniumSchedule() throws Exception {
		selenium.open("/");
		selenium.click("link=Current Students");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.dailytools > table > tbody > tr > td > a:nth(1)");
		selenium.waitForPageToLoad("30000");
		selenium.type("UserID", "eatonmi");
		selenium.type("css=input[name=PIN]", "QwErTy123");
		selenium.click("css=p > input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=table.menuplaintable > tbody > tr:nth(1) > td.mpdefault > a.submenulinktext2");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Schedule Lookup Page (NOT Live Data)");
		selenium.waitForPageToLoad("30000");
		selenium.type("id1", "eatonmi");
		selenium.click("bt1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(""));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
