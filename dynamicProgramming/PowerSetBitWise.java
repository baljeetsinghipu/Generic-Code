package dynamicProgramming;

import java.util.*;

public class PowerSetBitWise {
	
	static ArrayList<ArrayList<Integer>> powerSet(int[] nums)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		int total = 1<<nums.length;
		for(int i=0;i<total;i++)
		{
			ArrayList<Integer> set = new ArrayList<Integer>();
			for(int j=0;j<nums.length;j++)
			{
				if(((1<<j)& i)!=0)
				{
					set.add(nums[j]);
				}
			}
//			System.out.println(set);
			result.add(set);
			
		}
		
		return result;
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4,5};
		ArrayList<ArrayList<Integer>> result = powerSet(nums);
		
		for(ArrayList<Integer> r :result)
		{
			System.out.print(r);
		}
		
		
		

	}

}
