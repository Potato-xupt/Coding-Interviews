package question30;

import java.util.Stack;
/**
 * ����min������ջ
 * ��Ŀ����
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 * 
 * ����˼·��
 * ��һ������ջ�����Сֵ������push��ֵnode����ջջ����ֵ����ô�Ͱ�node�Ž�����ջ��Ϊջ����
 * ������ٰѸ���ջջ����ֵ���븨��ջջ��һ��
 * @author Potato
 *
 */
public class StackWithMin {
	
	private Stack<Integer> data = new Stack<>();
	private Stack<Integer> min = new Stack<>();
	
	 public void push(int node) {
		 data.push(node);
		 /**
		  * ���ж�ջ�Ƿ�Ϊ�գ���node�븨��ջջ����ֵ
		  */
		 if(min.isEmpty() || node < min.peek()) {
			 min.push(node); 
		 }else {
	    	 min.push(min.peek());
	     }
	 }
	    
	 public void pop() {
		 /**
		  * ����ͬʱpop����
		  */
		 min.pop();
		 data.pop();
	 }
	    
	 public int top() {
		 return data.peek();
	 }
	    
	 public int min() {
		 /**
		  * ���ظ���ջջ����ֵ����
		  */
		 return min.peek();
	 }
}
