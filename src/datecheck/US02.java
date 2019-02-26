//Auther:Song Xu
package datecheck;

import java.util.ArrayList;

import fam.Family;
import indi.individual;

public class US02 {
	public static void main(String[] args) {
		System.out.println(birth_before_marriage("28 JAN 2019","28 JAN 2019"));
		System.out.println(birth_before_marriage("17 JAN 2019","28 JAN 2019"));
		System.out.println(birth_before_marriage("28 JAN 2019","28 FEB 2019"));
		System.out.println(birth_before_marriage("28 JAN 2018","28 JAN 2019"));
		System.out.println(birth_before_marriage("28 JAN 2019","18 JAN 2019"));
		System.out.println(birth_before_marriage("28 FEB 2019","28 JAN 2019"));
		System.out.println(birth_before_marriage("28 JAN 2019","28 JAN 2018"));
		System.out.println(birth_before_marriage("28 APR 2018","28 JAN 2019"));
		System.out.println(birth_before_marriage("28 JAN 2019","28 FEB 2019"));
		
	}
	
	public static void birth_before_marrage(ArrayList<individual> allPeople, ArrayList<Family> allFamilies) {
		for(Family fam:allFamilies) {
			String hus_bir="",wif_bir="";
			for(individual indi:allPeople) {
				if(indi.id.equals(fam.husband)) {
					hus_bir=indi.Birthday;
				}
				
				if(indi.id.equals(fam.wife)) {
					wif_bir=indi.Birthday;
				}
			}
			
			if(!valid_date(hus_bir)||!valid_date(wif_bir)||!valid_date(fam.marrDate)) {
				System.out.println("missing information");
				continue;
			}
			
			System.out.println(birth_before_marriage(hus_bir,fam.marrDate));
			System.out.println(birth_before_marriage(wif_bir,fam.marrDate));

		}
	}
	public static boolean birth_before_marriage(String birth_date,String marriage_date){
	
		String[] birth=birth_date.split(" ");
		String[] marriage=marriage_date.split(" ");

		if(checkdate_US01.checkyear(marriage[2], birth[2])) {
			if(!checkdate_US01.checkyeareq(marriage[2], birth[2])) {
				return true;
			}
			if(checkdate_US01.checkmonth(marriage[1], birth[1])) {
				if(!checkdate_US01.checkmontheq(marriage[1], birth[1])) {
					return true;
				}
				if(checkdate_US01.checkday(marriage[0], birth[0])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean valid_date(String date) {
    	return date.split(" ").length==3;
    }

}
