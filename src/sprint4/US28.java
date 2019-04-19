package sprint4;

import java.util.ArrayList;
import java.util.HashMap;

import fam.Family;
import indi.individual;
import sprint1.US02;

public class US28 {
	public static void Order_siblings(ArrayList<individual> individuals,ArrayList<Family> families) {
		HashMap<String,Integer> index = new HashMap<String,Integer>();
		for(int i=0;i<individuals.size();i++) {
			index.put(individuals.get(i).id,i);
		}
		
		for(Family fam:families) {
			System.out.println("Info(US28): family "+fam.familyID);
			ArrayList<String> order = order(individuals,fam,index);
			for(String s:order) {
				System.out.print("Info(US28): ");
				System.out.print("child: "+s);
				System.out.print("birthdate: "+individuals.get(index.get(s)).Birthday);
				System.out.println();
			}
		}
	}
	
	public static ArrayList<String> order(ArrayList<individual> individuals,Family fam,HashMap<String,Integer> index){
		ArrayList<String> order = new ArrayList<String>();
		for(String child:fam.children) {
			
			if(order.size()==0) {
				order.add(child);
				continue;
			}
			for(int i=0;i<order.size();i++) {
				int i1=index.get(child),
					i2=index.get(order.get(i));
				String birdate1=individuals.get(i1).Birthday,
					   birdate2=individuals.get(i2).Birthday;
				if(elder(birdate1,birdate2)) {
					order.add(i, child);
					break;
				}
				if(i==order.size()-1) {
					order.add(child);
				}
			}
			
		}
		return order;
	}
	public static boolean elder(String birthdate1,String birthdate2) {
		return US02.birth_before_marriage(birthdate1, birthdate2);
	}
}
