package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chocAn.ProviderDirectory;

/**
 * This class tests the for getting names and codes from provider directory
 * 
 * @author Jacob Pacheco
 * @version 1.0
 */
public class TestProviderDirectory {

	/**
	 * Tests getName for the correct return
	 */
	@Test
	public void testGetName() {
		ProviderDirectory providerDirectory = new ProviderDirectory();
		assertEquals("Yoga", providerDirectory.getName("555555"));
	}
	
	/**
	 * Tests getName for null return when looking for name that isn't in provider directory
	 */
	@Test
	public void testGetNameFail() {
		ProviderDirectory providerDirectory = new ProviderDirectory();
		assertEquals(null, providerDirectory.getName("777777"));
	}
	
	/**
	 * Tests getCode for the correct return
	 */
	@Test
	public void testGetCode() {
		ProviderDirectory providerDirectory = new ProviderDirectory();
		assertEquals("333333", providerDirectory.getCode("Weight loss"));
	}
	
	/**
	 * Tests getCode for null return when looking for code that isn't in provider directory
	 */
	@Test
	public void testGetCodeFail() {
		ProviderDirectory providerDirectory = new ProviderDirectory();
		assertEquals(null, providerDirectory.getCode("Eat more chocolate"));
	}
	
	
}
