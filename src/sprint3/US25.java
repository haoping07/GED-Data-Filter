package sprint3;

import fam.Family;
import indi.individual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Mainprogram.*;

public class US25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			unique_first_name();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void unique_first_name() throws IOException {
		output_format data = Main.main_output();
		ArrayList<individual> allPeople = data.People;
		ArrayList<Family> allFamilies = data.Families;
		ArrayList<individual> fam = new ArrayList<>();
		ArrayList<String> tmp = new ArrayList<>();
		individual itmp;
		HashSet<String> names = new HashSet<>();
		String[] nametmp = new String[2];
		for(int x = 0 ; x < allFamilies.size() ; x++) {
			fam.clear();
			tmp.clear();
			names.clear();
			tmp = allFamilies.get(x).children;
			for(int y = 0 ; y < tmp.size() ; y++) {
				itmp = searchbyId(allPeople , tmp.get(y));
				fam.add(itmp);
			}
			fam.add(searchbyId(allPeople , allFamilies.get(x).husband));
			fam.add(searchbyId(allPeople , allFamilies.get(x).wife));
			for(int a = 0 ; a < fam.size() ; a++) {
				nametmp = fam.get(a).name.split(" ");
				if(!names.contains(nametmp[0])) {
					names.add(nametmp[0]);
				}
				else {
					System.out.println("Debug messages(US25) [**ILLEGAL**]: name " + nametmp[0] + "is not unique in family " + allFamilies.get(x).familyID);
				}
			}
		}
	}
	
    public static individual searchbyId(ArrayList<individual> people , String target) {
    	for(int x = 0 ; x < people.size() ; x++) {
    		if(target.equals(people.get(x).id)) {    		
    			return people.get(x);
    		}
    	}
    	return null;
    }
	

}
