package question68;

import commons.TreeNode;

/**
 * 树中两个节点的最低公共祖先(普通二叉树)
 * 给定二叉树，找到树中两个给定节点的最低共同祖先（LCA）。
 * 根据维基百科上LCA的定义：“最低共同祖先在两个节点p和q之间定义为T中的最低节点，其中p和q都是后代（我们允许节点成为其自身的后代）。 
 * 
 * 解题思路：
 * 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
 * @author Potato
 *
 */
public class LowestCommonAncestorByTree {


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/**
		 * 如果为空或者找到即返回
		 */
	    if (root == null || root == p || root == q)
	        return root;
	    /**
	     * 递归查找左右子树
	     */
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    return left == null ? right : right == null ? left : root;
	}
}
