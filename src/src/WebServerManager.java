package src;

import exceptions.GivenParameterNotExistingException;
import exceptions.PortOutOfBoundException;
import exceptions.UsedPortException;
import gui.WebServerRunning;
import gui.WebServerSetup;

import exceptions.UsedPortException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class WebServerManager extends Thread{

    protected Socket clientSocket;
    static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    
    public static ConfigManager configManager = new ConfigManager(new Configuration());
    
    public static ServerSocket serverConnect;
    
    public static void configure() {
	
   try {
   	 	
        serverConnect = new ServerSocket(configManager.getPort());
       System.out.println("Server started.\nListening for connections on port : " + configManager.getPort() + " ...\n");
       
       if(!configManager.getState().equals("Maintanance")) {
   		configManager.setState("Running");
   	}
       // we listen 
       while (true) {
    	  
    	   
           MyWebServer myServer = new MyWebServer(serverConnect.accept(), configManager);
           if (Configuration.verbose) {
               System.out.println("Connecton opened. (" + new Date() + ")");
           }
           
           Thread thread = new Thread(myServer);
          
           thread.start(); 
             
       }
       

   } catch (IOException e) {
       System.out.println("Server Stoped");
       System.out.println();
       
       try {
    	   configManager.setState("Stopped");
		configManager.setWebRootFile("./www");
		configManager.setMaintanancePage("./www/maintanance.html");
	} catch (GivenParameterNotExistingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   }
}

    public static void main(String[] args) throws IOException {

    	configure();
}
}