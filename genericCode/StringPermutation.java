package genericCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StringPermutation {
	
	String[] finder(String string)
	{
		ArrayList<String> list = new ArrayList<String>(); // Storage for resultant list
		HashMap<Character,Integer> map = new HashMap<Character,Integer>(); // Map for counting number of occurrences of each character
		
		for(int i=0; i<string.length();i++)  // Calculating number of occurrence and store it in a map
		{
			map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0)+1 );
		}
		
		char[] character = new char[map.size()]; //create array to store unique character
		int[] count = new int[map.size()]; // create array to store count of character correspond to character array.
		int l = 0;
		int k = 0;
		char[] result = new char[string.length()]; //store each permutation string
		for(char i : map.keySet())  // fill character and count array from map
		{
			character[l] = i;
			count[l] = map.get(i);
			l++;
		}
		
		helper(character,count,list,result,0); // call recursive helper function
		
		return list.toArray(new String[list.size()]) ; // convert list to array of string
		
	}
	
	void helper(char[] character, int[] count, ArrayList list, char[] result , int level) 
	{
		
		if(level == result.length) // if we get desired permutation string which is having length equal to original length, we will save it into list 
		{
			list.add(new String(result));
			return;
		}
		
		for(int i =0;i< character.length;i++)  // iterate character and count array for each recursive call
		{
			if(count[i]==0) continue;
			else 
			{
				count[i]--; // decrease the count because we will save this character into our result array
				result[level] = character[i]; // save character into result array
				helper(character, count, list,result , level+1); // call recursively for the rest of string;
				count[i]++; 
				
			}
		}
	}

	public static void main(String[] args) {
	
		StringPermutation obj = new StringPermutation();
		String str = "AABC"; // input string
		String[] result = obj.finder(str);
		System.out.print(Arrays.toString(result));

	}

}
