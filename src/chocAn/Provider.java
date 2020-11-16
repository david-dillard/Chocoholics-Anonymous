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
 * Entity class that contains information for providers.
 * 
 * @author Zachary Stiles
 * @version 1.0
 */
public class Provider {

	private String name;
	private String number;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	/**
	 * Searches the ChocAnProviders.csv file to see if a provider exists.
	 * @param number the provider's identification number
	 * @return true if the value if the provider exists, false if otherwise
	 */
	public boolean searchProviderNumber(String number) {
		List<Provider> providers = getProvidersFromDatabase();
		for (Provider provider : providers) {
			if (provider.getNumber().equals(number))
				return true;
		}
		return false;
	}
	
	/**
	 * Retrieves a provider from the ChocAnProviders.csv file.
	 * @param number the provider's identification number
	 * @return a Provider object with the corresponding number, null if the provider does not exist
	 */
	public Provider getProviderByNumber(String number) {
		List<Provider> providers = getProvidersFromDatabase();
		for (Provider provider : providers) {
			if (provider.getNumber().equals(number))
				return provider;
		}
		return null;
	}
	
	/**
	 * Adds this Provider object to the ChocAnProviders.csv file.
	 */
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
	
	/**
	 * Removes this Provider object from the ChocAnProviders.csv file.
	 */
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
	
	/**
	 * Updates this Provider object in the ChocAnProviders.csv file.
	 * @param number the Provider's previous number (in case it was changed)
	 */
	public void updateProviderInDatabase(String number) {
		String newNumber = this.number;
		this.number = number;
		deleteProviderFromDatabase();
		this.number = newNumber;
		addProviderToDatabase();
	}
	
	/**
	 * Retrieves all of the providers from the ChocAnProviders.csv file.
	 * @return a List of Provider objects for each provider in the ChocAnProviders.csv file, null if no providers exist
	 */
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
	
	/**
	 * Retrieves the Provider object's name.
	 * @return String containing the Provider object's name (25 characters)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the Provider object's name.
	 * @param name String containing the Provider object's name (25 characters)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retrieves the Provider object's number.
	 * @return String containing the Provider object's number (9 digits)
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets the Provider object's number.
	 * @param number String containing the Provider object's number (9 digits)
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Retrieves the Provider object's address.
	 * @return String containing the Provider object's address (25 characters)
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the Provider object's address.
	 * @param address String containing the Provider object's address (25 characters)
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Retrieves the Provider object's city.
	 * @return String containing the Provider object's city (14 characters)
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the Provider object's city.
	 * @param city String containing the Provider object's city (14 characters)
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Retrieves the Provider object's state.
	 * @return String containing the Provider object's state (2 letters)
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the Provider object's state.
	 * @param state String containing the Provider object's state (2 letters)
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Retrieves the Provider object's ZIP code.
	 * @return String containing the Provider object's ZIP code (5 digits)
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the Provider object's ZIP code.
	 * @param zipCode String containing the Provider object's ZIP code (5 digits)
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
