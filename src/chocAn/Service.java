package chocAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Entity class that contains information for service records.
 * 
 * @author Zachary Stiles
 * @version 1.0
 */
public class Service {
	
	private String computerTime;
	private String serviceDate;
	private String providerNumber;
	private String memberNumber;
	private String serviceCode;
	private String comments;
	private String fee;
	
	/**
	 * Adds this Service object to the ServiceRecords.csv file.
	 */
	public void addToDatabase() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ServiceRecords.csv", true));
			writer.append(computerTime + "," + serviceDate + "," + providerNumber + "," + memberNumber + "," + serviceCode + "," + comments + "," + fee +"\n");
			writer.close();
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ServiceRecords.csv file.");
		}
	}
	
	/**
	 * Retrieves all of the services corresponding to a member from the ServiceRecords.csv file.
	 * @param number the member's identification number
	 * @return a List of Service objects corresponding to specific member in the ServiceRecords.csv file, null if no services exist
	 */
	public List<Service> getMemberServices(String number) {
		List<Service> services = new ArrayList<Service>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ServiceRecords.csv"));
			String row = reader.readLine();
			String[] serviceData = new String[7];
			while ((row = reader.readLine()) != null) {
				serviceData = row.split(",");
				if (serviceData[3].equals(number)) {
					Service service = new Service();
					service.setComputerTime(serviceData[0]);
					service.setServiceDate(serviceData[1]);
					service.setProviderNumber(serviceData[2]);
					service.setMemberNumber(serviceData[3]);
					service.setServiceCode(serviceData[4]);
					service.setComments(serviceData[5]);
					service.setFee(serviceData[6]);
					services.add(service);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not find ServiceRecords.csv file.");
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ServiceRecords.csv file.");
		}
		return services;
	}
	
	/**
	 * Retrieves all of the services corresponding to a provider from the ServiceRecords.csv file.
	 * @param number the provider's identification number
	 * @return a List of Service objects corresponding to specific provider in the ServiceRecords.csv file, null if no services exist
	 */
	public List<Service> getProviderServices(String number) {
		List<Service> services = new ArrayList<Service>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ServiceRecords.csv"));
			String row = reader.readLine();
			String[] serviceData = new String[7];
			while ((row = reader.readLine()) != null) {
				serviceData = row.split(",");
				if (serviceData[2].equals(number)) {
					Service service = new Service();
					service.setComputerTime(serviceData[0]);
					service.setServiceDate(serviceData[1]);
					service.setProviderNumber(serviceData[2]);
					service.setMemberNumber(serviceData[3]);
					service.setServiceCode(serviceData[4]);
					service.setComments(serviceData[5]);
					service.setFee(serviceData[6]);
					services.add(service);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not find ServiceRecords.csv file.");
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ServiceRecords.csv file.");
		}
		return services;
	}
	
	/**
	 * Retrieves the exact time the computer received the service record.
	 * @return String containing the Service object's computer time (MM-DD-YYYY HH:MM:SS)
	 */
	public String getComputerTime() {
		return computerTime;
	}
	
	/**
	 * Sets the exact time the computer received the service record.
	 * @param computerTime string containing the Service object's computer time (MM-DD-YYYY HH:MM:SS)
	 */
	public void setComputerTime(String computerTime) {
		this.computerTime = computerTime;
	}
	
	/**
	 * Retrieves the date the service was provided.
	 * @return String containing the Service object's service date (MM-DD-YYYY)
	 */
	public String getServiceDate() {
		return serviceDate;
	}
	
	/**
	 * Sets the date the service was provided.
	 * @param serviceDate String containing the Service object's service date (MM-DD-YYYY)
	 */
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	/**
	 * Retrieves the Service object's corresponding provider number.
	 * @return String containing the provider's number (9 digits)
	 */
	public String getProviderNumber() {
		return providerNumber;
	}
	
	/**
	 * Sets the Service object's corresponding provider number.
	 * @param providerNumber String containing the provider's number (9 digits)
	 */
	public void setProviderNumber(String providerNumber) {
		this.providerNumber = providerNumber;
	}
	
	/**
	 * Retrieves the Service object's corresponding member number.
	 * @return String containing the member's number (9 digits)
	 */
	public String getMemberNumber() {
		return memberNumber;
	}
	
	/**
	 * Sets the Service object's corresponding member number.
	 * @param memberNumber String containing the member's number (9 digits)
	 */
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	/**
	 * Retrieves the Service object's corresponding service code.
	 * @return String containing the service code (6 digits)
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	
	/**
	 * Sets the Service object's corresponding service code.
	 * @param serviceCode String containing the service code (6 digits)
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	/**
	 * Retrieves the Service Record's optional comments.
	 * @return String containing the Service records comments (100 characters)
	 */
	public String getComments() {
		return comments;
	}
	
	/**
	 * Sets the Service Record's optional comments.
	 * @param comments String containing the Service records comments (100 characters)
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Retrieves the Service object's fee.
	 * @return String containing the Service object's fee (up to $999.99)
	 */
	public String getFee() {
		return fee;
	}
	
	/**
	 * Sets the Service object's fee.
	 * @param fee String containing the Service object's fee (up to $999.99)
	 */
	public void setFee(String fee) {
		this.fee = fee;
	}
	
}
