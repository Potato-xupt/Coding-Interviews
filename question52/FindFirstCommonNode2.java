package question52;

import commons.ListNode;
/**
 * 两个链表的第一个公共结点（方法二
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * 解题思路：
 * 
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 * 
 * 自己画两个链表比较一下就知道了，
 * 但是此方法的缺点是，如果两个链表没有公共节点的话就会一直循环下去
 * @author Potato
 *
 */
public class FindFirstCommonNode2 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	ListNode l1 = pHead1;
    	ListNode l2 = pHead2;
    	 while(l1 != l2){
    		 /**
    		  * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
    		  */
    		 l1 = l1==null?pHead2:l1.next;
    		 /**
    		  * 当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
    		  */
    		 l2 = l2==null?pHead1:l2.next;
    	 }
    	 return l1;
    }

}
