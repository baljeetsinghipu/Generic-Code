package genericCode;

//
//You are on a flight and wanna watch two movies during this flight. 
//You are given int[] movie_duration which includes all the movie durations. 
//You are also given the duration of the flight which is d in minutes. 
//Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min). 
//Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.


import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
	
	int[] finder(int[] duration, int limit )  // (O(nlogn) + O(n)) = O(nlogn)
	{
		Arrays.parallelSort(duration); //(O(nlogn))
		int i =0;
		int max =-1;
		int j = duration.length-1;
		int[] result = new int[2]; 
		while(i<j)                                  // O(n)
		{
			int sum = duration[i]+duration[j];
			if(sum<limit-30) 
			{
				int temp =max;
				max = Math.max(sum, max);
				if(temp!=max) 
				{
					result[0]=duration[i];
					result[1] = duration[j];
				}
				
				i++;
			}
			else j--;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie obj = new Movie();
		int[] arr = {90, 85, 75, 60, 120, 150, 125};
		int[] result = obj.finder(arr,250);
		System.out.print(Arrays.toString(result));

	}

}
