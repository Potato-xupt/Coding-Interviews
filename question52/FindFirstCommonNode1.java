package question52;

import commons.ListNode;
/**
 * ��������ĵ�һ��������㣨����һ
 * ��Ŀ����
 * �������������ҳ����ǵĵ�һ��������㡣
 * 
 * ����˼·��
 * �ȷֱ������������ͳ�����ǵĳ���
 * Ȼ����㳤�ȵĲ�ֵ���ó����������߲�ֵ�Ĳ���
 * Ȼ������һ���ߣ���ʱ���ó������������˲�ֵ�Ĳ�������ʱ����������ĺ��泤����һ����
 * ����һ���ߵ�ʱ����߱߶Աȣ�������������ͬ�ľ��ǵ�һ���������
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindFirstCommonNode1 {
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	/**
    	 * �ֱ�ͳ������������ĳ���
    	 */
    	 int length1 = getLength(pHead1);
    	 int length2 = getLength(pHead2);
    	 int lengthDif = 0;
    	 ListNode longHead ;
    	 ListNode shortHead ;
    	 /**
    	  * ��������ȵĲ�ֵ
    	  * ���Ҽ�¼�����ĸ��ǳ��������ĸ��Ƕ̵�����
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
    	  * �ó�����������һ����ֵ�Ĳ���
    	  */
    	 for (int i = 0; i < lengthDif; i++) {
			longHead = longHead.next;
		}
    	 /**
    	  * Ȼ������������һ���ߣ�������ͬ�Ľ����ǹ����㣬
    	  * ���û�й����ڵ㣬��󶼻��ߵ�null��Ҳ���ص���null
    	  */
    	 while(longHead != null && shortHead != null && longHead != shortHead) {
    		 longHead = longHead.next;
    		 shortHead = shortHead.next;
    	 }
    	 return longHead;
    }

    /**
     * ͳ��������
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
