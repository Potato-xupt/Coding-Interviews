package question26;

import commons.TreeNode;
/**
 * �����ӽṹ
 * ��Ŀ����
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * ����˼·��
 * �ݹ顣
 * ����root1���ҵ���root2��ֵ��ͬ�Ľ�㣬Ȼ��Ӹý�㿪ʼ�����Աȣ��ж��Ƿ���ͬ��
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class HasSubtree {

	public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;
        /**
         * �߽��������ж�
         */
        if(root1 != null && root2 != null) {
        	/**
        	 * ���root1����ֵ��root2����ֵ��ͬ���Ӹýڵ㿪ʼ�����ж�
        	 */
        	if(root1.val == root2.val) {        		
            	result = DoesTree1HaveTree2(root1,root2);
            }
        	/**
        	 * �������ͬ���ͼ�������root1
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
		 * ���root2���꣬��ô��֤�������ڵ�
		 */
		if(root2 == null) {			
			return true;
		}
		/**
		 * ���root2û���꣬��root1����
		 * or �������Ľڵ�ֵ����ͬ����ô����false
		 */
		if(root1 == null || root1.val != root2.val) {			
			return false;
		}		
		/**
		 * ���root1��ֵ==root2��ֵ
		 * �����ݹ�Ա�������ֵ
		 */
		return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
					
	}
}
