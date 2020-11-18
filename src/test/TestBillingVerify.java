package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chocAn.BillingVerify;
import chocAn.Member;


/**
 * This class tests the scenarios for Verify Member Number and Verify Member Card.
 * 
 * @author Zachary Stiles
 * @version 1.0
 */
public class TestBillingVerify {

	/**
	 * Tests verifyMemberNumber() for returning true.
	 */
	@Test
	public void testVerifyMemberNumberSuccess() {
		BillingVerify billingVerify = new BillingVerify();
		Member member = new Member();
		member.setName("TestName");
		member.setNumber("Number123");
		member.setAddress("TestAddress");
		member.setCity("TestCity");
		member.setState("TS");
		member.setStatus("suspended");
		member.addMemberToDatabase();
		assertTrue(billingVerify.verifyMemberNumber("Number123"));
		member.deleteMemberFromDatabase();
	}
	
	/**
	 * Tests verifyMemberNumber() for returning false.
	 */
	@Test
	public void testVerifyMemberCFailure() {
		BillingVerify billingVerify = new BillingVerify();
		assertFalse(billingVerify.verifyMemberNumber("failure"));
	}
	
	/**
	 * Tests verifyMemberCard() for returning true.
	 */
	@Test
	public void testVerifyMemberCardSuccess() {
		BillingVerify billingVerify = new BillingVerify();
		Member member = new Member();
		member.setName("TestName");
		member.setNumber("Number123");
		member.setAddress("TestAddress");
		member.setCity("TestCity");
		member.setState("TS");
		member.setStatus("suspended");
		member.addMemberToDatabase();
		assertTrue(billingVerify.verifyMemberCard("Number123"));
		member.deleteMemberFromDatabase();
	}
	
	/**
	 * Tests verifyMemberCard() for returning false.
	 */
	@Test
	public void testVerifyMemberCardFailure() {
		BillingVerify billingVerify = new BillingVerify();
		assertFalse(billingVerify.verifyMemberCard("failure"));
	}

}
