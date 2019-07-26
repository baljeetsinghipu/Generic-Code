package genericCode;

/*

76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

*/

import java.util.HashMap;
public class MinimumWindowSubstring {
	
	String finder(String s, String t) 
	{
		if(t.length()>s.length()) return "";
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
				
				if(end-begin<min) // if the length is less than the min length we found so far.
				{
					min = end - begin; 
					head = begin;
				}
				begin++;	
			}
		}
		
		if(min == Integer.MAX_VALUE) return "";
		else return s.substring(head,head+min);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring obj = new MinimumWindowSubstring();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.print(obj.finder(S,T));
	}
}
