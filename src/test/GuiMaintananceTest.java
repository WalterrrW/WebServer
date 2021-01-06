package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gui.WebServerSetup;

public class GuiMaintananceTest {
	WebServerSetup baseFrame;
	
	@Before
	public void setUpGUI() throws IOException {
		System.out.println("wow");
		baseFrame = new WebServerSetup();
		baseFrame.maintananceServer.doClick();
		baseFrame.btnNewButton.doClick();
	}
	
	@After
	public void stopServer() throws InterruptedException {
		baseFrame.btnNewButton.doClick();
//		Thread.sleep(3000);
	}
	
	@Test
	public void checkIfServerRunning() throws IOException {
		
		assertEquals("Server is in state: Maintanance",baseFrame.webserverrunning.lblNewLabel.getText());	
	}
	
	@Test
	public void checkIfDefaultDir() throws IOException {
		assertEquals("Default Page is: ./www/maintanance.html",baseFrame.webserverrunning.lblNewLabel_1.getText());	
	}
}
