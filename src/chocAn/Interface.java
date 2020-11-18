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
	 * @param args
	 */
	public static void main(String[] args){
		boolean cont=true;
		while(cont){
			prompt();
			if(str=="Operator Interface"){
				System.out.println("Preparing the operator interface");
				operator=new OperatorInterface();
				operator.prompt();
				
			}else if(str=="Provider Interface"){
				System.out.println("Preparing the provider interface");
				provider=new ProviderInterface();
				provider.prompt();
				
			}else if(str=="Manager Interface"){
				System.out.println("Preparing the manager interface");
				manager=new ManagerInterface();
				manager.prompt();
				
			}else if(str=="Run Accounting Procedure"){
				System.out.println("Preparing to run the accounting procedure");
				GenerateReports gen = new GenerateReports();
				gen.runAccountingProcedure();
				
			}else{
				System.out.println("Breaking from loop");
				cont=false;
			}
		}
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
		System.out.print(operation);
		str=operation;
	}
}
