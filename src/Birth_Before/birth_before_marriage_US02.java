//Auther:Song Xu
package Birth_Before;

import datecheck.checkdate_US01;

public class birth_before_marriage_US02 {
	public boolean birth_before_death(String birth_date,String marriage_date){
		String[] brith=birth_date.split(" ");
		String[] marriage=marriage_date.split(" ");

		if(checkdate_US01.checkyear(brith[2] , marriage[2])) {
			if(checkdate_US01.checkmonth(brith[1] , marriage[1])) {
				if(checkdate_US01.checkday(brith[0] , marriage[0])) {
					return true;
				}
			}
		}
		return false;
	}

}
