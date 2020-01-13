package question27;

import commons.TreeNode;
/**
 * 二叉树的镜像
 * 题目描述
 * 操作给定的二叉树，将其变换为原二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树 
 *  	    8
 *   	   /  \
 *   	  6   10
 *   	 / \  / \
 *   	5  7 9 11
 *   	镜像二叉树
 *   	    8
 *   	   /  \
 *   	  10   6
 *   	 / \  / \
 *   	11 9 7  5
 *   
 * 解题思路：
 * 先交换根节点的左右子节点，然后递归左右子结点，继续交换
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Mirror {
	public void Mirror(TreeNode root) {
		/**
		 * 边界的条件判断
		 */
        if(root == null || (root.left == null && root.right == null) ) {
        	return ;
        }
        /**
         * 交换左右子节点
         */
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        /**
         * 左右子节点不为空的情况下（不判断也可以，因为在开始判断了root是否为空，此处判断是为了避免进入递归、浪费资源），继续递归交换左右子节点的子结点
         */
        if(root.left != null) {
        	Mirror(root.left);
        }
        if(root.right != null) {
        	Mirror(root.right);
        }
    }
	
}
