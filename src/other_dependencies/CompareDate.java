package other_dependencies;

import java.util.HashMap;

public class CompareDate {
	public Boolean CheckDate(String date1, String date2) {
		if (date1 == "" || date2 == "")
			return false;
		
		String[] date1SplitStr = date1.split(" ");
		String[] date2SplitStr = date2.split(" ");

		HashMap<String, Integer> monthmap = new HashMap<String, Integer>();

		monthmap.put("JAN", 1);
		monthmap.put("FEB", 2);
		monthmap.put("MAR", 3);
		monthmap.put("APR", 4);
		monthmap.put("MAY", 5);
		monthmap.put("JUN", 6);
		monthmap.put("JUL", 7);
		monthmap.put("AUG", 8);
		monthmap.put("SEP", 9);
		monthmap.put("OCT", 10);
		monthmap.put("NOV", 11);
		monthmap.put("DEC", 12);

		if (Integer.parseInt(date1SplitStr[2]) > Integer.parseInt(date2SplitStr[2]))
			return false;
		if (Integer.parseInt(date1SplitStr[2]) < Integer.parseInt(date2SplitStr[2]))
			return true;
		if (Integer.parseInt(date1SplitStr[2]) == Integer.parseInt(date2SplitStr[2])) {
			if (monthmap.get(date1SplitStr[1]) > monthmap.get(date2SplitStr[1]))
				return false;
			if (monthmap.get(date1SplitStr[1]) < monthmap.get(date2SplitStr[1]))
				return true;
			if (monthmap.get(date1SplitStr[1]) == monthmap.get(date2SplitStr[1])) {
				if (Integer.parseInt(date1SplitStr[0]) > Integer.parseInt(date2SplitStr[0]))
					return false;
				if (Integer.parseInt(date1SplitStr[0]) < Integer.parseInt(date2SplitStr[0]))
					return true;
				if (Integer.parseInt(date1SplitStr[0]) == Integer.parseInt(date2SplitStr[0]))
					return true;
			}
		}
		return false;
	}
}
