package chocAn;
import java.io.FileWriter;
import java.io.IOException;

/**
 * helper class that contains a method to inform the user that EftData has been printed for the sake of this project
 * 
 * @author David Dillard
 * @version 1.0
 */
public class EftData extends Report{
	
	String providerName;
	String providerNumber;
	String amount;
	
	/**
	 * populates the attributes providerName, providerNumber, and amount
	 * @param name a provider's name
	 * @param number a provider's identification number
	 * @param weeklyFee the amount of money a provider must be paid for the week
	 */
	public EftData(String name, String number, String weeklyFee) {
		providerName = name;
		providerNumber = number;
		amount = weeklyFee;
	}
	
	/**
	 * creates a file of EFT Data for the week for a single provider
	 * The name of the file is the provider's name followed by 'EFT Data'
	 */
	public void printReport() {
		try {
			FileWriter eftFile = new FileWriter(providerName + "EFT Data");
			eftFile.append(providerName + "\n");
			eftFile.append(providerNumber + "\n");
			eftFile.append(amount + "\n");
			eftFile.close();
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}	
	}
}
