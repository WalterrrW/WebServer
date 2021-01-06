package mockTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import exceptions.GivenParameterNotExistingException;
import exceptions.PortOutOfBoundException;
import exceptions.UsedPortException;
import src.ConfigManager;
import src.Configuration;

public class ConfigManagerMockTest {
	

	  
	  private ConfigManager mockConfigManager = mock(ConfigManager.class);


	  
		@Test
		public void setChangePort() throws PortOutOfBoundException, UsedPortException {
			mockConfigManager.setPort(80);
			when(mockConfigManager.getPort()).thenReturn(80);
			assertEquals(80, mockConfigManager.getPort());
		}
		
		@Test
		public void setChangePort2() throws PortOutOfBoundException, UsedPortException {
			mockConfigManager.setPort(80);
//			when(mockConfigManager.getPort()).thenReturn(mockConfigManager.getPort());
			assertEquals(0, mockConfigManager.getPort());
		}

	
}
