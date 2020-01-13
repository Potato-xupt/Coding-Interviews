package question22;

import commons.ListNode;

/**
 * 链表中倒数第k个结点
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 解题思路：
 * 双指针法。两个指针同时指向头节点，先让前一个指针走k-1步，然后两个一起走，当前一个指针走到链表尾部的时候，后一个正好在倒数第k个结点的位置
 * @author Potato
 *
 */
public class FindKthToTail {
	
	public ListNode findKthToTail(ListNode head,int k) {
		/**
		 * 边界条件！！！！健壮性
		 */
		if(head == null || k <= 0) {
			return null;
		}
		
		/**
		 * 前一个指针，走k-1步，并且判断链表长度是否达到k，否则没有倒数第k个结点，返回null。
		 */
		ListNode befor = head;		
		for(int i = 0; i < k-1 ; i++) {
			if(befor.next != null) {
				befor = befor.next; 
			}else {
				return null;
			}
		}
		/**
		 * 后一个指针也指向头节点，两个一起走，然后befor走到尾部，after到达倒数第k个节点
		 */
		ListNode after = head;
		while(befor.next != null) {
			befor = befor.next; 
			after = after.next;
		}
		return after;
    }

}
