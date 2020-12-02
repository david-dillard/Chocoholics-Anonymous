package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class is the main interface which is used to interact with the ChocAn database
 * 
 * @author Jacob Grinstead
 * @version 1.0
 */
public class Interface {
	private static ManagerInterface manager;
	private static ProviderInterface provider;
	private static OperatorInterface operator;
	private static String str;
	
	/**
	 * This is the main code of the program. It begins by asking a user which terminal is to be accessed
	 * @param args - accepts arguments when running the program
	 */
	public static void main(String[] args){
		boolean cont=true;
		while(cont){
			prompt();
			if (str == null){
				cont=false;
				
			}else if(str.equals("Operator Interface")){
				//System.out.println("Preparing the operator interface");
				operator=new OperatorInterface();
				
			}else if(str.equals("Provider Interface")){
				//System.out.println("Preparing the provider interface");
				provider=new ProviderInterface();
				provider.prompt();
				
			}else if(str.equals("Manager Interface")){
				//System.out.println("Preparing the manager interface");
				manager=new ManagerInterface();
				manager.prompt();
				
			}else if(str.equals("Run Accounting Procedure")){
				//System.out.println("Preparing to run the accounting procedure");
				GenerateReports gen = new GenerateReports();
				gen.runAccountingProcedure();
			}
		}
		System.exit(0);
	}
	
	/**
	 * This method prompts the user via a dialog box
	 */
	public static void prompt(){
		String operation;
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Operator Interface", "Provider Interface", "Manager Interface","Run Accounting Procedure"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which interface would you like to access?","ChocAn Terminal Interface",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Operator Interface");
		//System.out.print(operation);
		str=operation;
	}
}
