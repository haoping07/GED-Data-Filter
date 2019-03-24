package sprint2;

import java.util.ArrayList;

import fam.Family;
import indi.individual;

public class US09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public US09() {
		
	}
	
	public void Birth_before_death_of_parents(ArrayList<individual> people , ArrayList<Family> families) {
		individual person = null;
		Family thisfamily = null;
		individual father = null;
		individual mother = null;
		
		for(int x = 0 ; x < people.size() ; x++) {
			person = people.get(x);
			if(person.children.size() == 0) continue;
			thisfamily = get_family_by_id(families , person.children.get(0));
			if(thisfamily == null) {
				System.out.println("Debug messages(US09)[WARNING]: No parent family is found for person " + person.id);
				continue;
			}
			else{
				father = get_person_by_id(people , thisfamily.husband);
				if(father == null) {
					System.out.println("Debug messages(US09)[WARNING]: No father is found for person " + person.id);
					continue;
				}
				else {
					mother = get_person_by_id(people , thisfamily.wife);
					if(mother == null) {
						System.out.println("Debug messages(US09)[WARNING]: No mother is found for person " + person.id);
						continue;
					}
					else {
						if(father.isdead) {
							if(!checkfather(person.Birthday , father.Deathday)) {
								System.out.println("Debug messages(US09) [**ILLEGAL**]: birth 9 months after death of father ::" + person.id);
							}
						}
						if(mother.isdead) {
							if(!checkmother(person.Birthday , mother.Deathday)) {
								System.out.println("Debug messages(US09) [**ILLEGAL**]: birth after death of mother ::" + person.id);
							}
						}

					}
				}
			}
		}
	}


	public static boolean checkfather(String child, String father) {
		// TODO Auto-generated method stub
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		String[] childarr = child.split(" ");
		String[] fatherarr = father.split(" ");
		int childmonth = inarridx(month , childarr[1]);
		int fathermonth = inarridx(month , fatherarr[1]);
		int childyear = stoi(childarr[2]);
		int fatheryear = stoi(fatherarr[2]);
		int childday = stoi(childarr[0]);
		int fatherday = stoi(fatherarr[0]);
		
		if(fathermonth + 9 <= 12) {
			if(childyear > fatheryear) {
				return false;
			}
			else if(childyear == fatheryear) {
				if(childmonth > fathermonth+9) {
					return false;
				}
				else if(childmonth == fathermonth+9) {
					if(childday <= fatherday) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return true;
				}
			}
			else {
				return true;
			}
		}
		else{
			if(childyear > fatheryear+1) {
				return false;
			}
			else if(childyear == fatheryear+1) {
				if(childmonth > fathermonth+9-12) {
					return false;
				}
				else if(childmonth == fathermonth+9-12) {
					if(childday > fatherday) {
						return false;
					}
					else {
						return true;
					}
				}
				else {
					return true;
				}
			}
			else {
				return true;
			}
		}
		
	}
	
	public static boolean checkmother(String child, String mother) {
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		String[] childarr = child.split(" ");
		String[] motherarr = mother.split(" ");
		int childmonth = inarridx(month , childarr[1]);
		int mothermonth = inarridx(month , motherarr[1]);
		int childyear = stoi(childarr[2]);
		int motheryear = stoi(motherarr[2]);
		int childday = stoi(childarr[0]);
		int motherday = stoi(motherarr[0]);
		
		if(childyear > motheryear) {
			return false;
		}
		else if(childyear == motheryear) {
			if(childmonth > mothermonth) {
				return false;
			}
			else if(childmonth == mothermonth) {
				if(childday > motherday) {
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return true;
			}
		}
		else {
			return true;
		}
	}
	
	public static int stoi(String input) {
		// should check the ASCII number ranging from ("0" to "9");
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}
	public static int inarridx(String[] arr , String value) {
		for(int x = 0 ; x < arr.length ; x++) {
			if(arr[x].equals(value)) return x;
		}
		return -1;
	}
	
	public Family get_family_by_id(ArrayList<Family> families , String target) {
		for(int x = 0 ; x < families.size() ; x++) {
			if(families.get(x).familyID.equals(target)) {
				return families.get(x);
			}
		}
		return null;
	}
	
	public individual get_person_by_id(ArrayList<individual> people , String target) {
		for(int x = 0 ; x < people.size() ; x++) {
			if(people.get(x).id.equals(target)) {
				return people.get(x);
			}
		}
		return null;
	}
}
