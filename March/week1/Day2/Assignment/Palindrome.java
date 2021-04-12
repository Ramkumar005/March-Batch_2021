package week1_Day2.Assignment;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your input");
		String str = scan.nextLine();
		String rev = "";
		char[] palArray = str.toCharArray();
		
		for (int i = palArray.length-1; i >=0; i--) {
			rev = rev+palArray[i]+"";
			
			//System.out.println(rev);
		}
		
		if(rev.equals(str)) {
			System.out.println("given string is a palindrome");
		}
		else {
			System.out.println("given string is not a palindrome");
		}
	}
}
