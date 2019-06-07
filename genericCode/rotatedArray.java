// Search in Rotated Sorted Array

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Your algorithm's runtime complexity must be in the order of O(log n).



package genericCode;

public class rotatedArray {
	
	 int finder(int arr[],int target){
		int n = arr.length;
        int lo=0,hi=n-1;

        while(lo<hi){
            int mid=(lo+hi)/2;
            if(arr[mid]>arr[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(arr[realmid]==target)return realmid;
            if(arr[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotatedArray  obj = new rotatedArray();
		int[] arr = new int[]{7,8,9,10,1,2,3,4,5,6};
		int num = 10;
		System.out.print(obj.finder(arr,num));

	}

}
