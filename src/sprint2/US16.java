package sprint2;

import java.util.ArrayList;

import fam.Family;
import indi.individual;

public class US16 {
	public void checkMaleNameAll(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for(Family fam : allFamilies) {
			try {
				ArrayList<Integer> statusList = checkMaleName(fam,allPeople);
			}
			catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public ArrayList<Integer> checkMaleName(Family fam, ArrayList<individual> allPeople) {
		individual husband = new individual("notExistHusband");
		ArrayList<individual> childList = new ArrayList<>();	
		if(fam.husband.length()!=0) {
			husband = searchByID(allPeople,fam.husband);
		}
		else {
			throw new IllegalArgumentException("ANOMALY[US16]: No husband in the family [ "
					+fam.familyID + "]");
		}
		String familyName = husband.name.split("/")[1];
		
		for(String id : fam.children) {
			childList.add(searchByID(allPeople,id));
		}
		
		ArrayList<Integer> statusList = new ArrayList<>();
		
		for(individual child : childList) {
			int status = 0; 
			if(child.sex == "" || child.name == "") {
				System.out.println("ABNROMAL(US16): FamilyID[" + fam.familyID + "]"
						+ child.id + " missing information");
			}
			else if(child.sex.equals("M ")) {
				String childName = child.name;
				String childFamilyName = child.name.split("/")[1];
				
				if(!familyName.equals(childFamilyName)) {
					System.out.println("ERROR(US16): FamilyID[" + fam.familyID + "]"
							+ " husband[" + husband.id +"] lastName[" + familyName + "]"
							+ " is not same with child [" + child.id+"]"
							+ " lastName[" + childFamilyName+"]");
					status = 1;
				}
			}
			statusList.add(status);
		}
		
		return statusList;
					
	}
	
	private individual searchByID(ArrayList<individual> allPeople, String ID) {
		for(int x = 0 ; x < allPeople.size() ; x++) {
    		if(ID.equals(allPeople.get(x).id)) {    		
    			return allPeople.get(x);
    		}
    	}
    	
    	return null;
	}

}
