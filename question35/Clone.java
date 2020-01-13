package question35;

import commons.RandomListNode;
/**
 * 复杂链表的复制
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * 解题思路：
 * 分三步：
 * 1：复制每个节点，把复制的结点放到原结点的后面。
 * 原链表：A-->B-->C-->D
 * 复制后的链表：A-->A`-->B-->B`-->C-->C`-->D-->D`
 * 
 * 2：把复制的结点的random指向相对应的结点。
 * 例如原A节点的random指向C，则复制后的A`指向C`
 * 
 * 3：拆分两个链表即可
 * 
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Clone {
	
    public RandomListNode Clone(RandomListNode pHead){
    	/**
    	 * 判断边界条件
    	 */
    	if(pHead == null) {
    		return null;
    	}
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

    /**
     * 1：复制每个节点，把复制的结点放到原结点的后面。
     * @param pHead
     */
	private void CloneNodes(RandomListNode pHead) {
		RandomListNode node  = pHead;
		while(node != null) {
			/**
			 * 新建复制结点，复制node，
			 */
			RandomListNode clone = new RandomListNode(node.label);
			clone.next = node.next;
			/**
			 * node的next指向复制的结点，node继续后移循环复制
			 */
			node.next = clone;
			node = clone.next;
		}		
	}
	
	/**
	 * 把复制节点的random指向相对应的结点
	 * @param pHead
	 */
	private void ConnectRandomNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		while(node != null) {
			RandomListNode clone = node.next;
			/**
			 * 如果原结点的random不为空，则把原结点的random的下一个（也就是原结点的random的复制节点）赋给复制节点的random
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
		 * 新建复制链表的表头
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
