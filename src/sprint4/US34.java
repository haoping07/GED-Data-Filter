package sprint4;

import java.util.ArrayList;
import java.util.HashMap;

import fam.Family;
import indi.individual;

public class US34 {
	public static ArrayList<Boolean> large_differences(ArrayList<individual> individuals,ArrayList<Family> families) {
		ArrayList<Boolean> result=new ArrayList<Boolean>();
		HashMap<String,Integer> index = new HashMap<String,Integer>();
		for(int i=0;i<individuals.size();i++) {
			index.put(individuals.get(i).id,i);
		}
		for(Family fam:families) {
			int hus=individuals.get(index.get(fam.husband)).age;
			int wif=individuals.get(index.get(fam.wife)).age;
			if(hus<=0||wif<=0) {continue;}
			if(compare(hus,wif)) { System.out.println("Info(US34): "+fam.familyID+" the older spouse was more than twice as old as the younger spouse");}
		}
		return result;
	}
	
	public static boolean compare(int a,int b) {
		int a2=a*2,b2=b*2;
		return (b>=a2||a>=b2);
	}
}
