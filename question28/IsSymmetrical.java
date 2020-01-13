package question28;

import commons.TreeNode;
/**
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 	
 *解题思路：
 *前序遍历和对称前序遍历 对比，一致则为true，（注意：null也要对比）
 *
 * @author Potato
 *
 */
public class IsSymmetrical {
	
	public boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot,pRoot);
    }
	
	private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
		/**
		 * 如果这两个节点的父节点相同，子节点都为null，则为true
		 */
		if(root1 == null && root2 == null) {
			return true;
		}
		/***
		 * 一个为null，一个不为null，或者两个节点的值不相同，返回false
		 */
		if(root1 == null || root2 == null || root1.val != root2.val) {
			return false;
		}
		/**
		 * 对称遍历父节点的子节点（对称遍历分别为前序遍历 和 对称前序遍历
		 */
		return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
	}
}
