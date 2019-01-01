
/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 */


class TreeNode{
	int val;
	TreeNode left,right;
	TreeNode(int x){
		val=x;
		left=null;
		right=null;
	}
}
class Count{
	int c=0;
}
class UniVal{
	public static TreeNode root;
	Count ct = new Count();
	public int uniCount(TreeNode root)
	{
		uniCountHelper(root,ct);
		return ct.c;
	}
	public boolean uniCountHelper(TreeNode root, Count count)
	{
		boolean left,right;
		if(root==null) return true;
		left = uniCountHelper(root.left,count);
		right = uniCountHelper(root.right,count);

		if(left!=true||right!=true)return false;
		if(root.left!=null && root.val!=root.left.val)return false;
		if(root.right!=null && root.val!=root.right.val)return false;

		count.c++;
		return true;
	}
	public boolean uniCountChecker(TreeNode root)
	{
		boolean left,right;
		if(root==null) return true;
		left = uniCountChecker(root.left);
		right = uniCountChecker(root.right);

		if(left!=true||right!=true)return false;
		if(root.left!=null && root.val!=root.left.val)return false;
		if(root.right!=null && root.val!=root.right.val)return false;

		return true;
	}
	public static void main(String[] a)
	{
		UniVal tree = new UniVal();
		tree.root = new TreeNode(1); 
		tree.root.left = new TreeNode(1); 
		tree.root.right = new TreeNode(1); 
		tree.root.left.left = new TreeNode(1); 
		tree.root.left.right = new TreeNode(1); 
		tree.root.right.left = new TreeNode(1); 
      	tree.root.right.right = new TreeNode(1);
      	System.out.println(tree.uniCount(root));
      	System.out.println(tree.uniCountChecker(root));
	}
}
