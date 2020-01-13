package question54;

import commons.TreeNode;
/**
 * 二叉搜索树的第k个结点
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 
 * 解题思路：
 * 利用二叉查找树中序遍历有序的特点。
 * 先序遍历的结果就是从小到大的顺序
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class KthNode {
	private int count = 0;
	private TreeNode result; 
	
	public TreeNode KthNode(TreeNode pRoot, int k){
       inOrder(pRoot,k);
       return result;
    }

	private void inOrder(TreeNode pRoot, int k) {
		/**
		 * 边界条件判断
		 */
		if(pRoot == null || count >= k) {
			return ;
		}
		/**
		 * 先序遍历，先左子树
		 */
		inOrder(pRoot.left,k);
		/**
		 * 计数，第k小就是第k个节点
		 */
		if(++count == k) {
			result = pRoot;
		}
		inOrder(pRoot.right,k);	
	}

}
