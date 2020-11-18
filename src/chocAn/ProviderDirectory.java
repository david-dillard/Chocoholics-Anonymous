package chocAn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProviderDirectory {
	
	private String[] serviceCodes;
	private String[] serviceNames;
	private int	position = 0;
	
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
	
	public String[] getServiceCodes() {
		return serviceCodes;
	}
	
	public String[] getServiceNames() {
		return serviceNames;
	}
	
	public String getCode(String name) {
		int i = 0;
		while(serviceNames[i] != null) {
			if(serviceNames[i] == name) {
				return serviceCodes[i];
			}
		}
		JFrame frame = new JFrame("ERROR");
		JOptionPane.showMessageDialog(frame, "Error: Service name not found.");
		return null;
	}
	
	public String getName(String code) {
		int i = 0;
		while(serviceCodes[i] != null) {
			if(serviceCodes[i] == code) {
				return serviceNames[i];
			}
		}
		JFrame frame = new JFrame("ERROR");
		JOptionPane.showMessageDialog(frame, "Error: Service code not found.");
		return null;
	}
}
