package question35;

import commons.RandomListNode;
/**
 * ��������ĸ���
 * ��Ŀ����
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * ����˼·��
 * ��������
 * 1������ÿ���ڵ㣬�Ѹ��ƵĽ��ŵ�ԭ���ĺ��档
 * ԭ����A-->B-->C-->D
 * ���ƺ������A-->A`-->B-->B`-->C-->C`-->D-->D`
 * 
 * 2���Ѹ��ƵĽ���randomָ�����Ӧ�Ľ�㡣
 * ����ԭA�ڵ��randomָ��C�����ƺ��A`ָ��C`
 * 
 * 3���������������
 * 
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Clone {
	
    public RandomListNode Clone(RandomListNode pHead){
    	/**
    	 * �жϱ߽�����
    	 */
    	if(pHead == null) {
    		return null;
    	}
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

    /**
     * 1������ÿ���ڵ㣬�Ѹ��ƵĽ��ŵ�ԭ���ĺ��档
     * @param pHead
     */
	private void CloneNodes(RandomListNode pHead) {
		RandomListNode node  = pHead;
		while(node != null) {
			/**
			 * �½����ƽ�㣬����node��
			 */
			RandomListNode clone = new RandomListNode(node.label);
			clone.next = node.next;
			/**
			 * node��nextָ���ƵĽ�㣬node��������ѭ������
			 */
			node.next = clone;
			node = clone.next;
		}		
	}
	
	/**
	 * �Ѹ��ƽڵ��randomָ�����Ӧ�Ľ��
	 * @param pHead
	 */
	private void ConnectRandomNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		while(node != null) {
			RandomListNode clone = node.next;
			/**
			 * ���ԭ����random��Ϊ�գ����ԭ����random����һ����Ҳ����ԭ����random�ĸ��ƽڵ㣩�������ƽڵ��random
			 */
			if(node.random != null) {
				clone.random = node.random.next;
			}
			node = clone.next;
		}
	}
	

	private RandomListNode ReconnectNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		/**
		 * �½���������ı�ͷ
		 */
		RandomListNode cloneHead = node.next;
		RandomListNode cloneNode = node.next;
		node.next = cloneNode.next;
		node = node.next;
		
		while(node != null) {
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		return cloneHead;
	}
}
