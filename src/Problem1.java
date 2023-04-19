import java.util.HashMap;
import java.util.Map;

public class Problem1 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> charFreq = new HashMap<>();
		int left=0;
		int max=0;
		// initialize the maximum length to 0
		for(int right=0; right < s.length(); right++)
			// move the right pointer of the window from left to right
		{
			charFreq.put(s.charAt(right), charFreq.getOrDefault(s.charAt(right), 0) + 1);
			while(charFreq.size() > 2)
			// while the size of the hashmap is greater than 2, move the left pointer and remove characters from the hashmap
			{
				int l = charFreq.getOrDefault(s.charAt(left), 0);
				if(l < 2) charFreq.remove(s.charAt(left));
				else  charFreq.put(s.charAt(left), charFreq.getOrDefault(s.charAt(left), 0) - 1);
				left++;
				// move the left pointer one position to the right
			}
			max=Math.max(max, right - left + 1);

		}
		return max;

	}

}
