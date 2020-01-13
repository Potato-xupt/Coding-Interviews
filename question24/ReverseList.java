package question24;

import commons.ListNode;
/**
 * 反转链表
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 
 * 解题思路:
 * 
 * 记录当前节点node的下一个结点为next，如果next为null，那么它就是反转后的首节点。
 * 把node.next指向他的前一个结点pre，然后把node赋给pre，node.next赋给node
 * 
 * @author Potato
 *
 */
public class ReverseList {
	
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode reverseHead = null;
		ListNode node = head;
		ListNode preNode = null;
		while(node != null) {
			ListNode next = node.next;
			if(next == null) {
				reverseHead = node;
			}
			node.next = preNode;
			preNode = node;
			node = next;
		}
		return reverseHead;
		
	}
}
