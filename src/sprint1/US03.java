//Author: Song Xu
package sprint1;

import java.util.ArrayList;
import indi.individual;

public class US03 {
	
	public static void main(String[] args) {
		System.out.println(birth_before_death("28 JAN 2019","28 JAN 2019"));
		System.out.println(birth_before_death("17 JAN 2019","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","28 FEB 2019"));
		System.out.println(birth_before_death("28 JAN 2018","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","18 JAN 2019"));
		System.out.println(birth_before_death("28 FEB 2019","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","28 JAN 2018"));
		System.out.println(birth_before_death("28 APR 2018","28 JAN 2019"));
		System.out.println(birth_before_death("28 JAN 2019","28 FEB 2019"));
		
	}
	
	public static void birth_before_death(ArrayList<individual> allPeople) {
		for(individual indi:allPeople) {
			if(indi.isdead) {
				if(!birth_before_death(indi.Birthday,indi.Deathday)){
					System.out.println("Error(US03)[**ILLEGAL**]: " + "Birth date after Death date! ::" +
						indi.id);
				}
				
			}
		}
	}
	
    public static boolean birth_before_death(String birth_date,String death_date){
        String[] birth=birth_date.split(" ");
        String[] death=death_date.split(" ");
        if(checkdate_US01.checkyear(death[2], birth[2])) {
			if(!checkdate_US01.checkyeareq(death[2], birth[2])) {
				return true;
			}
			if(checkdate_US01.checkmonth(death[1], birth[1])) {
				if(!checkdate_US01.checkmontheq(death[1], birth[1])) {
					return true;
				}
				if(checkdate_US01.checkday(death[0], birth[0])) {
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

