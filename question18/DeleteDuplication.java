package question18;

/**
 * ɾ���������ظ��Ľ��
 * ��Ŀ����
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * 
 * �����ڵ��ͬʱ�жϵ�ǰ�ڵ�����һ���ڵ��Ƿ���ͬ�������ͬ��ɾ����
 * ɾ������  ʹ����ͬ�ڵ��ǰһ���ڵ㣬ָ����ͬ�ڵ����һ���ڵ���ͼ
 * @author Potato
 */

import commons.ListNode;

public class DeleteDuplication {
	public ListNode deleteDuplication(ListNode pHead){
		if(pHead == null) {
			return null;
		}
		/**
		 * firstΪ����ͷ�ڵ㣬����ͷ�ڵ㱻ɾ����
		 */
		ListNode first = new ListNode(-1);
		first.next = pHead;
		ListNode p = pHead;
		/**
		 * ǰ�ڵ�
		 */
		ListNode preNode = first;
		
		/**
		 * �����ڵ�
		 */
		while(p!=null && p.next != null) {
			/**
			 * ��������ظ��Ľڵ�
			 */
			if(p.val == p.next.val) {
				/**
				 * ��¼�ظ���ֵ��Ȼ�����Ѱ�Ҳ���ɾ����ֱ�����ظ�Ϊֹ
				 */
				int val = p.val;
				while(p != null && p.val == val) {
					p = p.next;
				}
				/**
				 * �ѵ�һ�����ظ��Ľڵ���Ϊǰ�ڵ����һ�ڵ㣬�м��ظ��Ľڵ��Ѿ���ɾ��
				 */
				preNode.next = p;
			}else {
				/**
				 * ���ظ������Ѱ�ұ���
				 */
				preNode = p;
				p = p.next;
			}
		}
		return first.next;
    }
}
