/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alsie.katanumbertolcd;
import java.util.*;
/**
 *
 * @author osboxes
 */



public class NumberToLCD {

	private static final String _NONE = "   ";
        private static final String _NONE2 = "      ";
	private static final String _LEFT = "  |";
        private static final String _LEFT2 = "   |";
	private static final String _MIDL = " _ ";
        private static final String _MIDL2 = " __ ";
	private static final String _MDLT = " _|";
        private static final String _MDLT2 = " __|";
	private static final String _MDRT = "|_ ";
        private static final String _MDRT2 = "|__ ";
	private static final String _FULL = "|_|";
        private static final String _FULL2 = "|__|";
	private static final String _BOTH = "| |";
        private static final String _BOTH2 = "|  |";
        private static final String _ONLYLEFT = "|   ";

	private static final Map<Integer, String[]> _SEGMENTS_FOR = new HashMap<Integer, String[]>() {
		{
			put(new Integer(1), new String[] { _NONE, _LEFT, _LEFT });
			put(new Integer(2), new String[] { _MIDL, _MDLT, _MDRT });
			put(new Integer(3), new String[] { _MIDL, _MDLT, _MDLT });
			put(new Integer(4), new String[] { _NONE, _FULL, _LEFT });
			put(new Integer(5), new String[] { _MIDL, _MDRT, _MDLT });
			put(new Integer(6), new String[] { _MIDL, _MDRT, _FULL });
			put(new Integer(7), new String[] { _MIDL, _LEFT, _LEFT });
			put(new Integer(8), new String[] { _MIDL, _FULL, _FULL });
			put(new Integer(9), new String[] { _MIDL, _FULL, _MDLT });
			put(new Integer(0), new String[] { _MIDL, _BOTH, _FULL });
		}
	};
        //  1234
        //1   __          __     __          __    __    __    __   __ 
	//2  |  |    |      |      |  |  |  |     |        |  |  | |  |
	//3  |  |    |    __|    __|  |__|  |__   |__      |  |__| |__|
	//4  |  |    |   |         |     |     |  |  |     |  |  |    |
	//5  |__|    |   |__     __|     |   __|  |__|     |  |__|  __|
        	private static final Map<Integer, String[]> _SEGMENTS_FOR_2 = new HashMap<Integer, String[]>() {
		{
			put(new Integer(1), new String[] { _NONE2, _LEFT2, _LEFT2, _LEFT2, _LEFT2 });
			put(new Integer(2), new String[] { _MIDL2,_LEFT2, _MDLT2,_ONLYLEFT, _MDRT2 });
			put(new Integer(3), new String[] { _MIDL2, _LEFT2,_MDLT2, _LEFT2,_MDLT2 });
			put(new Integer(4), new String[] { _NONE2,_BOTH2, _FULL2, _LEFT2 , _LEFT2});
			put(new Integer(5), new String[] { _MIDL2, _ONLYLEFT,_MDRT2, _LEFT2,_MDLT2 });
			put(new Integer(6), new String[] { _MIDL2,_ONLYLEFT, _MDRT2, _BOTH2,_FULL2 });
			put(new Integer(7), new String[] { _MIDL2, _LEFT2, _LEFT2 ,_LEFT2, _LEFT2 });
			put(new Integer(8), new String[] { _MIDL2, _BOTH2,_FULL2, _BOTH2,_FULL2 });
			put(new Integer(9), new String[] { _MIDL2,_BOTH2, _FULL2,_LEFT2 ,_MDLT2 });
			put(new Integer(0), new String[] { _MIDL2,_BOTH2, _BOTH2, _BOTH2,_FULL2 });
		}
                };
                private static final Map<String, String[]> _SEGMENTS_FOR_LEVEL = new HashMap<String, String[]>() {
		{       //LEVEL 1
			put("1-1", new String[] { _NONE, _LEFT, _LEFT });
			put("2-1", new String[] { _MIDL, _MDLT, _MDRT });
			put("3-1", new String[] { _MIDL, _MDLT, _MDLT });
			put("4-1", new String[] { _NONE, _FULL, _LEFT });
			put("5-1", new String[] { _MIDL, _MDRT, _MDLT });
			put("6-1", new String[] { _MIDL, _MDRT, _FULL });
			put("7-1", new String[] { _MIDL, _LEFT, _LEFT });
			put("8-1", new String[] { _MIDL, _FULL, _FULL });
			put("9-1", new String[] { _MIDL, _FULL, _MDLT });
			put("0-1", new String[] { _MIDL, _BOTH, _FULL });
                        //LEVEL 2
			put("1-2", new String[] { _NONE2, _LEFT2, _LEFT2, _LEFT2, _LEFT2 });
			put("2-2", new String[] { _MIDL2,_LEFT2, _MDLT2,_ONLYLEFT, _MDRT2 });
			put("3-2", new String[] { _MIDL2, _LEFT2,_MDLT2, _LEFT2,_MDLT2 });
			put("4-2", new String[] { _NONE2,_BOTH2, _FULL2, _LEFT2 , _LEFT2});
			put("5-2", new String[] { _MIDL2, _ONLYLEFT,_MDRT2, _LEFT2,_MDLT2 });
			put("6-2", new String[] { _MIDL2,_ONLYLEFT, _MDRT2, _BOTH2,_FULL2 });
			put("7-2", new String[] { _MIDL2, _LEFT2, _LEFT2 ,_LEFT2, _LEFT2 });
			put("8-2", new String[] { _MIDL2, _BOTH2,_FULL2, _BOTH2,_FULL2 });
			put("9-2", new String[] { _MIDL2,_BOTH2, _FULL2,_LEFT2 ,_MDLT2 });
			put("0-2", new String[] { _MIDL2,_BOTH2, _BOTH2, _BOTH2,_FULL2 });
		}
	};


        
	public static String ToLCD(int number) {
		String[][] segments = getSegmentsForEachDigit(number);
		String[] result = Utils.arrangeHorizontally(segments);
		return toTextLines(result);
	}
        public static String ToLCD(int number,int level) {
		String[][] segments = getSegmentsForEachDigit(number,level);
		String[] result = Utils.arrangeHorizontally(segments);
		return toTextLines(result);
	}

	private static String toTextLines(String[] result) {
		return Utils.join(result, '\n');
	}

	private static String[][] getSegmentsForEachDigit(int number) {
		String digits = Integer.toString(number);
		String[][] result = new String[digits.length()][];
		for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
			result[digitIndex] = segmentsFor(digitAt(digits, digitIndex));
		}
		return result;
	}
        private static String[][] getSegmentsForEachDigit(int number,int level) {
		String digits = Integer.toString(number);
		String[][] result = new String[digits.length()][];
		for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
			result[digitIndex] = segmentsFor(digitAt(digits, digitIndex),level);
		}
		return result;
	}

	private static int digitAt(String digits, int i) {
		return Integer.parseInt(Character.toString(digits.charAt(i)));
	}

	private static String[] segmentsFor(int number) {
		String result[] = _SEGMENTS_FOR.get(new Integer(number));
		if (null == result)
			throw new RuntimeException(String.format("Dígito %d no encontrado",
					number));
		return result;
	}
        private static String[] segmentsFor(int number,int level) {
		String result[] = _SEGMENTS_FOR_LEVEL.get(number+"-"+level);
		if (null == result)
			throw new RuntimeException(String.format("Dígito %d no encontrado",
					number));
		return result;
	}
}

class Utils {
	public static String join(String[] strings, char delim) {
		StringBuffer sb = new StringBuffer();
		for (String string : strings) {
			if (sb.length() > 0)
				sb.append(delim);
			sb.append(string);
		}
		return sb.toString();
	}

	public static String[] arrangeHorizontally(String[][] data) {
		assert data.length > 0;

		String[] result = data[0].clone();
		for (int row = 1; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++)
				result[col] += data[row][col];
		}
		return result;
	}
}