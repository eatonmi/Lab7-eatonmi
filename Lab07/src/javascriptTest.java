import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.SeleneseTestCase;

@SuppressWarnings("deprecation")
public class javascriptTest extends SeleneseTestCase {
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
			setUp("http://webtesting.idyll.org/", "*firefox");
	}

	@Test
	public void testJavascriptTest() throws Exception {
		selenium.open("/");
		selenium.click("link=JavaScript alert box");
		assertEquals("Hi, I'm a JavaScript alert box!", selenium.getAlert());
		selenium.type("num1", "99");
		selenium.type("num2", "199");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
