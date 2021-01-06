package test;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gui.WebServerRunning;
import gui.WebServerSetup;
import src.WebServerManager;

public class GuiRunningTest {
	WebServerSetup baseFrame;
	
	@Before
	public void setUpGUI() throws IOException {
		baseFrame = new WebServerSetup();
		baseFrame.btnNewButton.doClick();
	}
	
	@After
	public void stopServer() throws InterruptedException {
		baseFrame.btnNewButton.doClick();
//		Thread.sleep(3000);
	}
	
	@Test
	public void checkIfServerRunning() throws IOException {
		
		assertEquals("Server is in state: Running",baseFrame.webserverrunning.lblNewLabel.getText());	
	}
	
	@Test
	public void checkIfDefaultDir() throws IOException {
		assertEquals("Default Page is: .\\www\\index.html",baseFrame.webserverrunning.lblNewLabel_1.getText());	
	}
	
}
