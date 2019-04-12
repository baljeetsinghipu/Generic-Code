package genericCode;

/*

3. Longest Substring Without Repeating Characters.

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
import java.util.HashMap;
import java.util.ArrayList;
public class LongestSubstringWithoutRepeatingCharacter {
	
	int finder(String s) 
	{
		if(s.length()==0) return -1;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count =0;
		int begin = 0;
		int end = 0;
		int result = 0;
		while(end<s.length())
		{
			char c = s.charAt(end);
			map.put(c,map.getOrDefault(c, 0)+1);
			if(map.get(c)>1) count++;
			end++;
			while(count>0) 
			{
				char d = s.charAt(begin);
				if(map.get(d)>1) 
				{
					map.put(d,map.getOrDefault(d, 0)-1);
					if(map.get(d)<2) count--;
				}
				begin++;
			}
			
			result = Math.max(result,end-begin);
		}
		
		return result;
	
	}
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacter obj = new LongestSubstringWithoutRepeatingCharacter();
		String S = "abcabcdgbb";
		System.out.print(obj.finder(S));
	}
}
