package sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import fam.Family;

public class US24
{
	public int[] Unique_families_by_spouses(ArrayList<Family> allFamilies)
	{	
		int[] DEBUG = new int[allFamilies.size()];
		Arrays.fill(DEBUG, -1);

		List<String> dupList = new ArrayList<>();
		dupList = UniqueFamilySpouse(allFamilies, DEBUG);

		for (String dupData : dupList)
		{
			System.out.println("Error(US24): Family " + dupData + "'s spouse and marriage date isn't Unique");
		}

		return DEBUG;
	}

	List<String> UniqueFamilySpouse(ArrayList<Family> allFamilies, int[] DEBUG)
	{
		String husband_name_buffer;
		String wife_name_buffer;
		String marriageBuffer;
		List<List<String>> list = new ArrayList<>();
		List<String> dupList = new ArrayList<>();
		for (int i = 0; i < allFamilies.size(); i++)
		{
			husband_name_buffer = allFamilies.get(i).husband;
			wife_name_buffer = allFamilies.get(i).wife;
			marriageBuffer = allFamilies.get(i).marrDate;

			// Check data availability
			if (husband_name_buffer == "")
			{
				DEBUG[i] = 2;
				System.out.println("Warning(US24): Family " + allFamilies.get(i).husband + "'s name is empty! (Lack of GED data?)");
				continue;
			}
			if (wife_name_buffer == "")
			{
				DEBUG[i] = 2;
				System.out.println("Warning(US24): Family " + allFamilies.get(i).wife + "'s name is empty! (Lack of GED data?)");
				continue;
			}
			if (marriageBuffer == "")
			{
				DEBUG[i] = 3;
				System.out.println("Warning(US24): Family " + allFamilies.get(i).familyID + "'s marriage date is empty! (Lack of GED data?)");
				continue;
			}

			// Data duplicate validation
			List<String> tmpList = new ArrayList<>(Arrays.asList(husband_name_buffer, wife_name_buffer, marriageBuffer));

			if (list.size() == 0)
			{
				list.add(tmpList);
				DEBUG[i] = 0;
				continue;
			}
			
			Boolean found = false;
			for (List<String> subList : list)
			{
				if (subList.equals(tmpList))
				{
					dupList.add(allFamilies.get(i).familyID);
					DEBUG[i] = 1;
					found = true;
					break;
				}
			}

			if (!found)
			{
				list.add(new ArrayList<String>(Arrays.asList(husband_name_buffer, wife_name_buffer, marriageBuffer)));
				DEBUG[i] = 0;
			}
		}
		return dupList;
	}
}
