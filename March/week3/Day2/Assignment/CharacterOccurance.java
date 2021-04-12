package week3_Day2.Assignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOccurance {

	public static void main(String[] args) {

		String str = "welcome to Selenium automation";
		char[] charArray = str.toCharArray();

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (char ch : charArray) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);

			} else {
				map.put(ch, 1);
			}

		}
		System.out.println(map);

	}

}
