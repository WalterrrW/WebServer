package seleniumTesting;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import gui.WebServerSetup;

public class BaseSeleniumTest {
	
	private WebDriver driver;
	JavascriptExecutor js;
	WebServerSetup baseFrame;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\WalterSipos\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		baseFrame = new WebServerSetup();
		baseFrame.btnNewButton.doClick();
	}
	
	@After
	public void tearDown() {
		try {
			baseFrame.btnNewButton.doClick();
			driver.quit();
		} catch (Exception e) {
		}
	}

	@Test
	public void TestBasePage() {
		driver.get("http://localhost:8080/");
		assertEquals("Index", driver.getTitle());
	}

	@Test
	public void TestElementsFromTestPage() {
		driver.get("http://localhost:8080/dsa");
		System.out.println(driver.getTitle());
		assertEquals("NotFound", driver.getTitle());
	}
	
	
}
