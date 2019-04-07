package sprint3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import fam.Family;
import indi.individual;

public class US18 {
	private HashMap<String, HashSet<String>> hm = new HashMap<>();
	private HashMap<String, Family> famMap = new HashMap<>();
	
	public void initFamMap(ArrayList<Family> allFamilies) {
		for(Family fam : allFamilies) {
			famMap.put(fam.familyID,fam);
		}
	}
	
	public void findOwnSibling(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for(individual indi: allPeople) {
			for(String famID : indi.children) {
				HashSet<String> curSet = new HashSet<>(famMap.get(famID).children);
				if(!hm.containsKey(indi.id)) {
					hm.put(indi.id,curSet);
				}
				else {
					hm.get(indi.id).addAll(curSet);
				}
			}
		}
	}
	
	public boolean noMarriageToSibling(Family fam) {
		if(hm.containsKey(fam.husband) && hm.get(fam.husband).contains(fam.wife)) {
			return false;
		}
		else if(hm.containsKey(fam.wife) && hm.get(fam.wife).contains(fam.husband)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void us18Func(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		initFamMap(allFamilies);
		findOwnSibling(allPeople, allFamilies);
		for(Family fam : allFamilies) {
			if(!noMarriageToSibling(fam)) {
				System.out.println("ERROR(US18): FamilyID[ " + fam.familyID +"]"
						+ " parent marries with his/her sibling");
			}
		}
	}
	

}
