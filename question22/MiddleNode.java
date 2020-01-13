package question22;

/**
 *  链表的中间结点
 *  题目描述
 *  给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *  如果有两个中间结点，则返回第二个中间结点。
 *  
 *  解题思路：
 *  快慢指针。两个指针同时指向链表头节点，慢指针每次走一步，快指针每次走两步。
 *  当快指针为null（偶数个节点）或者next为null（奇数个节点）时，慢指针到达中间节点
 */
import commons.ListNode;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
		/**
		 * 边界条件！！！
		 */
        if(head == null || head.next == null) {
        	return head;
        }
        /**
         * 快慢指针同时指向头部
         */
        ListNode slow = head;
        ListNode fast = head;
        
        /**
         * 当快指针为null（偶数个节点）或者next为null（奇数个节点）时，慢指针到达中间节点
         */
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }
}
