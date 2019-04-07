package sprint3;

import java.util.ArrayList;
import java.util.HashMap;

import fam.Family;
import indi.individual;

public class US21 {
	public static ArrayList<Boolean> CorrectGender(ArrayList<individual> individuals,ArrayList<Family> families) {
		ArrayList<Boolean> result=new ArrayList<Boolean>();
		HashMap<String,Integer> index = new HashMap<String,Integer>();
		for(int i=0;i<individuals.size();i++) {
			index.put(individuals.get(i).id,i);
		}
		for(Family fam:families) {
			int hi=index.get(fam.husband),wi=index.get(fam.wife);
			String hus=individuals.get(hi).sex,wif=individuals.get(wi).sex;
			if(hus.contains("M")) {
				result.add(true);
			}
			else {
				result.add(false);
				System.out.println("Error message(US21): husband "+fam.husband+" in family "+fam.familyID+" is in wrong gender");
			}
			if(wif.contains("F")) {
				result.add(true);
			}
			else {
				result.add(false);
				System.out.println("Error message(US21): wife "+fam.wife+" in family "+fam.familyID+" is in wrong gender");
			}
		}
		return result;
	}
}
