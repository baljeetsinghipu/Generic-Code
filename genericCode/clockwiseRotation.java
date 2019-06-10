/*
 * You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).

	Note:
	You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
	DO NOT allocate another 2D matrix and do the rotation.
 */

package genericCode;

import java.util.Arrays;

public class clockwiseRotation {
	
	void rotateImage(int[][]image) 
	{
		
		//Turn row into  columns
		
		for(int i=0;i<image.length;i++) 
		{
			for(int j = i+1; j<image[i].length;j++) 
			{
				int temp = image[i][j];
				image[i][j] = image[j][i] ;
				image[j][i] = temp;
			}
		}
		
		//Reverse each row
		for(int k =0;k<image.length;k++) 
		{
			int i =0;
			int j = image[0].length-1;
			
			while(i<j) 
			{
				int temp = image[k][j];
				image[k][j]=image[k][i]; 
				image[k][i]= temp;
				i++;
				j--;
			}
		}			
	}

	public static void main(String[] args) {
		
		clockwiseRotation obj = new clockwiseRotation(); //object creation
		
		int[][] image = {
		                 {1,2,3},
		                 {4,5,6},
		                 {7,8,9}
		}; //Input data in 2d Matrix
		
		obj.rotateImage(image);//calling rotateimage function which will rotate the image by 90 degree (In place).
		
		System.out.println(Arrays.deepToString(image));


	}

}
