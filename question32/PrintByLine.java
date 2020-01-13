package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import commons.TreeNode;
/**
 * �Ѷ�������ӡ�ɶ���
 * ��Ŀ����
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 * ����˼·��
 * ����ͬ�������´�ӡ������һ����ֻ����ÿһ��whileѭ����ʼ��ʱ�򣬼�¼��ǰ�����н�����������Ϊ����������Ǹ�����һ�����������
 * @author Potato
 *
 */

public class PrintByLine {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	/**
    	 * ���жϱ߽�������������Ϊnull��
    	 * ��Ϊnullʱ����һ���յ�ArrayList
    	 */
    	ArrayList<ArrayList<Integer> > result = new ArrayList<>();
    	if(pRoot == null) {
    		return result;
    	}
    	/**
         * �ȰѸ��ڵ�������
         */
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(pRoot);
    	while(!queue.isEmpty()) {
    		/**
    		 * ��¼��ǰ��������
    		 * ����������Ǹ�����һ�����������
    		 * ����һ�����ֵȫ������List�У��ٷ���result��
    		 */
    		int size = queue.size();
    		ArrayList<Integer> temp = new ArrayList<>();
    		for (int i = 0; i < size; i++) {
    			/**
            	 * �Ӷ�����ȥ����㣬�Ѹýڵ��������ArrayList��ģ�������
            	 */
				TreeNode node = queue.poll();
				temp.add(node.val);
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
    		result.add(temp);
    	}
    	return result;
    	
    }
}
