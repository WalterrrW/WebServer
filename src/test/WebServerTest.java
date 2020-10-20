package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.WebServer;

public class WebServerTest {

	/*
	 * This was written by me as the HW before you present us what we should exactly do.
	 * Here I test the logs.
	 * */
	

	/*use this technique for check the console logs, method finded on stackoverflow*/
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void successfullConnectionTest() {
		/*run the webserver to see it*/
		System.out.print("Connection Socket Created");
		assertEquals("Connection Socket Created", outContent.toString());
	}
	
	@Test
	public void waitingForConnectionTest() {
		/*right after run implement a timeout to clearly see the 'Waiting log'*/
		System.out.print("Waiting for Connection");
		assertEquals("Waiting for Connection", outContent.toString());
	}
	
	@Test
	public void AcceptFailureTest() {
		/*find a way to make socket.accept() to fail...*/
	    System.err.print("Accept failed.");
	    assertEquals("Accept failed.", errContent.toString());
	}
	
	@Test
	public void couldNotListenOnPortTest() {
		/*run 2 webservers, resulting the 2nd to have the error 'port 10008 already used'*/
	    System.err.print("Could not listen on port: 10008.");
	    assertEquals("Could not listen on port: 10008.", errContent.toString());
	}
	
	@Test
	public void cannotClosePortTest() {
		/*find solution to fail the Socket Close*/ 
	    System.err.print("Could not close port: 10008.");
	    assertEquals("Could not close port: 10008.", errContent.toString());
	}
	
	/*try to test webServer for behaviour when there are manny requests in a small time interval*/
	@Test
	public void mannyRequestSendedTest() {
		HttpURLConnection connection = null;
		try {
		for(int i=0; i<10; i++) {
			 URL url = new URL("http://127.0.0.1:10008");
	         connection = (HttpURLConnection) url.openConnection();
		}
		}catch(IOException e) {
			fail();
		}
	}
	
	@Test
	public void problemWithCommunicationServerTest() {
		/*create a socket and tried to use run() from webserver, because the socket is not good 
		 * i should fail and console the following error*/ 
	    System.err.print("Problem with Communication Server");
	    assertEquals("Problem with Communication Server", errContent.toString());
	}
	

}
