package chocAn;

import java.util.List;

public class Service {
	
	private String computerTime;
	private String serviceDate;
	private String providerNumber;
	private String memberNumber;
	private String serviceCode;
	private String comments;
	private String fee;
	
	public void addToDatabase() {
		//TODO: Implement
	}
	
	public List<Service> getMemberServices(String number) {
		//TODO: Implement
		return null;
	}
	
	public List<Service> getProviderServices(String number) {
		//TODO: Implement
		return null;
	}
	
	public String getComputerTime() {
		return computerTime;
	}
	
	public void setComputerTime(String computerTime) {
		this.computerTime = computerTime;
	}
	
	public String getServiceDate() {
		return serviceDate;
	}
	
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	public String getProviderNumber() {
		return providerNumber;
	}
	
	public void setProviderNumber(String providerNumber) {
		this.providerNumber = providerNumber;
	}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	public String getServiceCode() {
		return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getFee() {
		return fee;
	}
	
	public void setFee(String fee) {
		this.fee = fee;
	}
	
}
