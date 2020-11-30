package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class allows access to the operator interface, which allows members and providers to be managed
 * 
 * @author Jacob Grinstead
 * @version 1.0
 */
public class OperatorInterface {
	private Manage manage;
	private String str;
	
	/**
	 * This is the main method for the class. It determines how to direct an operator into the Manage class
	 */
	public OperatorInterface(){
		manage=new Manage();
		boolean cont = true;
		while(cont){
			prompt();
			if(str == null){
				cont=false;
				
			}else if(str.equals("Manage Member")){
				//System.out.println("Preparing to enter manage member");
				manage.manageMember();
				
			}else if(str.equals("Manage Provider")){
				//System.out.println("Preparing to enter manage provider");
				manage.manageProvider();
				
			}
		}
	}
	
	/**
	 * This method prompts a user for what they would like to do with a dialog box
	 */
	public void prompt(){
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Manage Member","Manage Provider"};
		str = (String)JOptionPane.showInputDialog(frame, "What would you like to manage?","ChocAn Operator Interface",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Manage Member");
	}
}
