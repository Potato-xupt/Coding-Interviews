package question23;

import commons.ListNode;

/**
 * �����л�����ڽ��
 * ��Ŀ����
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
 * 
 * ����˼·��
 * �������չ���������ʷ����Ƿ��л������ĳ��ȣ�������ڽ��
 * �Ƿ��л�������ָ�룬��ָ��ÿ������������ָ��ÿ����һ�������������л�������null���޻���
 * ���ĳ��ȣ��������ڵ�����ߣ�ÿ����һ�����ٴ��ߵ������ڵ�Ĳ������ǻ��ĳ��ȡ�
 * ������ڽ�㣺һ��ָ��ָ�������ͷ������һ���������ڵ㣬����ͬʱ��ʼ�ߣ�ֱ������ʱ�Ľڵ������ڽڵ㡣
 * 
 * @author Potato
 *
 */
public class EntryNodeOfLoop {
	
	public ListNode entryNodeOfLoop(ListNode pHead) {
		/**
		 * ��ȷ�����޻�
		 */
        ListNode meet = isCycle(pHead);
        if(meet == null) {
        	return null;
        }
        /**
         * һ��ָ��ָ�������ͷ��
         */
        ListNode head = pHead;
        /**
         * ��һ���������ڵ㣬����ͬʱ��ʼ�ߣ�ֱ������ʱ�Ľڵ������ڽڵ㡣
         */
        while(head != meet) {
        	head = head.next;
        	meet = meet.next;
        }
        return head;
        
    }
	
	/**
	 * �ж��Ƿ��л�
	 * @param pHead
	 * @return
	 */
	public ListNode isCycle(ListNode pHead) {
		/**
		 * �߽�����
		 */
		if(pHead == null || pHead.next == null) {
			return null;
		}
		/**
		 * ����ָ��ͬʱָ���ײ�
		 */
        ListNode slow = pHead;
        ListNode fast = pHead;
        /**
         * ��ָ��ÿ������������ָ��ÿ����һ��
         * ���������л�������null���޻���
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
	 * ���ĳ���
	 * @param meet
	 * @return
	 */
	public int LoopCount(ListNode meet) {
		
	      int LoopCount = 1;
	      
	      /**
	       * �������ڵ�����ߣ�ÿ����һ�����ٴ��ߵ������ڵ�Ĳ������ǻ��ĳ��ȡ�
	       */
	      ListNode node = meet; 
	      while(node.next != meet) {
	      	node = node.next;
	      	LoopCount++;
	      }
	      return LoopCount;

	}
	
}
