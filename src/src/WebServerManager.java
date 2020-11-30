package src;

import exceptions.PortOutOfBoundException;
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


    public static void main(String[] args) throws IOException {
        ConfigManager configManager = new ConfigManager(new Configuration());


//        while(true) {
//            System.out.println("Please enter a port where do you want your server to run or leave empty if want to use deaault port: "+ configManager.getPort());
//            System.out.println("You choose: ");
//            String port = myObj.nextLine();  // Read user input
//            if(port.length() == 0){
//                break;
//            } else{
//                try {
//                    boolean succeded = configManager.setPort(parseInt(port));
//                    if(succeded){
//                        break;
//                    }
//                }
//                catch (NumberFormatException e)
//                {
//                    System.out.println("This is not a number!");
//                } catch(PortOutOfBoundException e){
//                    System.out.println("Port Range must be between 1 - 65535!");
//                } catch(UsedPortException e){
//                    System.out.println("This port is being used");
//                }
//            }
//
//        }

        try {
            ServerSocket serverConnect = new ServerSocket(configManager.getPort());
            System.out.println("Server started.\nListening for connections on port : " + configManager.getPort() + " ...\n");

            // we listen until user halts server execution
            while (true) {
                MyWebServer myServer = new MyWebServer(serverConnect.accept(), configManager);

                if (Configuration.verbose) {
                    System.out.println("Connecton opened. (" + new Date() + ")");
                }

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

}
