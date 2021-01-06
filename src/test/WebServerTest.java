package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.GivenParameterNotExistingException;
import src.ConfigManager;
import src.Configuration;
import src.MyWebServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class WebServerTest {

    Scanner keyboard = new Scanner(System.in);

	/*use this technique for check the console logs, method finded on stackoverflow*/
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	private ConfigManager configManager;
	private final int PORT = 8080;

	@Before
	public void setUpStreams() throws IOException {
		 configManager = new ConfigManager(new Configuration());

	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}


	@Test
	public void AcceptFailureTest() {
		ConfigManager configManager = new ConfigManager(new Configuration());
		
		ServerSocket serverConnect = null;
		ServerSocket serverConnect2 = null;
		String ex = "";
		try {
			serverConnect = new ServerSocket(configManager.getPort());
		
			serverConnect2 = new ServerSocket(configManager.getPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			ex = e.toString();
		}
		
		assertEquals("java.net.BindException: Address already in use: bind", ex);
		
	}
	
	@Test
	public void setStoppedState() throws GivenParameterNotExistingException{
		configManager.setState("Stopped");
		Assert.assertEquals("Stopped", configManager.getState());
	}
	@Test
	public void setRunningState() throws GivenParameterNotExistingException{
		configManager.setState("Running");
		Assert.assertEquals("Running", configManager.getState());
	}
	@Test
	public void setMaintainanceState() throws GivenParameterNotExistingException{
		configManager.setState("Maintanance");
		Assert.assertEquals("Maintanance", configManager.getState());
	}
	@Test
	public void setWrongState() throws GivenParameterNotExistingException{
		configManager.setState("test");
		Assert.assertEquals("Stopped", configManager.getState());
	}



}
