package question22;

/**
 *  ������м���
 *  ��Ŀ����
 *  ����һ������ͷ��� head �ķǿյ���������������м��㡣
 *  ����������м��㣬�򷵻صڶ����м��㡣
 *  
 *  ����˼·��
 *  ����ָ�롣����ָ��ͬʱָ������ͷ�ڵ㣬��ָ��ÿ����һ������ָ��ÿ����������
 *  ����ָ��Ϊnull��ż�����ڵ㣩����nextΪnull���������ڵ㣩ʱ����ָ�뵽���м�ڵ�
 */
import commons.ListNode;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
		/**
		 * �߽�����������
		 */
        if(head == null || head.next == null) {
        	return head;
        }
        /**
         * ����ָ��ͬʱָ��ͷ��
         */
        ListNode slow = head;
        ListNode fast = head;
        
        /**
         * ����ָ��Ϊnull��ż�����ڵ㣩����nextΪnull���������ڵ㣩ʱ����ָ�뵽���м�ڵ�
         */
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }
}
