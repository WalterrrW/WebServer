package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ConfigNotInitializedException;
import exceptions.DefaultConfigCannotBeInitializedException;
import src.Config;

public class ConfigTest {

	private Config config = new Config();
	
	@Test(expected = ConfigNotInitializedException.class)
	public void getPortTest() {
		config.getPort();
	}
	
	@Test(expected = ConfigNotInitializedException.class)
	public void getBasicConfigFileTest() {
		config.getBasicConfigFile();
	}

	@Test(expected = ConfigNotInitializedException.class)
	public void getRootDirectory() {
		config.findOpenPort();
	}
	
	@Test(expected = DefaultConfigCannotBeInitializedException.class)
	public void setBasicConfigFile() {
		config.getPort();
	}
	
	@Test(expected = DefaultConfigCannotBeInitializedException.class)
	public void setBasicRootDirectory() {
		config.getBasicConfigFile();
	}

	@Test(expected = DefaultConfigCannotBeInitializedException.class)
	public void findOpenPort() {
		config.findOpenPort();
	}
}
