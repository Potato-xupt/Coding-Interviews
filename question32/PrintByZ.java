package question32;

import java.util.ArrayList;
import java.util.Stack;

import commons.TreeNode;
/**
 * ��֮����˳���ӡ������
 * ��Ŀ����
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * 
 * ����˼·��
 * ������ջA �� B���ڴ�ӡĳһ��Ľڵ㣨Aջ��ʱ������һ��Ľ�㱣�浽��һ��ջ��Bջ�����һ��ѭ���������һ��ջ��Bջ��������һ��ջ�Ľ�㱣�浽Aջ�С�
 * �����������ȷ���ڵ㣬�ٷ��ҽڵ㡣
 * ����ż�����ȷ��ҽڵ㣬�ٷ���ڵ㡣
 * @author Potato
 *
 */
public class PrintByZ {

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
    	 * ��������ջ���ֱ����������������ż����
         * �ȰѸ��ڵ����������ջ��
         */
    	Stack<TreeNode> odd = new Stack<>();
    	Stack<TreeNode> even = new Stack<>();
    	odd.push(pRoot);
    	/**
    	 * ������ջ��Ϊ��ʱ��ѭ������
    	 * ����ջ����һ��Ϊ�գ����Ծͱ�����Ϊ�յ��Ǹ�������Ԫ�ط���Ϊ�յ��Ǹ�
    	 */
    	while(!odd.isEmpty() || !even.isEmpty()) {
    		ArrayList<Integer> temp = new ArrayList<>();
    		/**
    		 * ����������ջ
    		 */
    		if(!odd.isEmpty()) {
    			while(!odd.isEmpty()) {
    				TreeNode node = odd.pop();
    				temp.add(node.val);
    				/**
    	        	 * �ж����������Ƿ�Ϊ�գ���Ϊ�����������С�
    	        	 * ��Ϊ�������������㣬����
    	        	 * �ȷ����������ٷ�������
    	        	 */
    				if(node.left != null) {
    					even.push(node.left);
    				}
    				if(node.right != null) {
    					even.push(node.right);
    				}
    			}
    		}else {
    			/**
        		 * ����ż����ջ
        		 */
    			while(!even.isEmpty()) {
    				TreeNode node = even.pop();
    				temp.add(node.val);
    				/**
    	        	 * �ж����������Ƿ�Ϊ�գ���Ϊ�����������С�
    	        	 * ��Ϊ��������ż���㣬����
    	        	 * �ȷ����������ٷ�������
    	        	 */
    				if(node.right != null) {
    					odd.push(node.right);
    				}
    				if(node.left != null) {
    					odd.push(node.left);
    				}
    			}
    		}
    		result.add(temp);
    	}
    	return result;
    }
}
