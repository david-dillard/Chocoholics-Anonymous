package chocAn;

import javax.swing.JOptionPane;

public class Interface {
	private ManagerInterface manager;
	private ProviderInterface provider;
	private OperatorInterface operator;
	
	public static void main(String[] args){
		
	}
	
	public void prompt(){
		JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
	}
}
