//Author: Song Xu

package sprint2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import datecheck.US02;
import fam.Family;
import indi.individual;


public class US11 {
	public static ArrayList<Boolean> NoBigamy(ArrayList<individual> individuals,ArrayList<Family> families) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		for(int i=0;i<families.size();i++) {
			Family fam1=families.get(i);
			if(!US02.valid_date(fam1.marrDate)) {
//				System.out.println("Warning(US11)[**MISSING**]: " + "MISSING MARRIAGE DATE ::FamilyID:" +
//						fam1.familyID);
				continue;
			}
			if(fam1.isDivored&&!US02.valid_date(fam1.divoDate)) {
//				System.out.println("Warning(US11)[**MISSING**]: " + "MISSING DIVORCE DATE ::FamilyID:" +
//						fam1.familyID);
				continue;
			}
			for(int j=0;j<i;j++) {
				Family fam2=families.get(j);
				if(!US02.valid_date(fam2.marrDate)||fam2.isDivored&&!US02.valid_date(fam2.divoDate)) {
					continue;
				}
				
				if(fam1.husband.equals(fam2.husband)) {				
					individual wif1=new individual(""),
							   wif2=new individual("");
					for(individual indi:individuals) {
						if(indi.id.equals(fam1.wife)) {
							wif1=indi;
						}
						else if(indi.id.equals(fam2.wife)) {
							wif2=indi;
						}
					}
					if(compare(fam1.marrDate,fam2.marrDate)) {
						results.add(NoBigamy(fam2,fam1,wif1));
					}
					else {
						results.add(NoBigamy(fam1,fam2,wif2));
					}
					
					
				}
				else if(fam1.wife.equals(fam2.wife)) {
					individual hus1=new individual(""),
							   hus2=new individual("");
					for(individual indi:individuals) {
						if(indi.id.equals(fam1.husband)) {
							hus1=indi;
						}
						else if(indi.id.equals(fam2.husband)) {
							hus2=indi;
						}
					}
					if(compare(fam1.marrDate,fam2.marrDate)) {
						results.add(NoBigamy(fam1,fam2,hus1));
					}
					else {
						results.add(NoBigamy(fam2,fam1,hus2));
					}
				}
				else {
					results.add(true);
				}
			}
		}
		
		return results;
	}
	
	public static boolean NoBigamy(Family fam1,Family fam2,individual indi) {
		return (indi.isdead && remarriageAfterDeath(fam2.marrDate,indi.Deathday))
				||(fam1.isDivored && remarriageAfterDivored(fam2.marrDate,fam1.divoDate)) ;
	}
	public static boolean compare(String date1,String date2) {
		return US02.birth_before_marriage(date1, date2);
	}
	
	public static boolean remarriageAfterDeath(String marriage_date,String death_date) {
		return US02.birth_before_marriage(death_date,marriage_date);
	}
	
	public static boolean remarriageAfterDivored(String marriage_date,String divored_date) {
		return US02.birth_before_marriage(divored_date,marriage_date);
	}
}
