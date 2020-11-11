package chocAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		return null; //needs for not null check on other end
	}
	
	public void addProviderToDatabase() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ChocAnProviders.csv", true));
			writer.append(name);
			writer.append(",");
			writer.append(number);
			writer.append(",");
			writer.append(address);
			writer.append(",");
			writer.append(city);
			writer.append(",");
			writer.append(state);
			writer.append(",");
			writer.append(zipCode);
			writer.append("\n");
			writer.close();
		} catch (IOException e) { // new FileWriter
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			writer.append("name");
			writer.append(",");
			writer.append("number");
			writer.append(",");
			writer.append("address");
			writer.append(",");
			writer.append("city");
			writer.append(",");
			writer.append("state");
			writer.append(",");
			writer.append("zipCode");
			writer.append("\n");
			for (Provider provider: providers) {
				writer.append(provider.getName());
				writer.append(",");
				writer.append(provider.getNumber());
				writer.append(",");
				writer.append(provider.getAddress());
				writer.append(",");
				writer.append(provider.getCity());
				writer.append(",");
				writer.append(provider.getState());
				writer.append(",");
				writer.append(provider.getZipCode());
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) { // new FileWriter
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} catch (FileNotFoundException e) { //new FileReader
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { //readLine
			// TODO Auto-generated catch block
			e.printStackTrace();
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
