package question25;

import commons.ListNode;
/**
 * 合并两个排序的链表
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author Potato
 *
 */
public class Merge {
	
	/**
	 * 递归方法
	 * 平均耗时：25ms（不稳定）
	 * @param list1
	 * @param list2
	 * @return
	 */
	 public ListNode merge(ListNode list1,ListNode list2) {
		 /**
		  * 边界条件
		  */
	        if(list1 == null){
	            return list2;
	        }
	        if(list2 == null){
	            return list1;
	        }
	        /**
	         * 合并后的头节点
	         */
	        ListNode MergeHead = null;
	        /**
	         * 递归
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
	  * 非递归方法
	  * 平均耗时：22ms
	  * @param list1
	  * @param list2
	  * @return
	  */
	 public ListNode merge2(ListNode list1,ListNode list2) {
		 /**
		  * 边界条件
		  */
		 if(list1 == null) {
			 return list2;
		 }
		 if(list2 == null) {
			 return list1;
		 }
		 /**
	         * 合并后的头节点
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
		  * 哪个小就把哪个排到node后面
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
		  * 把剩下没排完的部分全排到node后面
		  */
		 if(list1 == null) {
			 node.next = list2;
		 }else {
			 node.next = list1;
		 }
		 return mergeHead;
	 }
	 
}
