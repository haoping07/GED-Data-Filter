//Auther:Song Xu
package birth_before;

import datecheck.checkdate_US01.java;

public class birth_before_marriage_US03 {
	public boolean birth_before_death(String birth_date,String marriage_date){
		String[] brith=birth_date.split(" ");
		String[] marriage=marriage_date.split(" ");

		if(checkdate_US01.checkyear(birth[2] , marriage[2])) {
			if(checkdate_US01.checkmonth(brith[1] , marriage[1])) {
				if(checkdate_US01.checkday(brith[0] , marriage[0])) {
					return true;
				}
			}
		}
		return false;
	}

}
