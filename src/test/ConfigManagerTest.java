package test;

import org.junit.Test;

import exceptions.ConfigNotInitializedException;
import exceptions.GivenParameterNotExistingException;
import exceptions.UnreachablePortException;
import src.Config;
import src.ConfigManager;

public class ConfigManagerTest {

	private ConfigManager configManager = new ConfigManager(new Config());
	
	@Test(expected = UnreachablePortException.class)
	public void setPortOutOfRangeTest() {
		configManager.setPort(6700);
	}
	
	@Test(expected = UnreachablePortException.class)
	public void setUsedPortTest() {
		configManager.setPort(13);
	}

	@Test(expected = GivenParameterNotExistingException.class)
	public void rootDirectoryDoesNotExistTest() {
		configManager.setRootDirectory("BlueLagoon");
	}
	
	@Test(expected = GivenParameterNotExistingException.class)
	public void configFileDoesNotExistTest() {
		configManager.setConfigFile("BlueWhaleConfig.txt");
	}
}
