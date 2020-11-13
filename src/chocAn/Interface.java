package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Jacob Grinstead
 *
 */
public class Interface {
	private ManagerInterface manager;
	private ProviderInterface provider;
	private OperatorInterface operator;
	
	public static void main(String[] args){
		prompt();
	}
	
	public static void prompt(){
		String operation;
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Operator Interface", "Provider Interface", "Manager Interface"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which interface would you like to access?","ChocAn Terminal Interface",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Operator Interface");
		
		System.out.print(operation);
	}
}
