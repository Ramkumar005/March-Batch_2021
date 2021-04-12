package week3_Day2.Assignment;

import java.util.Arrays;

public class Sorting_Collections {

	public static void main(String[] args) {

		String[] input = { "HCL", "Wipro", "Aspire Systems", "CTS" };

		int length = input.length;
		System.out.println(length);
		System.out.println("********");

		Arrays.sort(input);
		
		for (int i = 0; i <= length-1; i++) {
			System.out.println(input[i]);
		}

	}

}
