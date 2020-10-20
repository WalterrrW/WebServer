package src;

public class Config {
	
	private final String BASIC_CONFIG_FILE = "configFile.txt";
	private String configFile = BASIC_CONFIG_FILE;
	
	private int port;
	
	private final String BASIC_ROOT_DIR = "configRootDir";
	private String configRootDir;
	
	
	public Config() {}
	
	public Config(String configFile) {
		this.configFile = configFile;
	}
	
	public String getBasicConfigFile() {
		return null;
	}
	
	public boolean setConfigFile(String configFile) {
		return false;
	}
	
	public boolean setBasicConfigFile(String configFile) {
		return false;
	}
	
	
	
	public String getRootDirectory() {
		return null;
	}
	
	public String setBasicRootDirectory() {
		return null;
	}
	
	public String setRootDirectory(String rootDirectory) {
		this.configRootDir = rootDirectory;
		return null;
	}
	
	
	
	public String getPort() {
		return null;
	}
	
	public boolean setPort(int portNumber) {
		this.port = portNumber;
		return false;
	}
	
	public boolean findOpenPort() {
		return false;
	}
	

}
