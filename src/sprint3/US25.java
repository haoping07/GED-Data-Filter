package sprint3;

import fam.Family;
import indi.individual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Mainprogram.*;

public class US25 {
	public static ArrayList<Family> allFamilies;
	public static ArrayList<individual> allPeople;
	public static String err;
	
	
	public static void main(String[] args) {
		output_format data;
		try {
			data = Main.main_output();
			unique_first_name(data.Families , data.People);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void unique_first_name(ArrayList<Family> families , ArrayList<individual> people){
		allPeople = people;
		allFamilies = families;
		ArrayList<individual> fam = new ArrayList<>();
		ArrayList<String> tmp = new ArrayList<>();
		individual itmp;
		for(int x = 0 ; x < allFamilies.size() ; x++) {
			fam.clear();
			tmp.clear();
			tmp = allFamilies.get(x).children;
			for(int y = 0 ; y < tmp.size() ; y++) {
				itmp = searchbyId(allPeople , tmp.get(y));
				fam.add(itmp);
			}
			fam.add(searchbyId(allPeople , allFamilies.get(x).husband));
			fam.add(searchbyId(allPeople , allFamilies.get(x).wife));
			if(!check_unique(fam)) {
				System.out.println("Debug messages(US25) [**ILLEGAL**]: name \"" + err + "\" is not unique in family " + allFamilies.get(x).familyID);
			}
		}
	}
	
	public static boolean check_unique(ArrayList<individual> member) {
		HashSet<String> names = new HashSet<>();
		String[] nametmp = new String[2];
		for(int a = 0 ; a < member.size() ; a++) {
			nametmp = member.get(a).name.split(" ");
			if(!names.contains(nametmp[0])) {
				names.add(nametmp[0]);
			}
			else {
				err = new String();
				err = nametmp[0];
				return false;
			}
		}
		return true;
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
