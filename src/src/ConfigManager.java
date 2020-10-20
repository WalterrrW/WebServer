package src;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class ConfigManager {
	private Config config;

	public ConfigManager(Config config) {
		this.config = config;
	}
	
	public boolean setConfigFile(String configFile) {
		return false;
	}
	
	public String setRootDirectory(String rootDirectory) {
		return null;
	}
	

	
	public boolean setPort(int portNumber) {
		if(portNumber < 0 || portNumber > 65535) {
			return false;
		} else if(!testIfOpenPort(portNumber)) {
			return false;
		} 
		
		config.setPort(portNumber);
		return true;	
	}
	
	public boolean testIfOpenPort(int port) {
		 ServerSocket ss = null;
		    DatagramSocket ds = null;
		    try {
		        ss = new ServerSocket(port);
		        ss.setReuseAddress(true);
		        ds = new DatagramSocket(port);
		        ds.setReuseAddress(true);
		        return true;
		    } catch (IOException e) {
		    } finally {
		        if (ds != null) {
		            ds.close();
		        }		        
	}
		    return false;
	}
}
