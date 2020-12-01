package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chocAn.Member;

/**
 * This class is the JUnit test for the Member class.
 * @author Joseph Daly
 * version 1.0
 */
public class TestMember {
	private Member testMember;
	
	/**
	 * This method creates a test member before running tests.
	 * @throws Exception to be thrown.
	 */
	@Before
	public void setUp() throws Exception {
		testMember = new Member();
		testMember.setName("Test");
		testMember.setNumber("number");
		testMember.setAddress("address");
		testMember.setCity("city");
		testMember.setState("state");
		testMember.setZipCode("zip code");
		testMember.setStatus("status");
		testMember.addMemberToDatabase();
	}
	
	/**
	 * This method tests that searchMemberNumber correctly returns true with a correct search.
	 */
	@Test
	public void testSearchMemberNumber() {
		assertTrue(testMember.searchMemberNumber("number"));
	}
	
	/**
	 * This method tests that searchMemberNumber correctly returns false with a search for a nonexistent member number.
	 */
	@Test
	public void testSearchMemberNumberFailure() {
		assertFalse(testMember.searchMemberNumber("failure"));
	}
	
	/**
	 * This method tests that getName returns the correct name.
	 */
	@Test
	public void testGetName() {
		assertEquals("Test", testMember.getName());
	}
	
	/**
	 * This method tests that getNumber returns the correct number.
	 */
	@Test
	public void testGetNumber() {
		assertEquals("number", testMember.getNumber());
	}
	
	/**
	 * This method deletes the test member from the database.
	 */
	@After
	public void destroy() {
		testMember.deleteMemberFromDatabase();
	}

}
