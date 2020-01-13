package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import commons.TreeNode;
/**
 * �������´�ӡ������
 * ��Ŀ����
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * ����˼·��
 * ʹ�ö��У�����ĳ�����ʱ���Ѹýڵ���ӽڵ������У�Ȼ������Ӷ�����ȡ���ڵ㣬����ýڵ��ֵ�������Ѹýڵ���ӽڵ������У�ѭ�����ɡ�
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class PrintFromTopToBottom {
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<>();
    	/**
    	 * ���жϱ߽�������������Ϊnull��
    	 * ��Ϊnullʱ����һ���յ�ArrayList
    	 */
        if(root == null) {
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * �ȰѸ��ڵ�������
         */
        queue.add(root);
        while(!queue.isEmpty()) {
        	/**
        	 * �Ӷ�����ȥ����㣬�Ѹýڵ��������ArrayList��ģ�������
        	 */
        	TreeNode node = queue.poll();
        	result.add(node.val);
        	/**
        	 * �ж����������Ƿ�Ϊ�գ���Ϊ�����������С�
        	 */
        	if(node.left != null) {
        		queue.add(node.left);
        	}
        	if(node.right != null) {
        		queue.add(node.right);
        	}
        }
        return result;
    }
}
