package sprint4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fam.Family;
import indi.individual;

public class US32 {
	public List<String> List_multiple_births(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		List<String> DEBUG = new ArrayList<>();
		System.out.println("US32: All multiple births in a GEDCOM file");

		for (int i = 0; i < allFamilies.size(); i++) {
			int childrenSize = allFamilies.get(i).children.size();
			HashMap<String, List<String>> birthMap = new HashMap<>();

			if (childrenSize > 1) {
				for (int j = 0; j < childrenSize; j++) {
					String IndiID = allFamilies.get(i).children.get(j);
					// childenBirthDateList.add(gBirthDateByIndiID(IndiID, allPeople));
					for (individual q : allPeople) {
						if (q.id.equals(IndiID)) {
							if (birthMap.get(q.Birthday) != null) {
								birthMap.get(q.Birthday).add(q.id);
							} else {
								List<String> newList = new ArrayList<>();
								newList.add(q.id);
								birthMap.put(q.Birthday, newList);
							}
							break;
						}
					}
				}

				for (Map.Entry<String, List<String>> entry : birthMap.entrySet()) {
					if (entry.getValue().size() > 1) {
						for (String id : entry.getValue()) {
							System.out.println(id + "at Family " + allFamilies.get(i).familyID);
							DEBUG.add(id);
						}
					}
				}
			}

		}
		return DEBUG;
	}
}
