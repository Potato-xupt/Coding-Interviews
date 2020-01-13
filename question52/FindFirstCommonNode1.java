package question52;

import commons.ListNode;
/**
 * 两个链表的第一个公共结点（方法一
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * 解题思路：
 * 先分别遍历两个链表，统计他们的长度
 * 然后计算长度的差值，让长的链表先走差值的步数
 * 然后两个一起走，这时候让长的链表先走了差值的步数，这时候两个链表的后面长度是一样的
 * 所以一起走的时候边走边对比，如果遇到结点相同的就是第一个公共结点
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindFirstCommonNode1 {
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	/**
    	 * 分别统计连两个链表的长度
    	 */
    	 int length1 = getLength(pHead1);
    	 int length2 = getLength(pHead2);
    	 int lengthDif = 0;
    	 ListNode longHead ;
    	 ListNode shortHead ;
    	 /**
    	  * 计算出长度的差值
    	  * 并且记录下来哪个是长的链表，哪个是短的链表
    	  */
    	 if(length1 > length2) {
    		 lengthDif = length1 - length2;
    		 longHead = pHead1;
    		 shortHead = pHead2;
    	 }else {
    		 lengthDif = length2 - length1;
    		 longHead = pHead2;
    		 shortHead = pHead1;
    	 }
    	 /**
    	  * 让长的链表先走一个差值的步数
    	  */
    	 for (int i = 0; i < lengthDif; i++) {
			longHead = longHead.next;
		}
    	 /**
    	  * 然后让两个链表一起走，遇到相同的结点就是公告结点，
    	  * 如果没有公共节点，最后都会走到null，也反回的是null
    	  */
    	 while(longHead != null && shortHead != null && longHead != shortHead) {
    		 longHead = longHead.next;
    		 shortHead = shortHead.next;
    	 }
    	 return longHead;
    }

    /**
     * 统计链表长度
     * @param pHead
     * @return
     */
	private int getLength(ListNode pHead) {
		int length = 0;
		ListNode node = pHead;
		while(node != null) {
			node= node.next;
			length++;
		}
		return length;
	}
}
