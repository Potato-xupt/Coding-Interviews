package question18;

import commons.ListNode;

/**
 * 在O(1)时间内删除链表的节点
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该 结点。 
 * 
 * 解题思路：
 * 判断三种情况：
 * 1.首节点或者要删除节点为空时，直接return；
 * 2. 如果要删除的节点不为空时，则按正常方法删除，把要删除的节点的next节点复制给当前节点，next会自动被gc回收
 * 3.要删除的节点为尾节点，所以应该从头开始遍历，找到其前序节点，然后将其删除
 * @author Potato
 *
 */
public class DeleteNode {
	public void deleteNode ( ListNode head,ListNode node) {
		/**
		 * 首节点或者要删除节点为空时
		 */
		if(head == null || node == null) {
			return;
		}
		
		/**
		 * 如果要删除的节点不为空时，则按正常方法删除
		 */
		if(node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
		
		/**
		 * 如果头节点和尾节点相等时，都置为null
		 */
		if(head == node) {
			head = node =null;
			return ;
		}else {
			/**
			*要删除的节点为尾节点，所以应该从头开始遍历，找到其前序节点，然后将其删除
			*/
			ListNode l = head;
			while(l.next != node) {
				l = l.next;
			}
			node = null;
			l.next = null;			
			
		}
    }
}
