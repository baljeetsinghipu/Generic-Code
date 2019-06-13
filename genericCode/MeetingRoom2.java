//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//Example 1:
//
//Input: [[0, 30],[5, 10],[15, 20]]
//Output: 2


package genericCode;

import java.util.Arrays;

public class MeetingRoom2 {
	
	int finder(int[][] nums) 
	{
		int[] start = new int[nums.length];
		int[] end = new int[nums.length];
		
		for(int i =0;i<nums.length;i++) 
		{
			start[i] = nums[i][0];
			end[i] = nums[i][1];
		}
		
		Arrays.parallelSort(start); // sorting using Arrays Parallel method.
		Arrays.parallelSort(end);
		
		int k =1;
		int count =0;
		for(int i =1;i<start.length;i++) 
		{
			if(start[i]<end[k]) count++;
			else k++;
			
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MeetingRoom2 obj = new MeetingRoom2();
		
		int[][] arr = {{0, 30},{5, 10},{15, 20}};
		int result = obj.finder(arr);
		System.out.print(result);

	}

}
