//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//The solution set must not contain duplicate triplets.
//
//Example:
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]



package genericCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	
	void finder(int[] arr) 
	{
		
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.parallelSort(arr);
		for(int i =0 ;i< arr.length-2;i++) 
		{
			int j = i+1;
			int k = arr.length-1;
			
			while(j<k) 
			{
				int sum = arr[i] + arr[k] + arr[j];
				
				if(sum==0) 
				{
					set.add(Arrays.asList(arr[i],arr[j++],arr[k--]));
				}
				else if(sum>0) k--;
				else if(sum<0) j++; 
			}
		}
		System.out.print(set);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeSum obj = new ThreeSum();
		int[] arr= {-1,0,1,2,-1,-4};
		obj.finder(arr);

	}

}
