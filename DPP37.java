/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/
import java.io.*;
import java.util.*;

class DPP37
{
	public static int[] a;
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			
			String[] s = br.readLine().split(" ");
			int len = s.length;
			a = new int[len];
			for(int i=0;i<len;i++)
				a[i]=Integer.parseInt(s[i]);
			System.out.println(printRes(len));
		}
	}
	public static ArrayList<ArrayList<Integer>> printRes(int len)
	{
		int[] a1=a;
		ArrayList<ArrayList<Integer>> arr1 = new ArrayList<>();
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		int c = (int)Math.pow(2,len)-1;
		while(c-->0)
		{
			String s1 = q.peek(),s2=s1;
			q.remove();
			arr1.add(addtoArray(s1,len));
			s1+="0";
			s2+="1";
			q.add(s1);
			q.add(s2);
		}
		return arr1;
	}
	public static ArrayList<Integer> addtoArray(String s,int len)
	{
		
		ArrayList<Integer> arr = new ArrayList<>();
		int len1 = s.length();
		if(len1<len)
		{
			for(int i=0;i<len-len1;i++)
				s="0"+s;
		}
		System.out.println(s);
		for(int i=0;i<len;i++)
		{
			if(Character.getNumericValue(s.charAt(i))==1)
				arr.add(a[i]);
		}
		System.out.println(arr);
		return arr;
	}
}

