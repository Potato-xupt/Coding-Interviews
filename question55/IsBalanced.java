package question55;

import commons.TreeNode;
/**
 * ƽ�������
 * ��Ŀ����
 * ����һ�ö������ĸ���㣬�жϸ����ǲ���ƽ���������
 * ���ĳ����������������������������������1����ô������һ��ƽ���������
 * ע�⣺�涨����Ҳ��һ��ƽ���������
 * 
 * ����˼·��
 * ͬ��һ��һ����˼·��ֻ������ÿ�εݹ�Ĺ����У��Ա����������ĸ߶�
 * ����߶Ȳ����1����ô�Ͳ���ƽ������ֱ�ӷ���
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
		 * �����ڵ�Ϊ�ջ��ߵ���Ҷ�ڵ�
		 * �����Ѿ����жϳ��Ƿ�ƽ������
		 */
		if(root == null || !isBalanced){
			return 0;
		}
		/**
		 * �������������õ����
		 */
		int left = height(root.left);
		int right = height(root.right);
		
		/**
		 * ����߶Ȳ����1������ƽ�������
		 */
		if(left - right > 1 || left - right < -1) {
			isBalanced = false;
		}
		/**
		 * Ȼ����Ƚ�����Ǹ�����������
		 */
		return Math.max(left, right)+1;		
	}
}
