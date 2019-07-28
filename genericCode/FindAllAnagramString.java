package genericCode;

/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/
import java.util.HashMap;
import java.util.ArrayList;
public class FindAllAnagramString {
	
	ArrayList<Integer> finder(String s, String t) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(t.length()>s.length()) return result;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>(); //Map to keep count of each character in t
		
		for(char c : t.toCharArray()) 
		{
			map.put(c, map.getOrDefault(c, 0)+1); // Fill the map with the count of each character
		}
		
		int count =map.size(); // set the count based on t size
		int begin =0;
		int head = 0;
		int end = 0;
		int min = Integer.MAX_VALUE; //set the min value.
		
		while(end<s.length())  // scan each character one by one in s string
		{
			char temp = s.charAt(end);
			if(map.containsKey(temp))  // if character found in map then decrement the count
			{
				map.put(temp,map.get(temp)-1); 
				if(map.get(temp)==0) count--; // if the count become 0 for  particular character the decrease the count by 1
			}
			end++;
			
			while(count==0) // if count ==0 means we got all the character of t in s string.
			{
				char temp2 = s.charAt(begin); // Now we start from begin and remove character one by one 
				
				if(map.containsKey(temp2)) 
				{
					map.put(temp2,map.get(temp2)+1);
					if(map.get(temp2)>0) count++;
				}
				
				if(end-begin==t.length()) // if the size of resultant string length is equal to size of t then add it to the result.
				{
					min = end - begin; 
					head = begin;
					result.add(head);
				}
				begin++;	
			}
		}
		
		return result;
	
	}
	public static void main(String[] args) {
		FindAllAnagramString obj = new FindAllAnagramString();
		String S = "cbaebabacd";
		String T = "abc";
		System.out.print(obj.finder(S,T));
	}
}
