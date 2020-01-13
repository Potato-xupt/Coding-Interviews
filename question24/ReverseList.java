package question24;

import commons.ListNode;
/**
 * ��ת����
 * ��Ŀ����
 * ����һ��������ת��������������ı�ͷ��
 * 
 * ����˼·:
 * 
 * ��¼��ǰ�ڵ�node����һ�����Ϊnext�����nextΪnull����ô�����Ƿ�ת����׽ڵ㡣
 * ��node.nextָ������ǰһ�����pre��Ȼ���node����pre��node.next����node
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
