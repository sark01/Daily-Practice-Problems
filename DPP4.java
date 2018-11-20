/*Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
*/
import java.util.*; 

class DPP4
{ 
	public static int segregate (int arr[], int size) 
	{ 
		int j = 0; 
		for(int i = 0; i < size; i++) 
		{ 
			if (arr[i] <= 0) 
			{ 
				int temp=arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
				j++; 
			} 
		} 
		return j;
	} 
	public static int findMissing(int arr[], int shift) 
	{ 
		for(int i = shift; i < arr.length; i++) 
		{ 
			int x = Math.abs(arr[i]); 
			if(x - 1 < arr.length-shift && arr[x - 1] > 0)
				arr[x - 1] = -arr[x - 1]; 
		} 
		for(int i = shift; i < arr.length; i++) 
			if (arr[i] > 0) 
			return i+1; 
		return arr.length+1; 
	} 
	public static void main (String[] args) 
	{ 
		int arr[] = {1,3,4,2}; 
		int arr_size = arr.length; 
		int shift = segregate (arr, arr_size); 
		int missing = findMissing(arr, shift); 
		System.out.println("The smallest positive missing number is "+ 
							missing); 
	} 
} 
