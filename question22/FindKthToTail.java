package question22;

import commons.ListNode;

/**
 * �����е�����k�����
 * ��Ŀ����
 * ����һ����������������е�����k����㡣
 * 
 * ����˼·��
 * ˫ָ�뷨������ָ��ͬʱָ��ͷ�ڵ㣬����ǰһ��ָ����k-1����Ȼ������һ���ߣ���ǰһ��ָ���ߵ�����β����ʱ�򣬺�һ�������ڵ�����k������λ��
 * @author Potato
 *
 */
public class FindKthToTail {
	
	public ListNode findKthToTail(ListNode head,int k) {
		/**
		 * �߽���������������׳��
		 */
		if(head == null || k <= 0) {
			return null;
		}
		
		/**
		 * ǰһ��ָ�룬��k-1���������ж��������Ƿ�ﵽk������û�е�����k����㣬����null��
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
		 * ��һ��ָ��Ҳָ��ͷ�ڵ㣬����һ���ߣ�Ȼ��befor�ߵ�β����after���ﵹ����k���ڵ�
		 */
		ListNode after = head;
		while(befor.next != null) {
			befor = befor.next; 
			after = after.next;
		}
		return after;
    }

}
