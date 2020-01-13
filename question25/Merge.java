package question25;

import commons.ListNode;
/**
 * �ϲ��������������
 * ��Ŀ����
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author Potato
 *
 */
public class Merge {
	
	/**
	 * �ݹ鷽��
	 * ƽ����ʱ��25ms�����ȶ���
	 * @param list1
	 * @param list2
	 * @return
	 */
	 public ListNode merge(ListNode list1,ListNode list2) {
		 /**
		  * �߽�����
		  */
	        if(list1 == null){
	            return list2;
	        }
	        if(list2 == null){
	            return list1;
	        }
	        /**
	         * �ϲ����ͷ�ڵ�
	         */
	        ListNode MergeHead = null;
	        /**
	         * �ݹ�
	         */
	        if(list1.val < list2.val) {
	        	MergeHead = list1;
	        	MergeHead.next = merge(list1.next,list2);
	        	return MergeHead;
	        }else {
	        	MergeHead = list2;
	        	MergeHead.next = merge(list1,list2.next);
	        	return MergeHead;
	        }	        
	 }
	 
	 /**
	  * �ǵݹ鷽��
	  * ƽ����ʱ��22ms
	  * @param list1
	  * @param list2
	  * @return
	  */
	 public ListNode merge2(ListNode list1,ListNode list2) {
		 /**
		  * �߽�����
		  */
		 if(list1 == null) {
			 return list2;
		 }
		 if(list2 == null) {
			 return list1;
		 }
		 /**
	         * �ϲ����ͷ�ڵ�
	         */
		 ListNode mergeHead;
		 if(list1.val < list2.val) {
			 mergeHead = list1;
			 list1 = list1.next;
		 }else {
			 mergeHead = list2;
			 list2 = list2.next;
		 }
		 
		 ListNode node = mergeHead;
		 /**
		  * �ĸ�С�Ͱ��ĸ��ŵ�node����
		  */
		 while(list1 != null && list2 != null) {
			 if(list1.val < list2.val) {
				 node.next = list1;
				 node = node.next;
				 list1 = list1.next;
			 }else {
				 node.next = list2;
				 node = node.next;
				 list2 = list2.next;
			 }
		 }
		 /**
		  * ��ʣ��û����Ĳ���ȫ�ŵ�node����
		  */
		 if(list1 == null) {
			 node.next = list2;
		 }else {
			 node.next = list1;
		 }
		 return mergeHead;
	 }
	 
}
