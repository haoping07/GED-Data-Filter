// Author: Hao-Ping Lin
package sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import indi.individual;

public class US23
{
	public int[] Unique_name_and_birth_date(ArrayList<individual> allPeople)
	{	
		int[] DEBUG = new int[allPeople.size()];
		Arrays.fill(DEBUG, -1);

		// Hashtable for Error data
		List<String> dupList = new ArrayList<>();
		dupList = UniqueNameAndBirth(allPeople, DEBUG);

		// Error messages output
		for (String dupData : dupList)
		{
			System.out.println("Error(US23): Person " + dupData + "'s Name and Birthdate isn't Unique");
		}

		return DEBUG;
	}

	List<String> UniqueNameAndBirth(ArrayList<individual> allPeople, int[] DEBUG)
	{
		String nameBuffer;
		String birthdayBuffer;
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> dupList = new ArrayList<>();

		for (int i = 0; i < allPeople.size(); i++)
		{
			nameBuffer = allPeople.get(i).name;
			birthdayBuffer = allPeople.get(i).Birthday;

			// Check data availability
			if (nameBuffer == "")
			{
				DEBUG[i] = 2;
				System.out.println("Warning(US23): Person " + allPeople.get(i).id + "'s name is empty! (Lack of GED data?)");
				continue;
			}
			if (birthdayBuffer == "")
			{
				DEBUG[i] = 3;
				System.out.println("Warning(US23): Person " + allPeople.get(i).id + "'s birthday is empty! (Lack of GED data?)");
				continue;
			}

			// Data duplicate validation
			if (hm.get(nameBuffer) == null)
			{
				hm.put(nameBuffer, new ArrayList<String>());
				hm.get(nameBuffer).add(birthdayBuffer);
				DEBUG[i] = 0;
			}
			else
			{
				if (hm.get(nameBuffer).contains(birthdayBuffer))
				{
					dupList.add(allPeople.get(i).id);
					DEBUG[i] = 1;
				}
				else
				{
					hm.get(nameBuffer).add(birthdayBuffer);
					DEBUG[i] = 0;
				}
			}
		}
		return dupList;
	}
}