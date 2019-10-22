package com.alsie.kataNumberToLcdTest;

import com.alsie.katanumbertolcd.NumberToLCD;
import java.lang.reflect.Field;
import static junit.framework.Assert.*;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestNumberToLCD.TestNumberToLCD_FOR_0_TO_9.class, 
    TestNumberToLCD.TestNumberToLCD_FOR_100_TO_900.class,
    TestNumberToLCD.TestNumberToLCD_YEARS.class,
    TestNumberToLCD.TestNumberToLCD_LEVEL.class})

public class TestNumberToLCD {

    public static class TestNumberToLCD_FOR_0_TO_9 {

        @Test
        public void TestNumberToLCD_FOR_0() throws Exception {
            assertEquals(" _ \n"
                    + "| |\n"
                    + "|_|", NumberToLCD.ToLCD(0));
        }

        @Test
        public void TestNumberToLCD_FOR_1() throws Exception {
            assertEquals("   \n"
                    + "  |\n"
                    + "  |", NumberToLCD.ToLCD(1));
        }

        @Test
        public void TestNumberToLCD_FOR_2() throws Exception {
            assertEquals(" _ \n"
                    + " _|\n"
                    + "|_ ", NumberToLCD.ToLCD(2));
        }

        @Test
        public void TestNumberToLCD_FOR_3() throws Exception {
            assertEquals(" _ \n"
                    + " _|\n"
                    + " _|", NumberToLCD.ToLCD(3));
        }

        @Test
        public void TestNumberToLCD_FOR_4() throws Exception {
            assertEquals("   \n"
                    + "|_|\n"
                    + "  |", NumberToLCD.ToLCD(4));
        }

        @Test
        public void TestNumberToLCD_FOR_5() throws Exception {
            assertEquals(" _ \n"
                    + "|_ \n"
                    + " _|", NumberToLCD.ToLCD(5));
        }

        @Test
        public void TestNumberToLCD_FOR_6() throws Exception {
            assertEquals(" _ \n"
                    + "|_ \n"
                    + "|_|", NumberToLCD.ToLCD(6));
        }

        @Test
        public void TestNumberToLCD_FOR_7() throws Exception {
            assertEquals(" _ \n"
                    + "  |\n"
                    + "  |", NumberToLCD.ToLCD(7));
        }

        @Test
        public void TestNumberToLCD_FOR_8() throws Exception {
            assertEquals(" _ \n"
                    + "|_|\n"
                    + "|_|", NumberToLCD.ToLCD(8));
        }

        @Test
        public void TestNumberToLCD_FOR_9() throws Exception {
            assertEquals(" _ \n"
                    + "|_|\n"
                    + " _|", NumberToLCD.ToLCD(9));
        }

        @Test
        public void TestNumberToLCD_FOR_10() throws Exception {
            assertEquals("    _ \n"
                    + "  || |\n"
                    + "  ||_|", NumberToLCD.ToLCD(10));
        }

    }

    public static class TestNumberToLCD_FOR_100_TO_900 {

        @Test
        public void TestNumberToLCD_FOR_100() throws Exception {
            assertEquals("    _  _ \n"
                    + "  || || |\n"
                    + "  ||_||_|", NumberToLCD.ToLCD(100));
        }

        @Test
        public void TestNumberToLCD_FOR_200() throws Exception {
            assertEquals(" _  _  _ \n"
                    + " _|| || |\n"
                    + "|_ |_||_|", NumberToLCD.ToLCD(200));
        }

        @Test
        public void TestNumberToLCD_FOR_300() throws Exception {
            assertEquals(" _  _  _ \n"
                    + " _|| || |\n"
                    + " _||_||_|", NumberToLCD.ToLCD(300));
        }

        @Test
        public void TestNumberToLCD_FOR_400() throws Exception {
            assertEquals("    _  _ \n"
                    + "|_|| || |\n"
                    + "  ||_||_|", NumberToLCD.ToLCD(400));
        }

        @Test
        public void TestNumberToLCD_FOR_500() throws Exception {
            assertEquals(" _  _  _ \n"
                    + "|_ | || |\n"
                    + " _||_||_|", NumberToLCD.ToLCD(500));
        }

        @Test
        public void TestNumberToLCD_FOR_600() throws Exception {
            assertEquals(" _  _  _ \n"
                    + "|_ | || |\n"
                    + "|_||_||_|", NumberToLCD.ToLCD(600));
        }

        @Test
        public void TestNumberToLCD_FOR_700() throws Exception {
            assertEquals(" _  _  _ \n"
                    + "  || || |\n"
                    + "  ||_||_|", NumberToLCD.ToLCD(700));
        }

        @Test
        public void TestNumberToLCD_FOR_800() throws Exception {
            assertEquals(" _  _  _ \n"
                    + "|_|| || |\n"
                    + "|_||_||_|", NumberToLCD.ToLCD(800));
        }

        @Test
        public void TestNumberToLCD_FOR_900() throws Exception {
            assertEquals(" _  _  _ \n"
                    + "|_|| || |\n"
                    + " _||_||_|", NumberToLCD.ToLCD(900));
        }
    }
     public static class TestNumberToLCD_YEARS {

        @Test
        public void TestNumberToLCD_FOR_1977() throws Exception {
assertEquals("    _  _  _ \n"
           + "  ||_|  |  |\n"
           + "  | _|  |  |", NumberToLCD.ToLCD(1977));		
            }
                }
     
          public static class TestNumberToLCD_LEVEL {

        @Test
        public void TestNumberToLCD_FOR_LEVEL_2_2() throws Exception {
     assertEquals(" __ \n"
           + "   |\n"
           + " __|\n"
           + "|   \n"
           + "|__ ", NumberToLCD.ToLCD(2,2));		
            }
                }
        @Test
        public void TestNumberToLCD_FOR_LEVEL_2_1() throws Exception {
            assertEquals(" _ \n"
                    + " _|\n"
                    + "|_ ", NumberToLCD.ToLCD(2,1));
        }

}
