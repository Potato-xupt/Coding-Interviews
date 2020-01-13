package question55;

import commons.TreeNode;
/**
 * 平衡二叉树
 * 题目描述
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 注意：规定空树也是一棵平衡二叉树。
 * 
 * 解题思路：
 * 同上一题一样的思路，只不过在每次递归的过程中，对比左右子树的高度
 * 如果高度差大于1，那么就不是平衡树，直接返回
 * @author Potato
 *
 */
public class IsBalanced {

	private boolean isBalanced = true;
	
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }
	private int height(TreeNode root) {
		/**
		 * 当根节点为空或者到达叶节点
		 * 或者已经是判断出是非平衡树了
		 */
		if(root == null || !isBalanced){
			return 0;
		}
		/**
		 * 遍历左右子树得到深度
		 */
		int left = height(root.left);
		int right = height(root.right);
		
		/**
		 * 如果高度差大于1，即非平衡二叉树
		 */
		if(left - right > 1 || left - right < -1) {
			isBalanced = false;
		}
		/**
		 * 然会深度较深的那个，继续遍历
		 */
		return Math.max(left, right)+1;		
	}
}
