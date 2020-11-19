package test;

import static org.junit.Assert.*;

import org.junit.Test;
import chocAn.Provider;

/**
 * Partially tests the provider class and some of its methods
 * 
 * @author David Dillard
 * @version 1.0
 */
public class ProviderTest {

	/**
	 * Tests searchProviderNumber for returning true
	 */
	@Test
	public void testSearchProviderNumberSuccess() {
		Provider testProvider = new Provider();
		testProvider.setName("Test Name");
		testProvider.setNumber("randomnum");
		testProvider.setAddress("123 Street Rd");
		testProvider.setCity("Pine Apple");
		testProvider.setState("AL");
		testProvider.setZipCode("00000");
		testProvider.addProviderToDatabase();
		assertTrue(testProvider.searchProviderNumber("randomnum"));
		testProvider.deleteProviderFromDatabase();
	}
	
	/**
	 * Tests searchProviderNumber for returning false
	 */
	@Test
	public void testSearchProviderNumberFailure() {
		Provider testProvider = new Provider();
		assertFalse(testProvider.searchProviderNumber("DoNoExist"));
	}

	/**
	 * Tests getProviderByNumber for returning testProvider
	 */
	@Test
	public void testGetProviderByNumberSuccess() {
		Provider testProvider = new Provider();
		testProvider.setName("Test Name");
		testProvider.setNumber("randomnum");
		testProvider.setAddress("123 Street Rd");
		testProvider.setCity("Pine Apple");
		testProvider.setState("AL");
		testProvider.setZipCode("00000");
		testProvider.addProviderToDatabase();
		assertEquals(testProvider.getName(), testProvider.getProviderByNumber("randomnum").getName());
		assertEquals(testProvider.getNumber(), testProvider.getProviderByNumber("randomnum").getNumber());
		assertEquals(testProvider.getAddress(), testProvider.getProviderByNumber("randomnum").getAddress());
		assertEquals(testProvider.getCity(), testProvider.getProviderByNumber("randomnum").getCity());
		assertEquals(testProvider.getState(), testProvider.getProviderByNumber("randomnum").getState());
		assertEquals(testProvider.getZipCode(), testProvider.getProviderByNumber("randomnum").getZipCode());
		testProvider.deleteProviderFromDatabase();
	}

	/**
	 * Tests getProviderByNumber for returning null value
	 */
	@Test
	public void testGetProviderByNumberFailure() {
		Provider testProvider = new Provider();
		testProvider.setName("Test Name");
		testProvider.setNumber("randomnum");
		testProvider.setAddress("123 Street Rd");
		testProvider.setCity("Pine Apple");
		testProvider.setState("AL");
		testProvider.setZipCode("00000");
		testProvider.addProviderToDatabase();
		assertFalse(testProvider.getProviderByNumber("DoNoExist") == testProvider);
	}

}
