package question23;

import commons.ListNode;

/**
 * 链表中环的入口结点
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * 解题思路：
 * 本题可扩展的有三种问法：是否有环，环的长度，环的入口结点
 * 是否有环：快慢指针，快指针每次走两步，慢指针每次走一步，能相遇则有环，遇到null则无环。
 * 环的长度：从相遇节点继续走，每次走一步，再次走到相遇节点的步数就是环的长度。
 * 环的入口结点：一个指针指向从链表头部，另一个在相遇节点，两个同时开始走，直到相遇时的节点就是入口节点。
 * 
 * @author Potato
 *
 */
public class EntryNodeOfLoop {
	
	public ListNode entryNodeOfLoop(ListNode pHead) {
		/**
		 * 先确定有无环
		 */
        ListNode meet = isCycle(pHead);
        if(meet == null) {
        	return null;
        }
        /**
         * 一个指针指向从链表头部
         */
        ListNode head = pHead;
        /**
         * 另一个在相遇节点，两个同时开始走，直到相遇时的节点就是入口节点。
         */
        while(head != meet) {
        	head = head.next;
        	meet = meet.next;
        }
        return head;
        
    }
	
	/**
	 * 判断是否有环
	 * @param pHead
	 * @return
	 */
	public ListNode isCycle(ListNode pHead) {
		/**
		 * 边界条件
		 */
		if(pHead == null || pHead.next == null) {
			return null;
		}
		/**
		 * 快慢指针同时指向首部
		 */
        ListNode slow = pHead;
        ListNode fast = pHead;
        /**
         * 快指针每次走两步，慢指针每次走一步
         * 能相遇则有环，遇到null则无环。
         */
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if(slow == fast) {
        		return fast;
        	}
        }
        return null;
    }
	
	/***
	 * 环的长度
	 * @param meet
	 * @return
	 */
	public int LoopCount(ListNode meet) {
		
	      int LoopCount = 1;
	      
	      /**
	       * 从相遇节点继续走，每次走一步，再次走到相遇节点的步数就是环的长度。
	       */
	      ListNode node = meet; 
	      while(node.next != meet) {
	      	node = node.next;
	      	LoopCount++;
	      }
	      return LoopCount;

	}
	
}
