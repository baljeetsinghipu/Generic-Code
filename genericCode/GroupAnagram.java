package genericCode;

import java.util.*;

public class GroupAnagram {
	HashMap<String,List> map  = new HashMap<String,List>(); //HashMap mapping String to List of String which will have our result
	List<List<String>> anagram(String[] input) 
	{
		
		for(String str: input) 
		{
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			if(map.containsKey(String.valueOf(temp)))
			{
				map.get(String.valueOf(temp)).add(str);
			}
			else 
			{
				map.put(String.valueOf(temp),new ArrayList());
				map.get(String.valueOf(temp)).add(str);
				
			}
			
		}
		
		return new ArrayList(map.values()); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagram obj = new GroupAnagram();
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = obj.anagram(input);
		
		for(List<String> str: result) 
		{
			for(String substr: str) 
			{
				System.out.print(substr);
				System.out.print(",");
			}
			
			System.out.println();
		}
	}

}
