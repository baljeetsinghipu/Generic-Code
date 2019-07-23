package genericCode;

import java.util.Arrays;
import java.util.HashMap;

public class NextPermutation {
	
	void finder(int[] nums)
	{
		int save_index = -1; // holder for higher element in decreasing order
		int save_index2 = -1; // holder for next big element than save_index in right subarray
		
		int min = Integer.MAX_VALUE;
		for(int i = nums.length-1 ; i>0 ; i-- ) // finding first decreasing element from right
		{
			if(nums[i]>nums[i-1]) 
			{
				save_index = i-1;
				break;
			}
		}
		if(save_index ==-1) return;
		
		System.out.print(save_index);
		for(int j = nums.length-1 ; j>save_index ; j--) // finding first element greater than nums[save_index] from right
		{
			if(nums[j] - nums[save_index] < min && nums[j]>nums[save_index]) 
			{
				min = nums[j] - nums[save_index];
				save_index2 = j;
			}
			
		}
		
		// swapping both the element
		int temp = nums[save_index2];
		nums[save_index2] = nums[save_index];
		nums[save_index] = temp;
		
		int i = save_index+1;
		int j = nums.length-1;
		
		// reverse the array from save_index to save_index2 to get next biggest array permutation 
		while(i<j) 
		{
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	
	}

	  
	public static void main(String args[]) 
	{
	
		NextPermutation obj = new NextPermutation();
//		int[] num = {1,5,8,6,7,6,5,3,1};
		int[] num = {1};
		
		System.out.println(Arrays.toString(num));
		obj.finder(num);
		System.out.println(Arrays.toString(num));
		
	}


}