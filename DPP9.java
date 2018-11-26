import java.io.*;
import java.util.*;
/*
Good morning! Here's your coding interview prolem for today.

This problem was asked by Airbnb.

Given a list of integers, writ a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should retrn 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/

public class DPP9
{
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[] s = br.readLine().split(" ");
		int n = s.length;
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(s[i]);
		int incl=a[0],excl=0,temp=0;
		for(int i=1;i<n;i++)
		{
			temp=incl;
			incl=Math.max(incl,excl+a[i]);
			excl=temp;
		}
		out.println(incl);
		out.flush();
	}
}
/*
	t   i   e
2	0	2 	0
4	2	4 	2
6	4	8	4
2	8	8	8
5	8	13	8

*/			