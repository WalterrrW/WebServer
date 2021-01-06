package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import gui.WebServerRunning;
import gui.WebServerSetup;
import src.ConfigManager;
import src.Configuration;
import src.WebServerManager;

public class GuiBaseTest {
	WebServerSetup baseFrame;
	WebServerRunning webserverrunning ;
	
	@Before
	public void setUpGUI() throws IOException {
		baseFrame = new WebServerSetup();
	}
	
	@Test
	public void checkIFRadioButtonFalse() throws IOException {	
		assertEquals(false,
				baseFrame.maintananceServer.isSelected());	
	}
	
	@Test
	public void checkIFRadioButtonTrue() throws IOException {
		baseFrame.maintananceServer.doClick();
		assertEquals(true,
				baseFrame.maintananceServer.isSelected());	
	}
	
	@Test
	public void checkIfDisplayedPortIsBasePort() throws IOException {
		assertEquals("8080",
				baseFrame.portNumberInput.getText());	
	}
	
	@Test
	public void checkIfChangedPort() throws IOException {
		baseFrame.portNumberInput.setText("8081");
		assertEquals("8081",
				baseFrame.portNumberInput.getText());	
	}
	
	@Test
	public void checkIfServerStopped() throws IOException {
		System.out.println(WebServerManager.configManager.getState());
		assertEquals("Stopped",WebServerManager.configManager.getState());	
	}
	

	
}
