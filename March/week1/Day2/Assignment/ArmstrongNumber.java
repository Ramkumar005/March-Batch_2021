package week1_Day2.Assignment;

public class ArmstrongNumber {

	public static void main(String[] args) {

		int input = 153;
		int originalNum = input;
		int sum = 0;

		while (input > 0) {
			int rem = input % 10;
			System.out.println(rem);
			
			int eachDigitCube = (rem * rem * rem);
			System.out.println(eachDigitCube);
			
			sum = sum + eachDigitCube;
			System.out.println(sum);
			
			input = input / 10;
			System.out.println(input);
			
			System.out.println("************");
			
		}
		if (sum == originalNum) {
			System.out.println("The number Is an Armstrong Number");

		} else {
			System.out.println("The number Is not an Armstrong Number");
		}

	}

}
