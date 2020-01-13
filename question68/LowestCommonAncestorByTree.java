package question68;

import commons.TreeNode;

/**
 * ���������ڵ����͹�������(��ͨ������)
 * �������������ҵ��������������ڵ����͹�ͬ���ȣ�LCA����
 * ����ά���ٿ���LCA�Ķ��壺����͹�ͬ�����������ڵ�p��q֮�䶨��ΪT�е���ͽڵ㣬����p��q���Ǻ������������ڵ��Ϊ������ĺ������ 
 * 
 * ����˼·��
 * �����������в����Ƿ���� p ���� q����� p �� q �ֱ������������У���ô��˵�����ڵ������͹������ȡ�
 * @author Potato
 *
 */
public class LowestCommonAncestorByTree {


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/**
		 * ���Ϊ�ջ����ҵ�������
		 */
	    if (root == null || root == p || root == q)
	        return root;
	    /**
	     * �ݹ������������
	     */
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    return left == null ? right : right == null ? left : root;
	}
}
