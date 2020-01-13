package question27;

import commons.TreeNode;
/**
 * �������ľ���
 * ��Ŀ����
 * ���������Ķ�����������任Ϊԭ�������ľ���
 * ��������:
 * �������ľ����壺Դ������ 
 *  	    8
 *   	   /  \
 *   	  6   10
 *   	 / \  / \
 *   	5  7 9 11
 *   	���������
 *   	    8
 *   	   /  \
 *   	  10   6
 *   	 / \  / \
 *   	11 9 7  5
 *   
 * ����˼·��
 * �Ƚ������ڵ�������ӽڵ㣬Ȼ��ݹ������ӽ�㣬��������
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Mirror {
	public void Mirror(TreeNode root) {
		/**
		 * �߽�������ж�
		 */
        if(root == null || (root.left == null && root.right == null) ) {
        	return ;
        }
        /**
         * ���������ӽڵ�
         */
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        /**
         * �����ӽڵ㲻Ϊ�յ�����£����ж�Ҳ���ԣ���Ϊ�ڿ�ʼ�ж���root�Ƿ�Ϊ�գ��˴��ж���Ϊ�˱������ݹ顢�˷���Դ���������ݹ齻�������ӽڵ���ӽ��
         */
        if(root.left != null) {
        	Mirror(root.left);
        }
        if(root.right != null) {
        	Mirror(root.right);
        }
    }
	
}
