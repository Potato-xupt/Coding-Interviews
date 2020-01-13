package question55;

import commons.TreeNode;
/**
 * �����������
 * ��Ŀ����
 * ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * 
 * ����˼·��
 * �ֱ���������������������ȣ�Ȼ��ϳ���һ�����ɣ������ݹ�
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class TreeDepth {
	
    public int TreeDepth(TreeNode root) {
    	/**
    	 * ���ڵ�Ϊ�ջ��ߵ���Ҷ�ڵ�����
    	 */
    	if(root == null) {
    		return 0;
    	}
    	/**
    	 * �ݹ���������������
    	 */
    	int left = TreeDepth(root.left);
    	int right = TreeDepth(root.right);
    	
    	/**
    	 * ���ؽϳ���һ��
    	 */
    	return left>right ? left+1:right+1;
    }

}
