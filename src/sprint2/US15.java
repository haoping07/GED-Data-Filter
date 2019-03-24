//Author: Song Xu

package sprint2;

import java.util.ArrayList;

import fam.Family;

public class US15 {
	public static void sibilings(ArrayList<Family> families) {
		for(Family fam:families) {
			if(!sibilings(fam)) {
				System.out.println("Error(US15): " + "More than 15 siblings in Family" +
						fam.familyID);
			}
		}
	}
	
	public static boolean sibilings(Family fam){
		if(fam.children.size()<15) {
			return true;
		}
		return false;
	}
}
