package dynamicProgramming;

public class MinimumSubsetSumDifference {
	
	public int canPartition(int[] num)
	{
		int total=0;
		for(int i: num)total+=i;
		int cal=0;
		return recursion(num,cal,total,0);
	} 
	
	//for recursion
	int recursion(int[]num,int cal,int total,int current_index)
	{
		if(current_index>num.length-1) return Math.abs((total-cal)-cal);
		if(cal>total) return Math.abs((total-cal)-cal);
		
		int num1= recursion(num,cal+num[current_index],total,current_index++);
		int num2= recursion(num,cal,total,current_index++);
		
		return Math.min(num1, num2);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MinimumSubsetSumDifference ss = new MinimumSubsetSumDifference();
	    int[] num = {3, 8, 4, 4, 3, 1};
	    System.out.println(ss.canPartition(num));
//	    num = new int[] { 1, 2, 7, 1, 5 };
//	    System.out.println(ss.canPartition(num, 10));
//	    num = new int[] { 1, 3, 4, 8 };
//	    System.out.println(ss.canPartition(num, 6));

	}

}
