package week1_Day1.ClassRoom;

import java.util.Arrays;

public class SecondLargestNum {

	
	public static void main(String[] args) {

		int[] num = { 5, 10, 15, 20, 25, 30 };

		Arrays.sort(num);

		int length = num.length;
		System.out.println(num[length-2]);

	}

}
