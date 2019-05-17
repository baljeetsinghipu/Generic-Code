/* 
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly twice. Find that single one.
 * Single Number II
 */


package genericCode;

public class singleNumber {
	
	int finder(int[] num) 
	{
		int x1=0,x2=0,x3=0,mask=0;
		
		for(int i: num) 
		{
			x2^=x1&i;
			x1^=i;
			mask = ~(x2&x1);
			x2&=mask;
			x1&=mask;
			
		}
		
		return x2;
	}

	public static void main(String[] args) {
		singleNumber obj = new singleNumber();
		// TODO Auto-generated method stub
		int[] nums = {9,3,3,4,5,6,8,8,6,5,4,3,4,5,6,8,9};
		System.out.print(obj.finder(nums));
		
	}

}
