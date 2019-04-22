package sprint4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fam.Family;
import indi.individual;
import other_dependencies.CompareDate;

public class US33 {
	public List<String> List_orphans(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		List<String> DEBUG = new ArrayList<>();
		System.out.println("US33: All orphaned children in a GEDCOM file");
		
		for (int i = 0; i < allFamilies.size(); i++) {
			List<String> deathDate = new ArrayList<>();
			int childrenSize = allFamilies.get(i).children.size();
			HashMap<String, List<String>> birthMap = new HashMap<>();
			if (childrenSize == 0)
				continue;
			
			Boolean lack = false;
			// Get parent's death date
			for (int j = 0; j < allPeople.size(); j++) {
				if (allFamilies.get(i).husband.equals(allPeople.get(j).id)) {
					// Check dead date
					if (allPeople.get(j).Deathday != "") {
						deathDate.add(allPeople.get(j).Deathday);
					} else
						lack = true;
				}
				if (allFamilies.get(i).wife.equals(allPeople.get(j).id)) {
					// Check dead?
					if (allPeople.get(j).Deathday != "") {
						deathDate.add(allPeople.get(j).Deathday);
					} else
						lack = true;
				}
			}
			if (lack) {
				//System.out.println("US32: Lack of GED data");
				continue;
			}
			
			
			// Check children birth date and plus 18
			for (String x : allFamilies.get(i).children) {
				for (int y = 0; y < allPeople.size(); y++) {
					if (x.equals(allPeople.get(y).id)) {	
						// Get child birth date
						if (birthMap.get(allPeople.get(y).Birthday) != null) {
							birthMap.get(BirthDatePlus18(allPeople.get(y).Birthday)).add(x);
						} else {
							List<String> newList = new ArrayList<>();
							newList.add(x);
							birthMap.put(BirthDatePlus18(allPeople.get(y).Birthday), newList);
						}
						break;
					}
				}
			}

			// Get the lastest dead parent date
			String parentSecondDeath = "";
			CompareDate compDate = new CompareDate();
			if (deathDate.get(0) == "" || deathDate.get(1) == "") {
				continue;
			}
			
			if (!compDate.CheckDate(deathDate.get(0), deathDate.get(1)))
				parentSecondDeath = deathDate.get(0);
			else
				parentSecondDeath = deathDate.get(1);

			
			// Compare the date
			for (Map.Entry<String, List<String>> entry : birthMap.entrySet()) {
				if (compDate.CheckDate(parentSecondDeath, entry.getKey())) {
					for (String childrenList : entry.getValue()) {
						System.out.println(childrenList + "at Family " + allFamilies.get(i).familyID);
						DEBUG.add(childrenList);
					}
				} 
			}
		}	
		return DEBUG;
	}

	public String BirthDatePlus18(String birthday) {
		String[] BDSplitStr = birthday.split(" ");
		BDSplitStr[2] = Integer.toString(Integer.parseInt(BDSplitStr[2]) + 18);
		return BDSplitStr[0] + " " + BDSplitStr[1] + " " + BDSplitStr[2];
	}
}