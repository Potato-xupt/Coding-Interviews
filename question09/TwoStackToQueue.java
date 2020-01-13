package question09;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 解题思路：
 * push时放入stack1中即可。
 * 
 * pop时，先看stack2中有无元素，若不为空，则pop出stack2的元素返回即可。
 * 若stack2为空，则先把stack1中的元素都pop出来，push到stack2中，再返回stack2的栈顶元素即可
 * @author Potato
 *
 */
public class TwoStackToQueue {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    /**
     * push时放入stack1中即可。
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	/**
    	 * 先看stack2中有无元素，若不为空，则pop出stack2的元素返回即可。
    	 */
    	if(!stack2.isEmpty()) {
    		return stack2.pop();
    	}
    	/**
    	 * 若stack2为空，则先把stack1中的元素都pop出来，push到stack2中，再返回stack2的栈顶元素即可
    	 */
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	
    	return stack2.pop();
    	
    }

}
