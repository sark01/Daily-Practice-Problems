import java.io.*;
import java.util.*;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
 */
class TreeNode
{
	String data;
	TreeNode left;
	TreeNode right;
	public TreeNode(String data)
	{	
		this.data=data;
	}
	public void setleft(TreeNode left)
	{
		this.left=left;
	}
	public void setright(TreeNode right)
	{
		this.right=right;
	}

}
public class DPP3
{
	public static void main(String[] ar)
	{
		TreeNode tn = new TreeNode("4");
		tn.left = new TreeNode("2");
		tn.right = new TreeNode("3");
		tn.left.left = new TreeNode("2");
		tn.left.right = new TreeNode("3");

		String s = serialise(tn);
		System.out.println(s);
		inorder(deserialise(s));
	}
	//This method stores the preorder traversal of a tree in String
	//Similar method can be used for sotring the traversal in a file
	//Use of StringBuilder is done to create a mutable object, ie to reuse the same instanc eof the oboject again
	public static String serialise(TreeNode root)
	{
		if(root==null)
			return "null,";
		StringBuilder str = new StringBuilder();
		str.append(root.data);
		str.append(",");
		str.append(serialise(root.left));
		str.append(serialise(root.right));
		return str.toString();
	}
	public static TreeNode deserialise(String s)
	{
		String[] str = s.split(",");
		return deserialiseHelper(str,new int[]{0});
	}
	//tried implementing using a global static variable but the tree formed was incorrect.
	public static TreeNode deserialiseHelper(String[] str,int[] num)
	{
		if(num[0]>str.length||str[num[0]].equals("null"))
		{
			num[0]++;
			return null;
		}
		TreeNode t = new TreeNode(str[num[0]++]);
		t.setleft(deserialiseHelper(str,num));
		t.setright(deserialiseHelper(str,num));
		return t;
	}
	public static void inorder(TreeNode root)
	{
		if(root==null)
			return;
		System.out.print(root.data+",");
		inorder(root.left);
		inorder(root.right);
	}
}