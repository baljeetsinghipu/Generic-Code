//Given a collection of intervals, merge all overlapping intervals.
//
//Example 1:
//
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].


package genericCode;

import java.util.ArrayList;
import java.util.*;

public class MergeInterval {
	
	int[][] finder(int[][] nums) 
	{
		if(nums.length==0 || nums[0].length==0) return new int[1][];
		ArrayList<int[]> result = new ArrayList<int[]>();
		
		Arrays.parallelSort(nums,(p1,p2)->(p1[0]-p2[0]));

		int[] temp = nums[0];
		result.add(temp);
		
		for(int i=0;i<nums.length;i++) 
		{
			if(nums[i][0] <=temp[1]) 
			{
				temp[1] = Math.max(nums[i][1], temp[1]);
			}
			else 
			{
				temp = nums[i];
				result.add(temp);
			}
		}
		
//		System.out.print(Arrays.deepToString(nums) );
		
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MergeInterval obj = new MergeInterval();
		
		int[][] arr = {{1,3},{8,10}, {2,6},{15,18}};
		int[][] result = obj.finder(arr);
		
		System.out.print(Arrays.deepToString(result));

	}

}
