import java.io.*;
import java.util.*;

/*
Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

public class DPP1
{
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int k = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int len = s.length;
			int[] a = new int[len];
			for(int i=0;i<len;i++)
				a[i] = Integer.parseInt(s[i]);
			Arrays.sort(a);
			int start=0, end=len-1;
			out.println(checkSum(a,start,end, k));
			out.flush();
		}
	}
	public static boolean checkSum(int[] a, int start, int end, int k)
	{
		while(start<end)
		{
			if(a[start]+a[end]==k)
				return true;
			else if(a[start]+a[end]>k)
				end--;
			else
				start++;
		}
		return false;
	}
}

