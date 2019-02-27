package test_file;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mainprogram.*;
import datecheck.checkdate_US01;
import fam.Family;
import indi.individual;

class test_us01 {
	public static ArrayList<individual> allPeople = null;
	public static ArrayList<Family> allFamilies = null;
	public static output_format in = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		in = Main.main_output();
		allPeople = in.People;
		allFamilies = in.Families;
        System.out.println("individual");
        System.out.println("age|Birt|Dith|id|isdead|name|sex|spouse|children");
        for(int i = 0 ; i < allPeople.size() ; i++) {   
            System.out.print(allPeople.get(i).age + " | ");
            System.out.print(allPeople.get(i).Birthday + " | "); 
            System.out.print(allPeople.get(i).Deathday + " | ");
            System.out.print(allPeople.get(i).id + " | ");
            System.out.print(allPeople.get(i).isdead +" | ");
            System.out.print(allPeople.get(i).name +" | ");
            System.out.print(allPeople.get(i).sex +" | ");
            System.out.print(allPeople.get(i).spouse +" | ");
            System.out.print(allPeople.get(i).children);
            System.out.println(" ");
            }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException {
		System.out.println("Date today");
		String[] nowarr = LocalDate.now().toString().split("-");
		nowarr[1] = mapmonth(nowarr[1]);
		System.out.println(nowarr[2] + " " + nowarr[1] + " " + nowarr[0]);
		for(int x = 0 ; x < allPeople.size() ; x++) {
			System.out.println(x);
			Assertions.assertTrue(checkdate_US01.checkdate_us01(allPeople.get(x).Birthday));
		}
	}
	private String mapmonth(String string) {
		String[] month = {" " , "JAN" , "FEB" , "MAR" , "APR" , "MAY" , "JUN" , "JUL" , "AUG" , "SEP" , "OCT" , "NOV" , "DEC"};
		int a = checkdate_US01.stoi(string);
		return month[a];
	}

}
