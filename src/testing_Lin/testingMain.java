//Author: Hao-Ping Lin
//This file is the custom GED file handler
package testing_Lin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import fam.Family;
import indi.individual;

public class testingMain 
{
	public static ArrayList<individual> allPeople = new ArrayList<individual>();
	public static ArrayList<Family> allFamilies = new ArrayList<Family>();

	public static ObjectSet startHere(String path) throws IOException 
	{
		// Default "MyFamily.ged"
		Testing(path);
		updatemerrage(allPeople, allFamilies);
		ObjectSet objectReturn = new ObjectSet();
		return objectReturn;
	}

	public static void Testing(String pathname) throws IOException 
	{
		File filename = new File(pathname);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
		BufferedReader br = new BufferedReader(reader);
		String line = " ";
		// add something to save tags
		individual person = null;
		Family family = null;
		String[] tags = new String[3];
		while (line != null) {
			line = br.readLine();
			if (line == null)
				break;

			String[] temp = line.split(" ");
			String Tag;
			if (temp[temp.length - 1].equals("INDI") || temp[temp.length - 1].equals("FAM"))
				Tag = temp[temp.length - 1];
			else
				Tag = temp[1];

			// LS: add to object
			switch (temp[0]) {
			case "0":
				tags[0] = Tag;
				break;
			case "1":
				tags[1] = Tag;
				break;
			case "2":
				tags[2] = Tag;
				break;
			default:
				break;
			}
			StringBuffer content = new StringBuffer();
			if (Tag.equals("INDI") || Tag.equals("FAM")) 
			{
				for (int x = 1; x < temp.length - 1; x++) 
				{
					content.append(temp[x] + " ");
				}
			} else {
				for (int x = 2; x < temp.length; x++) 
				{
					content.append(temp[x] + " ");
				}
			}

			switch (temp[0]) 
			{
			case "0":
				if (Tag.equals("INDI")) 
				{
					if (person != null)
						allPeople.add(person);
					person = new individual(content.toString());
				}

				// LS: missing {} after else if here
				else if (Tag.equals("FAM")) 
				{
					if (family != null)
						allFamilies.add(family);
					family = new Family(content.toString());
				}
				break;
			case "1":
				if (tags[0].equals("INDI")) 
				{
					if (!Tag.equals("BIRT") && !Tag.equals("DEAT"))
						person.update(Tag, content.toString());
				}

				else if (tags[0].equals("FAM")) 
				{
					if (!Tag.equals("MARR") && !Tag.equals("DIV"))
						family.update(Tag, content.toString());
				}
				break;
			case "2":
				if (tags[0].equals("INDI")) 
				{
					if (tags[1].equals("BIRT") || tags[1].equals("DEAT")) {
						person.update(tags[1], content.toString());
					}
				}

				else if (tags[0].equals("FAM")) 
				{
					if (tags[1].equals("MARR") || tags[1].equals("DIV")) {
						family.update(tags[1], content.toString());
					}
				}

				break;
			default:
				break;
			}
		}
		allPeople.add(person);
		allFamilies.add(family);
		br.close();
	}

	public static void updatemerrage(ArrayList<individual> people, ArrayList<Family> families) 
	{
		String hus, wif, chi;
		int hid, wid, cid;
		for (int x = 0; x < families.size(); x++) 
		{
			hus = families.get(x).husband;
			wif = families.get(x).wife;
			for (int y = 0; y < families.get(x).children.size(); y++) 
			{
				chi = families.get(x).children.get(y);
				cid = searchbyId(people, chi);
				if (cid == -1)
					continue;
				people.get(cid).update("CHIL", families.get(x).familyID);
			}
			hid = searchbyId(people, hus);
			if (hid != -1)
				people.get(hid).update("SPOU", families.get(x).familyID);
			wid = searchbyId(people, wif);
			if (wid != -1)
				people.get(wid).update("SPOU", families.get(x).familyID);
		}

	}

	public static int searchbyId(ArrayList<individual> people, String target) 
	{
		for (int x = 0; x < people.size(); x++) 
		{
			if (target.equals(people.get(x).id)) 
			{
				return x;
			}
		}
		return -1;
	}
}
