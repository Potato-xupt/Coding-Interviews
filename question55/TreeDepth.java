package question55;

import commons.TreeNode;
/**
 * 二叉树的深度
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * 解题思路：
 * 分别遍历左子树和右子树长度，然后较长的一个即可，这样递归
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class TreeDepth {
	
    public int TreeDepth(TreeNode root) {
    	/**
    	 * 根节点为空或者到达叶节点的情况
    	 */
    	if(root == null) {
    		return 0;
    	}
    	/**
    	 * 递归求左右子树长度
    	 */
    	int left = TreeDepth(root.left);
    	int right = TreeDepth(root.right);
    	
    	/**
    	 * 返回较长的一个
    	 */
    	return left>right ? left+1:right+1;
    }

}
