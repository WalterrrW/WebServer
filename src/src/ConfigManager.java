package src;

import exceptions.GivenParameterNotExistingException;
import exceptions.PortOutOfBoundException;
import exceptions.UsedPortException;

import java.io.File;

public class ConfigManager {
	private Configuration config = new Configuration();

	public ConfigManager(Configuration config) {
		this.config = config;
	}
	
	public void setConfig(Configuration config) {
		this.config = config;
	}

	public File getWebRootFile(){
		return config.getWebRootFile();
	}
	public void setWebRootFile(String webRootName) throws GivenParameterNotExistingException {

		File tempFile = new File(webRootName);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException("Given parameter does not exists!");
		}
		config.setWebRootFile(tempFile);
	}

	public String getDefaultPage(){
		return config.getDefaultPage();
	}
	public void setDefaultPage(String defaultFile) throws GivenParameterNotExistingException {
		File tempFile = new File("./www/" + defaultFile);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException("Given parameter does not exists!");
		}
		config.setDefaultPage(defaultFile);
	}
	public String getMaintanancePage(){
		return config.getMaintanancePage();
	}
	public void setMaintanancePage(String maintananceFile) throws GivenParameterNotExistingException {
		File tempFile = new File(maintananceFile);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException("Given parameter does not exists!");
		}
		config.setMaintanancePage(maintananceFile);
	}
	public String getNotFoundPage(){
		return config.getNotFoundPage();
	}
	public void setFileNotFoundPage(String fileNotFound) throws GivenParameterNotExistingException {
		File tempFile = new File("./www/" + fileNotFound);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException("Given parameter does not exists!");
		}
		config.setFileNotFoundPage(fileNotFound);
	}
	public String getNotSuportedPage(){
		return config.getNotSuportedPage();
	}
	public void setNotSuportedPage(String methodNotSupported) throws GivenParameterNotExistingException {
		//test if existing
		File tempFile = new File("./www/" + methodNotSupported);
		boolean exists = tempFile.exists();
		if(!exists){
			throw new GivenParameterNotExistingException("Given parameter does not exists!");
		}
		config.setFileNotFoundPage(methodNotSupported);
	}

	public void setState(String newState) {
		if(config.setState(newState)){
//			System.out.println("State succesfully changed to" + config.getState());
		} else {
//			System.out.println("State cannot been changed, it remained: " + config.getState());
		}
	}
	
	public String getState() {
		return config.getState();
	}
	
	public int getPort(){
		return config.getPort();
	}
	
	public boolean setPort(int portNumber) throws PortOutOfBoundException, UsedPortException {
		if(portNumber < 0 || portNumber > 65535) {
			throw new PortOutOfBoundException("Ports must be between 1 -> 65534");
		}
	
		config.setPort(portNumber);
		return true;	
	}
	

}
