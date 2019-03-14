package sprint2;

import java.util.ArrayList;

import fam.Family;
import indi.individual;

public class US13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public US13() {
		
	}
	
	public void sibiling_space(ArrayList<individual> people , ArrayList<Family> families) {
		ArrayList<individual> children_us13 = new ArrayList<individual>();
		individual temp = null;
		int idx = 0;
		for(int x = 0 ; x < families.size() ; x++) {
			children_us13.clear();
			if(families.get(x).children.size() == 0) {
				continue;
			} 
			for(int y = 0 ; y < families.get(x).children.size() ; y++) {
				idx = searchbyId(people , families.get(x).children.get(y));
				if(idx == -1) {
					System.out.println("Debug messages(US13)[WARNING]: No individual found for person " + families.get(x).children.get(y));
					continue;
				}
				temp = people.get(idx);
				children_us13.add(temp);
			}
			if(children_us13.size() <= 1) {
				continue;
			}
			else {
				for(int a = 0 ; a < children_us13.size()-1 ; a++) {
					for(int b = a+1 ; b < children_us13.size() ; b++) {
						if(!check_space(children_us13.get(a).Birthday , children_us13.get(b).Birthday)) {
							System.out.println("Debug messages(US13)[**ILLEGAL**]: Sibiling Space illigle " + children_us13.get(a).id + " / " + children_us13.get(b).id);
						}
					}
				}
			}
		}
	}
	
	public static boolean check_space(String sib1 , String sib2) {
		String[] s1 = sib1.split(" ");
		String[] s2 = sib2.split(" ");
		//[d , m , y]
		int[] s1i = {stoi(s1[0]) , map_month(s1[1]) , stoi(s1[2])};
		int[] s2i = {stoi(s2[0]) , map_month(s2[1]) , stoi(s2[2])};
		//System.out.println(s1i[0] + ","+s1i[1]+","+s1i[2]);
		//System.out.println(s2i[0] + ","+s2i[1]+","+s2i[2]);
		if(s1i[2] != s2i[2]) {
			//System.out.println("yeq");
			return true;
		}
		else {
			if(Math.abs(s1i[1]-s2i[1]) >= 8) {
				//System.out.println("m>8");
				return true;
			}
			else {
				if(s1i[1] == s2i[1]) {
					//System.out.println("meq");
					if(Math.abs(s1i[0]-s2i[0]) < 2) {
						//System.out.println("d<2");
						return true;
					}
					else {
						//System.out.println("del");
						return false;
					}
				}
				else {
					//System.out.println("mel");
					return false;
				}
			}
		}
	}
	
    public static int searchbyId(ArrayList<individual> people , String target) {
    	for(int x = 0 ; x < people.size() ; x++) {
    		if(target.equals(people.get(x).id)) {    		
    			return x;
    		}
    	}
    	
    	return -1;
    }
    
	public static int stoi(String input) {
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}
	
	public static int map_month(String target) {
		String[] month = {"" , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		for(int x = 0 ; x < month.length ; x++) {
			if(month[x].equals(target)) {
				return x;
			}
		}
		return -1;
	}

}
