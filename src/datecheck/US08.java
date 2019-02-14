package datecheck;

public class US08 {
	public class birth_before_marriage_of_parents_US08 {
		public boolean birth_before_marriage_of_parents(String birth_date,String parent_marriage_date) {
	        String[] birth = birth_date.split(" ");
	        String[] pmarriage = parent_marriage_date.split(" ");
	        //front base, later input
	        if (checkdate_US01.checkyear(pmarriage[2], birth[2])) {
	        	if (checkdate_US01.checkmonth(pmarriage[1], birth[1])) {
	        		if (checkdate_US01.checkday(pmarriage[0], birth[0])) {
	        			return true;
	        		}
	        	}
	        }
	       return false;
	    }
	}
}
