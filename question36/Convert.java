package question36;

import commons.TreeNode;
/**
 * ������������˫������
 * ��Ŀ����
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * ����˼·��
 * ��������ݹ�����У������Ǳ���ת���������ʱ�������������Ѿ�ת������һ��������������Ҵ�ʱ����β����ֵΪ��������ֵ���Ľ���ֵ��
 * ���ǽ����͸����������������ʱ�������������β����
 * ����ȥ����������������֪����������������һ������ʱΪ������ֵ��С�Ľ�㣬
 * ���ǽ����͸�������������������������������İ취�����ݹ鼴�ɽ�����⡣
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Convert {
	/**
	 * node����ǰ�ڵ�
	 * head��ͷ�ڵ�
	 */
	TreeNode node = null;
	TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	/**
    	 * �жϱ߽�����
    	 */
        if(pRootOfTree == null) {
        	return null;
        }
        /**
         * ����������
         */
        Convert(pRootOfTree.left);
        
        if(node == null) {
        	/**
             * ���ڵ㸳ֵ
             */
        	node = pRootOfTree;
        	head = pRootOfTree;
        }else {
        	/**
        	 * ����˫������
        	 */
        	node.right = pRootOfTree;
        	pRootOfTree.left = node;
        	node = pRootOfTree;
        }
        /**
         * ����������
         */
        Convert(pRootOfTree.right);
        return head;
    }
}
