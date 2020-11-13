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

public class Service {
	
	private String computerTime;
	private String serviceDate;
	private String providerNumber;
	private String memberNumber;
	private String serviceCode;
	private String comments;
	private String fee;
	
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
