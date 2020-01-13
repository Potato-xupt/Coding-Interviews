package question06;


import java.util.ArrayList;
import java.util.Stack;

import commons.ListNode;

/**
 * ��β��ͷ��ӡ����
 * ��Ŀ����
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 * 
 * ����˼·��
 * ջ  or  ArrayList or  �ݹ�  
 * 
 * ��ʱ����ջ < �ݹ�   < ArrayList
 * �Ƽ���ջʵ�֣���Ϊ�������Ƚϳ�ʱ��ʹ�õݹ�ķ�ʽ�ᵼ�º������õò㼶����Ӷ����ܵ��º���������ջ���
 * @author Potato
 *
 */
public class PrintListFromTailToHead {
	
	/**
	 * ��ջ�ķ���ʵ��
	 * 24ms
	 * ����ʱ�䣺17ms
	 * ����ʱ�䣺23ms
	 * ����ʱ�䣺17ms
	 * ����ʱ�䣺20ms 
	 *  ƽ����20.2
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
	 * ��ArrayList�ķ���ʵ��
	 * ����ʱ�䣺21ms
	 * ����ʱ�䣺25ms
	 * ����ʱ�䣺24ms
	 * ����ʱ�䣺17ms
	 * ����ʱ�䣺20ms
	 *  ƽ����21.4
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
	 * �õݹ�ķ���ʵ��
	 * ����ʱ�䣺30ms
	 * ����ʱ�䣺19ms
	 * ����ʱ�䣺19ms
	 * ����ʱ�䣺19ms
	 * ����ʱ�䣺19ms
	 * ƽ����21.2
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
