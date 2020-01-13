package question06;


import java.util.ArrayList;
import java.util.Stack;

import commons.ListNode;

/**
 * 从尾到头打印链表
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 
 * 解题思路：
 * 栈  or  ArrayList or  递归  
 * 
 * 耗时排序：栈 < 递归   < ArrayList
 * 推荐用栈实现，因为当链表长度较长时，使用递归的方式会导致函数调用得层级很深，从而可能导致函数掉调用栈溢出
 * @author Potato
 *
 */
public class PrintListFromTailToHead {
	
	/**
	 * 用栈的方法实现
	 * 24ms
	 * 运行时间：17ms
	 * 运行时间：23ms
	 * 运行时间：17ms
	 * 运行时间：20ms 
	 *  平均：20.2
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null) {
        	return result;
        }
       
        
        
        Stack<Integer> stack = new Stack<Integer>();
        ListNode head = listNode;
        
        while (head != null) {
        	stack.push(head.val);
        	head = head.next;
        }
        
       
        
        while(!stack.isEmpty()) {
        	result.add(stack.pop());
        }
        return result;
    }
	
	/**
	 * 用ArrayList的方法实现
	 * 运行时间：21ms
	 * 运行时间：25ms
	 * 运行时间：24ms
	 * 运行时间：17ms
	 * 运行时间：20ms
	 *  平均：21.4
	 * @param listNode
	 * @return
	 */
//	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//		ArrayList<Integer> result = new ArrayList<>();
//		if(listNode == null) {
//        	return result;
//        }
//		
//		ListNode head = listNode;
//		 while (head != null) {
//	        	result.add(head.val);
//	        	head = head.next;
//	     }
//		 
//		 Collections.reverse(result);
//		 return result;
//		
//	}
	
	/**
	 * 用递归的方法实现
	 * 运行时间：30ms
	 * 运行时间：19ms
	 * 运行时间：19ms
	 * 运行时间：19ms
	 * 运行时间：19ms
	 * 平均：21.2
	 */
//	ArrayList<Integer> result = new ArrayList<>();
//	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//		
//		 if (listNode != null) {
//			 if(listNode.next != null) {
//				 printListFromTailToHead(listNode.next);
//			 }
//			 result.add(listNode.val);
//		 }
//		 return result;
//	}
}
