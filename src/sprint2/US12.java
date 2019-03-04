package sprint2;
import fam.Family;
import indi.individual;

import java.util.ArrayList;


public class US12 {
	public void checkParentsAgeAll(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for(Family fam : allFamilies) {
			ArrayList<int[]> statusList = checkParentsAge(fam,allPeople);
			//System.out.println(statusList.size());
		}
	}
	
	
	public ArrayList<int[]> checkParentsAge(Family fam, ArrayList<individual> allPeople) {
		individual husband = new individual("notExistHus");
		individual wife = new individual("notExistWife");
		// create two not exist parents with age 0.
		ArrayList<individual> childList = new ArrayList<>();	
		if(fam.husband.length()!=0) {
			husband = searchByID(allPeople,fam.husband);
		}			
		if(fam.wife.length()!=0) {
			wife = searchByID(allPeople,fam.wife);
		}
		
		for(String id : fam.children) {
			childList.add(searchByID(allPeople,id));
		}
		
		ArrayList<int[]> statusList = new ArrayList<>();
		
		
		for(individual child : childList) {
			int[] status = new int[2]; 
			if(husband.age - child.age >=80) {
				System.out.println("ERROR(US12): FamilyID[" + fam.familyID + "]"
						+ " husband[" + husband.id +"] age[" + husband.age + "]"
						+ " is too old for child [" + child.id+"]"
						+ " age[" + child.age+"]");
				status[0] = 1;
			}
			if(wife.age - child.age >=60) {
				System.out.println("ERROR(US12): FamilyID[" + fam.familyID + "]"
						+ " wife[" + wife.id + "] age[" + wife.age + "]"
						+ " is too old for child [" + child.id+"]"
						+ " age[" + child.age+"]");
				status[1] = 1;
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
