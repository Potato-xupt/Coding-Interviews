package question68;

import commons.TreeNode;
/**
 * ���������ڵ����͹�������(����������)
 * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 * 
 * ����˼·��
 * ������������ʣ������ڵ� p, q �Ĺ������� root ���� root.val >= p.val && root.val <= q.val��
 * @author Potato
 *
 */
public class LowestCommonAncestorByBinarySortTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/**
		 * ���Ϊ���򷵻�
		 */
		if(root == null ) {
			return root;
		}
		/**
		 * ��ǰ�ڵ�� p��q����Ҫ��С�ģ��ʹ�����������
		 */
		if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		/**
		 * ��ǰ�ڵ�� p��q��С��Ҫ�Ҵ�ģ��ʹ�����������
		 */
		if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}

}
