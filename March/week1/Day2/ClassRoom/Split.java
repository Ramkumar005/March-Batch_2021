package week1_Day2.ClassRoom;

public class Split {

	public static void main(String[] args) {
		
			String name = "Tomorrow is a holiday";
		
		String[] nSplit = name.split(" ");
		for (int i = 0; i < nSplit.length; i++) {
			System.out.println(nSplit[i]);
		}

	}

}
