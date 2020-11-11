package chocAn;

import java.util.*;

public class Manage {
	private String err;
	
	public Manage(){
		err="Task Failed";
	}
	
	public void manageMember(){
		
	}
	
	public String addMember(){
		boolean found = false;
		List<Member> members = Member.getMembersFromDatabase();
		//code to search list && set boolean
		if (found){
			return "This member already exists in the ChocAn database.";
		}else{
			Member curr = new Member();
			
			return "The member has been added to the ChocAn database.";
		}
		return err;
	}
	
	public String updateMember(){
		
		return err;
	}
	
	public String deleteMember(){
		
		return err;
	}
	
	public void manageProvider(){
		
	}
	
	public String addProvider(){
		
		return err;
	}
	
	public String updateProvider(){
		
		return err;
	}
	
	public String deleteProvider(){
		
		return err;
	}

}
