package week1_Day1.ClassRoom;

public class Duplicates_Number {

	public static void main(String[] args) {

		int[] arr = { 10, 11, 12, 14, 17, 12, 15, 11 };
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

			for (int j = i+1 ; j < arr.length; j++) {

				if (arr[i] == arr[j]) {

					count = count + 1;
				}
			}
			if (count>0) {
				System.out.println(arr[i]);
				
			}
		}

	}

}
