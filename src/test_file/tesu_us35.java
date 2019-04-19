package test_file;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import indi.individual;
import sprint4.us35;

class tesu_us35 {
	public static String[] months = {"" , "JAN" , "FEB" , "MAR" , "APR" , "MAR" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
	public static individual p1;
	public static individual p2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		LocalDate localDate = LocalDate.now();
		String now = localDate.toString();
		String[] nowarr = now.split("-");
		int mon = stoi(nowarr[1]);
		int yer = stoi(nowarr[0]);
		int day = stoi(nowarr[2])-30;
		if(day <= 0) {
			mon -= 1;
			day += 30;
		}
		String newbirt = Integer.toString(day) + " " +months[mon] + " " + Integer.toString(yer);
		String newbirt2 = Integer.toString(day-1) + " " +months[mon] + " " + Integer.toString(yer);
		//p1: born 30 days before recent date
		p1 = new individual("p1");
		p1.update("BIRT", newbirt);
		//p2: born 31 days before recent date
		p2 = new individual("p2");
		p1.update("BIRT", newbirt2);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Assertions.assertTrue(us35.recent(p1.Birthday));
	}
	
	@Test
	void test2() {
		Assertions.assertFalse(us35.recent(p2.Birthday));
	}
	
	public static int stoi(String input) {
		int out = 0;
		for(int x = 0 ; x < input.length() ; x++) {
			out = (out*10)+((int)input.charAt(x)-48);
		}
		return out;
	}
}
