/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Complexity : O(log(min(nums,num2)))

*/



package genericCode;

public class MedianSortedArray {
	
	double medianFinder(int[] nums1, int[] nums2) 
	{
		
		if(nums1.length>nums2.length)return medianFinder(nums2,nums1);
		int x = nums1.length;
		int y = nums2.length;
		int low=0;
		int high = x;
		
		while(low<=high) 
		{
			int cutX = (low+high)/2;
			int cutY = (x+y+1)/2 - cutX;
			
			int maxLeftX = cutX==0?Integer.MIN_VALUE: nums1[cutX-1];
			int minRightX = cutX==x?Integer.MAX_VALUE: nums1[cutX];
			
			int maxLeftY = cutY==0?Integer.MIN_VALUE: nums2[cutY-1];
			int minRightY = cutY==y?Integer.MAX_VALUE	: nums2[cutY];
			
			if(maxLeftX<=minRightY && maxLeftY<=minRightX) 
			{
				if((x+y)%2==0) return ((Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0);
				else  return (double)Math.max(maxLeftX, maxLeftY);
			}
			else if (maxLeftX>minRightY) high--;
			else low = cutX+1;
		}
		
		return 0;
		
	}

	public static void main(String[] args) {
		MedianSortedArray obj = new MedianSortedArray();
		int[] nums2= {4};
		int[] nums1= {1,2,3,5,6};
		System.out.print(obj.medianFinder(nums1,nums2));

	}

}
