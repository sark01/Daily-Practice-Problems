/*
The question we'll work through is the following: 
Return a new sorted merged list from K sorted lists, each with size N. Before we move on any further, you should take some time to think about the solution!
*/
import java.io.*;
import java.util.*;

public class DPPHard1
{
	public static void main(String[] ar)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		ArrayList<PriorityQueue<Integer>> a = new ArrayList<>();
		for(int j=0;j<k;j++)
		{
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			String[] s = br.readLine().split(" ");
			for(int i=0;i<n;i++)
				pq.add(Integer.parseInt(s[i]));
			a.add(pq);
		}
		while(!allHeapsEmpty(a))
		{
			int smallest_heap=-1, min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				if(a.get(i).peek()!=null && a.get(i).peek()<min)
				{
					min=a.get(i).peek();
					smallest_heap=i;
				}
			}
			System.out.print(a.get(smallest_heap).poll()+" ");
		}
	}
	public static boolean allHeapsEmpty(ArrayList<PriorityQueue<Integer>> a)
	{
		int c=0;
		for(int i=0;i<a.size();i++)
			if(a.get(i).size()==0)
				c++;
		if(c==a.size())
			return true;
		return false;
	}
}