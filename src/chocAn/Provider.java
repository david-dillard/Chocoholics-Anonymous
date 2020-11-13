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

public class Provider {

	private String name;
	private String number;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	public boolean searchProviderNumber(String number) {
		List<Provider> providers = getProvidersFromDatabase();
		for (Provider provider : providers) {
			if (provider.getNumber().equals(number))
				return true;
		}
		return false;
	}
	
	public Provider getProviderByNumber(String number) {
		List<Provider> providers = getProvidersFromDatabase();
		for (Provider provider : providers) {
			if (provider.getNumber().equals(number))
				return provider;
		}
		return null;
	}
	
	public void addProviderToDatabase() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ChocAnProviders.csv", true));
			writer.append(name + "," + number + "," + address + "," + city + "," + state + "," + zipCode + "\n");
			writer.close();
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ChocAnProviders.csv file.");
		}
	}
	
	public void deleteProviderFromDatabase() {
		List<Provider> providers = getProvidersFromDatabase();
		for (Provider provider : providers) {
			if (provider.getNumber().equals(number)) {
				providers.remove(providers.indexOf(provider));
				break;
			}
		}
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("ChocAnProviders.csv"));
		writer.append("name,number,address,city,state,zipCode\n");
			for (Provider provider: providers) {
				writer.append(provider.getName() + ",");
				writer.append(provider.getNumber() + ",");
				writer.append(provider.getAddress() + ",");
				writer.append(provider.getCity() + ",");
				writer.append(provider.getState() + ",");
				writer.append(provider.getZipCode() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ChocAnProviders.csv file.");
		}
	}
	
	public void updateProviderInDatabase(String number) {
		String newNumber = this.number;
		this.number = number;
		deleteProviderFromDatabase();
		this.number = newNumber;
		addProviderToDatabase();
	}
	
	public List<Provider> getProvidersFromDatabase() {
		List<Provider> providers = new ArrayList<Provider>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ChocAnProviders.csv"));
			String row = reader.readLine();
			String[] providerData = new String[6];
			while ((row = reader.readLine()) != null) {
				providerData = row.split(",");
				Provider provider = new Provider();
				provider.setName(providerData[0]);
				provider.setNumber(providerData[1]);
				provider.setAddress(providerData[2]);
				provider.setCity(providerData[3]);
				provider.setState(providerData[4]);
				provider.setZipCode(providerData[5]);
				providers.add(provider);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not find ChocAnProviders.csv file.");
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ChocAnProviders.csv file.");
		}
		return providers;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
