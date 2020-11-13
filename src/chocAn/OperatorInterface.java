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
	private boolean leave;
	
	public OperatorInterface(){
		leave=false;
		while(leave==false){
			prompt();
		}
	}
	public void prompt(){
		String type;
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Manage Member","Manage Provider", "Exit"};
		type = (String)JOptionPane.showInputDialog(frame, "What would you like to manage?","ChocAn Operator Interface",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Manage Member");
		if(type=="Exit"){
			
		}else if(type=="Manage Member"){
			
		}else if(type=="Manage Provider"){
			
		}else{
			
		}
	}
}
