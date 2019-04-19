package sprint4;

import indi.individual;
import java.util.ArrayList;

public class US31 {
	public void us31Func(ArrayList<individual> allPeople) {
		System.out.println("US31: All living people who has never been married:");
		ArrayList<String> res = findLivingSingle(allPeople);
		for(String s : res) {
			System.out.println(s);
		}
	}
	
	public ArrayList<String> findLivingSingle(ArrayList<individual> allPeople) {
		ArrayList<String> output = new ArrayList<>();
		for(individual indi : allPeople) {
			if(indi.isdead == false && indi.age >=30 && indi.spouse.size() == 0 ) {
				output.add(indi.id);
			}
		}
		return output;
	}

}
