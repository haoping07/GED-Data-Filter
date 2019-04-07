package sprint3;

import java.util.ArrayList;
import java.util.Arrays;

import fam.Family;
import indi.individual;

public class US22 {
	public static ArrayList<Boolean> UniqueId(ArrayList<individual> individuals,ArrayList<Family> families) {
		String[] indis=new String[individuals.size()], fams=new String[families.size()];
		ArrayList<Boolean> result=new ArrayList<Boolean>();
		for(int i=0;i<individuals.size();i++) {
			indis[i]=individuals.get(i).id;
		}
		Arrays.sort(indis);
		for(int i=0;i<indis.length;i++) {
			if(i==0 && indis[0].equals(indis[indis.length-1])) {
				result.add(false);
				//find duplicate indi id
				System.out.println("Error message(US22): find duplicate individual id "+indis[i]);
				System.out.println("Debug message(US22): "+indis[i]+" "+indis[indis.length-1]);
				
			}
			if(i>0&&indis[i].equals(indis[i-1])) {
				result.add(false);
				//find duplicate indi id
				System.out.println("Error message(US22): find duplicate individual id "+indis[i]);
				System.out.println("Debug message(US22): "+indis[i]+" "+indis[i-1]);
			}
			else {
				result.add(true);
			}
		}
		for(int i=0;i<families.size();i++) {
			fams[i]=families.get(i).familyID;
		}
		Arrays.sort(fams);
		for(int i=0;i<fams.length;i++) {
			if(i==0 && fams[0].equals(fams[fams.length-1])) {
				result.add(false);
				//find duplicate fam id
				System.out.println("Error message(US22): find duplicate individual id "+fams[i]);
				System.out.println("Debug message(US22): "+fams[i]+" "+fams[fams.length-1]);
			}
			if(i>0&&fams[i].equals(fams[i-1])) {
				result.add(false);
				System.out.println("Error message(US22): find duplicate family id: "+fams[i]);
				System.out.println("Debug message(US22): "+fams[i]+" "+fams[i-1]);
				//find duplicate fam id
			}
			else {
				result.add(true);
			}
		}
		return result;
	}
}
