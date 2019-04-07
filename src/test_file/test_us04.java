package test_file;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sprint1.US04;

class test_us04 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
    public void test_dateCheck_true() {
        US04 us04 = new US04();

        ArrayList<String> marrDate = new ArrayList<>();
        marrDate.add("12 JAN 2000");
        marrDate.add("23 FEB 2001");
        marrDate.add("5 MAY 2002");
        marrDate.add("12 JUL 2016");


        ArrayList<String> divoDate  = new ArrayList<>();
        divoDate.add("23 NOV 2002");
        divoDate.add("14 DEC 2001");
        divoDate.add("8 MAY 2002");
        divoDate.add(""); // return true

        for(int i = 0; i< marrDate.size(); i++){
            boolean res = us04.dateCheck(marrDate.get(i), divoDate.get(i));
            assertTrue(res);
        }
    }

    @Test
    public void test_dateCheck_false() {
        US04 us04 = new US04();

        ArrayList<String> marrDate = new ArrayList<>();
        marrDate.add("12 JAN 2000");
        marrDate.add("23 FEB 2001");
        marrDate.add("5 MAY 2002");
        //marrDate.add("16 JUN 2020");

        ArrayList<String> divoDate  = new ArrayList<>();
        divoDate.add("23 NOV 1999");
        divoDate.add("14 JAB 2001");
        divoDate.add("1 MAY 2002");
        //divoDate.add("29 JUL 2018");

        for(int i = 0; i< marrDate.size(); i++){
            boolean res = us04.dateCheck(marrDate.get(i), divoDate.get(i));
            assertFalse(res);
        }
    }


    @Test
    public void test_dateCheck_ex() {
        US04 us04 = new US04();
        String marrDate = "";
        String divoDate = "JAN 10 2016";
        assertThrows(IllegalArgumentException.class,
        		() ->{us04.dateCheck(marrDate,divoDate);});
    }

}
