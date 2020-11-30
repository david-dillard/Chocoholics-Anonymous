package chocAn;
import java.io.FileWriter;
import java.io.IOException;

/**
 * class to handle EFT Data for the sake of keeping a record of what each provider must be paid for the week
 * 
 * @author David Dillard
 * @version 1.0
 */
public class EftData extends Report{
	
	private String providerName;
	private String providerNumber;
	private String amount;
	
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
			FileWriter eftFile = new FileWriter(providerName + " EFT Data.txt");
			eftFile.append("Provider Name: " + providerName + "\n");
			eftFile.append("Provider Number: " + providerNumber + "\n");
			eftFile.append("Total Amount Transferred: $" + amount + "\n");
			eftFile.close();
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}	
	}
}
