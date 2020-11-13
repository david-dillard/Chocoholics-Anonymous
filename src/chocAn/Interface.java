package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Interface {
	private ManagerInterface manager;
	private ProviderInterface provider;
	private OperatorInterface operator;
	
	public static void main(String[] args){
		prompt();
	}
	
	public static void prompt(){
		JFrame frame = new JFrame("ChocAn");
		JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
	}
}
