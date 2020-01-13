package question18;

/**
 * 删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 遍历节点的同时判断当前节点与下一个节点是否相同，如果相同则删除，
 * 删除方法  使用相同节点的前一个节点，指向相同节点的下一个节点如图
 * @author Potato
 */

import commons.ListNode;

public class DeleteDuplication {
	public ListNode deleteDuplication(ListNode pHead){
		if(pHead == null) {
			return null;
		}
		/**
		 * first为备用头节点，以免头节点被删除。
		 */
		ListNode first = new ListNode(-1);
		first.next = pHead;
		ListNode p = pHead;
		/**
		 * 前节点
		 */
		ListNode preNode = first;
		
		/**
		 * 遍历节点
		 */
		while(p!=null && p.next != null) {
			/**
			 * 如果遇到重复的节点
			 */
			if(p.val == p.next.val) {
				/**
				 * 记录重复的值，然后向后寻找并且删除，直到不重复为止
				 */
				int val = p.val;
				while(p != null && p.val == val) {
					p = p.next;
				}
				/**
				 * 把第一个不重复的节点作为前节点的下一节点，中间重复的节点已经被删除
				 */
				preNode.next = p;
			}else {
				/**
				 * 不重复则继续寻找遍历
				 */
				preNode = p;
				p = p.next;
			}
		}
		return first.next;
    }
}
