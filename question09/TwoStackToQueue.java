package question09;

import java.util.Stack;

/**
 * ������ջʵ�ֶ���
 * ��Ŀ����
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * 
 * ����˼·��
 * pushʱ����stack1�м��ɡ�
 * 
 * popʱ���ȿ�stack2������Ԫ�أ�����Ϊ�գ���pop��stack2��Ԫ�ط��ؼ��ɡ�
 * ��stack2Ϊ�գ����Ȱ�stack1�е�Ԫ�ض�pop������push��stack2�У��ٷ���stack2��ջ��Ԫ�ؼ���
 * @author Potato
 *
 */
public class TwoStackToQueue {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    /**
     * pushʱ����stack1�м��ɡ�
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	/**
    	 * �ȿ�stack2������Ԫ�أ�����Ϊ�գ���pop��stack2��Ԫ�ط��ؼ��ɡ�
    	 */
    	if(!stack2.isEmpty()) {
    		return stack2.pop();
    	}
    	/**
    	 * ��stack2Ϊ�գ����Ȱ�stack1�е�Ԫ�ض�pop������push��stack2�У��ٷ���stack2��ջ��Ԫ�ؼ���
    	 */
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	
    	return stack2.pop();
    	
    }

}
