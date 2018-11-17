import java.io.*;
import java.util.*;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/
public class DPP2
{
	public static double EPS = 1e-9;
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String[] s = br.readLine().split(" ");
			int len = s.length;
			int[] a = new int[len], res1 = new int[len], res2 = new int[len],res3 = new int[len];
			for(int i=0;i<len;i++)
				a[i] = Integer.parseInt(s[i]);
			res1=prodArr1(a,len);
			for(int i=0;i<len;i++)
				out.print(res1[i]+" ");
			out.println();
			res2=prodArr2(a,len);
			for(int i=0;i<len;i++)
				out.print(res2[i]+" ");
			out.println();
			res3=prodArr3(a,len);
			for(int i=0;i<len;i++)
				out.print(res3[i]+" ");
			out.println();
			out.flush();
		}
	}
	//Generic method
	public static int[] prodArr1(int[] a, int len)
	{
		int prod=1;
		int[] res = new int[len];
		for(int i=0;i<len;i++)
			prod*=a[i];
		for(int i=0;i<len;i++)
			res[i]=prod/a[i];
		return res;
	}
	//Without using division operator in O(n) space
	public static int[] prodArr2(int[] a, int len)
	{
		int[] left = new int[len], right = new int[len],res = new int[len];
		left[0]=1;
		right[len-1]=1;
		for(int i=1;i<len;i++)
			left[i]=left[i-1]*a[i-1];
		for(int i=len-2;i>=0;i--)
			right[i]=right[i+1]*a[i+1];
		for(int i=0;i<len;i++)
			res[i]=left[i]*right[i];
		return res;
	}
	//Without using division operator in O(1) space
	public static int[] prodArr3(int[] a, int len)
	{
		int[] res = new int[len];
		double log_sum=0;
		for(int i=0;i<len;i++)
			log_sum+=Math.log10(a[i]);
		for(int i=0;i<len;i++)
			res[i]=(int)(EPS+Math.pow(10,log_sum-Math.log10(a[i])));
		return res;
	}
}

