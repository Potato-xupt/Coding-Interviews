package question09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 * @author Potato
 *
 */

public class TwoQueueToStack {
	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public void push(int node) {
        if(!queue2.isEmpty()) {
        	queue2.add(node);
        }else {
        	queue1.add(node);
        }
    }
    
    public int pop() {
    	if(!queue1.isEmpty()){
    		while(queue1.size() != 1) {
    			queue2.add(queue1.poll());
    		}
    		return queue1.poll();
    	}
    	while(queue2.size() != 1) {
			queue1.add(queue2.poll());
		}
		return queue2.poll();
    }
}
