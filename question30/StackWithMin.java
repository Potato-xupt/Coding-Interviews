package question30;

import java.util.Stack;
/**
 * 包含min函数的栈
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 * 解题思路：
 * 用一个辅助栈存放最小值，当新push的值node辅助栈栈顶的值，那么就把node放进辅助栈作为栈顶，
 * 否则就再把辅助栈栈顶的值放入辅助栈栈顶一次
 * @author Potato
 *
 */
public class StackWithMin {
	
	private Stack<Integer> data = new Stack<>();
	private Stack<Integer> min = new Stack<>();
	
	 public void push(int node) {
		 data.push(node);
		 /**
		  * 先判断栈是否为空，和node与辅助栈栈顶的值
		  */
		 if(min.isEmpty() || node < min.peek()) {
			 min.push(node); 
		 }else {
	    	 min.push(min.peek());
	     }
	 }
	    
	 public void pop() {
		 /**
		  * 两个同时pop即可
		  */
		 min.pop();
		 data.pop();
	 }
	    
	 public int top() {
		 return data.peek();
	 }
	    
	 public int min() {
		 /**
		  * 返回辅助栈栈顶的值即可
		  */
		 return min.peek();
	 }
}
