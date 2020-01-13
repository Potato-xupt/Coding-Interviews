package question08;

import commons.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * 
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 *解题思路：
 *先判断边界条件。
 *如果节点有右子树，则下一个节点就是右子树的最左子节点
 *如果没有右子树，则判断当前节点是父节点的左子节点还是右子节点
 *如果是左子节点，那么他的下一个节点就是其父节点。
 *如果是右子节点，那就向上找，当某一个节点是其父节点的左子节点时，其父节点就是要找的下一个节点
 * @author Potato
 *
 */
public class GetNext {
	
	 public TreeLinkNode getNext(TreeLinkNode pNode){
		 /**
		  * 判断边界条件
		  */
	        if(pNode == null) {
	        	return null;
	        }
	        
	        /**
	         * 如果节点有右子树，则下一个节点就是右子树的最左子节点
	         */
	        if(pNode.right != null) {
	        	pNode = pNode.right;
	        	while(pNode.left != null) {
	        		pNode = pNode.left;
	        	}
	        	return pNode;
	        }else {
	        	/**、
	        	 *如果没有右子树，则判断当前节点是父节点的左子节点还是右子节点
	        	 *如果是左子节点，那么他的下一个节点就是其父节点。
	        	 *如果是右子节点，那就向上找，当某一个节点是其父节点的左子节点时，其父节点就是要找的下一个节点
	        	 */
	        	
	        	while(pNode.next != null) {
	        		if(pNode.next.left == pNode) {
	        			return pNode.next ;
	        		}else {
	        			pNode = pNode.next;	        			
	        		}
	        	}
	        	
	        	/**
	        	 * 最后找到根节点还没有就返回null
	        	 * 
	        	 */
	        	return null;
	        } 
	 }
}
