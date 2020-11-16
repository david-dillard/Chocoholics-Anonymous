package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Jacob Grinstead
 *
 */
public class OperatorInterface {
	private Manage manage;
	private String str;
	
	public OperatorInterface(){
		manage=new Manage();
		boolean cont = true;
		while(cont){
			prompt();
			if(str=="Manage Member"){
				System.out.println("Preparing to enter manage member");
				manage.manageMember();
				
			}else if(str=="Manage Provider"){
				System.out.println("Preparing to enter manage provider");
				manage.manageProvider();
				
			}else{
				System.out.println("Breaking from operator interface");
				cont=false;
			}
		}
	}
	public void prompt(){
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Manage Member","Manage Provider", "Exit"};
		str = (String)JOptionPane.showInputDialog(frame, "What would you like to manage?","ChocAn Operator Interface",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Manage Member");
	}
}
