package sprint4;

import indi.individual;
import java.util.ArrayList;



public class US30 {
	public void us30Func(ArrayList<individual> allPeople) {
		System.out.println("US30: All living people who has been married:");
		ArrayList<String> res = findLivingMarriage(allPeople);
		for(String s : res) {
			System.out.println(s);
		}
	}
	
	public ArrayList<String> findLivingMarriage(ArrayList<individual> allPeople) {
		ArrayList<String> output = new ArrayList<>();
		for(individual indi : allPeople) {
			if(indi.isdead == false && indi.spouse.size() != 0 ) {
				output.add(indi.id);
			}
		}
		return output;
	}

}
