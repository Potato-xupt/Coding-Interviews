package question28;

import commons.TreeNode;
/**
 * �ԳƵĶ�����
 * ��Ŀ����
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 	
 *����˼·��
 *ǰ������ͶԳ�ǰ����� �Աȣ�һ����Ϊtrue����ע�⣺nullҲҪ�Աȣ�
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
		 * ����������ڵ�ĸ��ڵ���ͬ���ӽڵ㶼Ϊnull����Ϊtrue
		 */
		if(root1 == null && root2 == null) {
			return true;
		}
		/***
		 * һ��Ϊnull��һ����Ϊnull�����������ڵ��ֵ����ͬ������false
		 */
		if(root1 == null || root2 == null || root1.val != root2.val) {
			return false;
		}
		/**
		 * �ԳƱ������ڵ���ӽڵ㣨�ԳƱ����ֱ�Ϊǰ����� �� �Գ�ǰ�����
		 */
		return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
	}
}
