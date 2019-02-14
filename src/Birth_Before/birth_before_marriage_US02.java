//Auther:Song Xu
package Birth_Before;

import datecheck.checkdate_US01;

public class birth_before_marriage_US02 {
	public boolean birth_before_death(String birth_date,String marriage_date){
		String[] birth=birth_date.split(" ");
		String[] marriage=marriage_date.split(" ");

		if(checkdate_US01.checkyear(marriage[2], birth[2])) {
			if(checkdate_US01.checkmonth(marriage[1], birth[1])) {
				if(checkdate_US01.checkday(marriage[0], birth[0])) {
					return true;
				}
			}
		}
		return false;
	}

}
