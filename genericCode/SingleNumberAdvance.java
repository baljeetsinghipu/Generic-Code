/*
 * Given an array of numbers nums, in which exactly two elements appear only 
 * once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * 
 */

package genericCode;

import java.util.Arrays;

public class SingleNumberAdvance {
	
	int[] finder (int[] arr) 
	{
		int[] result = new int[2];
		int diff =0;
		
		for(int i : arr) diff = diff^i;
		diff = diff & -diff;
		
		for(int i :arr) 
		{
			if((i&diff)==0) result[1] = result[1]^i; //separate into 2 sub array based on difference 
			else result[0] = result[0]^i;
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumberAdvance obj = new SingleNumberAdvance();
		int[] arr= {1,2,1,3,2,5};
		System.out.print(Arrays.toString(obj.finder(arr)));
		
	}

}
