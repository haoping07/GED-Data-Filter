package sprint4;

import java.util.ArrayList;
import indi.individual;

public class us29 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void list_deceased(ArrayList<individual> people) {
		for(int x = 0 ; x < people.size() ; x++) {
			if(check_death(people.get(x))) {
				System.out.println("Info(US29): id " + people.get(x).id + " is deceased.");
			}
		}
	}
	
	public static boolean check_death(individual person) {
		return person.isdead;
	}

}
