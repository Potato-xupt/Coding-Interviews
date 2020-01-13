package question26;

import commons.TreeNode;
/**
 * 树的子结构
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 解题思路：
 * 递归。
 * 遍历root1，找到与root2根值相同的结点，然后从该结点开始遍历对比，判断是否相同。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class HasSubtree {

	public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;
        /**
         * 边界条件的判断
         */
        if(root1 != null && root2 != null) {
        	/**
        	 * 如果root1结点的值与root2结点的值相同，从该节点开始遍历判断
        	 */
        	if(root1.val == root2.val) {        		
            	result = DoesTree1HaveTree2(root1,root2);
            }
        	/**
        	 * 如果不相同，就继续遍历root1
        	 */
            if(!result) {
            	result = HasSubtree(root1.left, root2);
            }
            if(!result) {
            	result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

	private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		/**
		 * 如果root2走完，那么就证明是属于的
		 */
		if(root2 == null) {			
			return true;
		}
		/**
		 * 如果root2没走完，而root1走完
		 * or 两个树的节点值不相同，那么返回false
		 */
		if(root1 == null || root1.val != root2.val) {			
			return false;
		}		
		/**
		 * 如果root1的值==root2的值
		 * 继续递归对比两树的值
		 */
		return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
					
	}
}
