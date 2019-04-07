package sprint3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import fam.Family;

public class US17 {
	
	private HashMap<String, HashSet<String>> hm = new HashMap<>();
	
	public void findOwnChild(ArrayList<Family> allFamilies) {
		for(Family fam : allFamilies) {
			HashSet<String> curSet = new HashSet<>(fam.children);
			//wife
			if(!hm.containsKey(fam.wife)) {
				hm.put(fam.wife,curSet);
			}
			else {
				hm.get(fam.wife).addAll(curSet);
			}
			//husband
			if(!hm.containsKey(fam.husband)) {
				hm.put(fam.husband,curSet);
			}
			else {
				hm.get(fam.husband).addAll(curSet);
			}
		}
		
	}
	
	public boolean NoMarriageToChild(Family fam) {
		if(hm.get(fam.wife).contains(fam.husband) ||
				hm.get(fam.husband).contains(fam.wife)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void us17Func(ArrayList<Family> allFamilies) {
		findOwnChild(allFamilies);
		for(Family fam : allFamilies) {
			if(!NoMarriageToChild(fam)) {
				System.out.println("ERROR(US17): FamilyID[ " + fam.familyID +"]"
						+ " parent marries with his/her child");
			}
		}
	}
	

}

