package genericCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Reorganize_String {
	
	String finder(String str) 
	{
		char[] arr = str.toCharArray();
		Arrays.parallelSort(arr);
		int i = 0;
		int j = 0;
		while(i<arr.length) 
		{
			if(i==j) j++;
			else if(arr[j]==arr[i]) 
			{
				while(arr[j]==arr[i]) j++;
				char temp = arr[j];
				arr[j]=arr[i];
				arr[i] = temp;
				j=i;
			}
			else if(arr[i]!=arr[j]) i=j;
		}
		
		
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reorganize_String obj  = new Reorganize_String();
		String str = "aab";
		System.out.print(obj.finder(str));

	}

}
