package chocAn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class writes the Provider Directory from a csv file to 2 arrays containing the service codes and service names.
 * @author Joseph Daly
 * @version 1.0
 */
public class ProviderDirectory {
	
	private String[] serviceCodes;
	private String[] serviceNames;
	private int	position = 0;
	
	/**
	 * This is the constructor that reads the values from ProviderDirectory.csv into the given fields.
	 */
	public ProviderDirectory() {
		serviceCodes = new String[100];
		serviceNames = new String[100];
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ProviderDirectory.csv"));
			String row = reader.readLine();
			String[] serviceData = new String[2];
			while ((row = reader.readLine()) != null) {
				serviceData = row.split(",");
				serviceNames[position] = serviceData[0];
				serviceCodes[position] = serviceData[1];
				position ++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: ProviderDirectory.csv not found.");
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read ProviderDirectory.csv.");
		}
	}
	
	/**
	 * This method returns the list of service codes.
	 * @return serviceCodes
	 */
	public String[] getServiceCodes() {
		return serviceCodes;
	}
	
	/**
	 * This method returns the list of service names.
	 * @return serviceNames
	 */
	public String[] getServiceNames() {
		return serviceNames;
	}
	
	/**
	 * Returns the assigned service code of a given service name, returns null if the service name does not exist.
	 * @param name
	 * @return serviceCodes[i] or null
	 */
	public String getCode(String name) {
		int i = 0;
		while(serviceNames[i] != null) {
			if(serviceNames[i].equals(name)) {
				return serviceCodes[i];
			}
			i++;
		}
		JFrame frame = new JFrame("ERROR");
		JOptionPane.showMessageDialog(frame, "Error: Service name not found.");
		return null;
	}
	
	/**
	 * Returns the assigned service name of a given service code, returns null if the service code does not exist.
	 * @param code
	 * @return serviceNames[i] or null
	 */
	public String getName(String code) {
		int i = 0;
		while(serviceCodes[i] != null) {
			if(serviceCodes[i].equals(code)) {
				return serviceNames[i];
			}
			i++;
		}
		JFrame frame = new JFrame("ERROR");
		JOptionPane.showMessageDialog(frame, "Error: Service code not found.");
		return null;
	}
}
