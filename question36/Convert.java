package question36;

import commons.TreeNode;
/**
 * 二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * 解题思路：
 * 按照中序递归遍历中，当我们遍历转换到根结点时，它的左子树已经转换成了一个排序的链表，并且此时链表尾部的值为左子树中值最大的结点的值。
 * 我们将它和根结点链接起来，此时根结点变成了链表尾部，
 * 接着去遍历右子树，我们知道中序遍历根结点后的一个结点此时为右子树值最小的结点，
 * 我们将它和根结点链接起来。左右子树再用这样的办法，即递归即可解决问题。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Convert {
	/**
	 * node：当前节点
	 * head：头节点
	 */
	TreeNode node = null;
	TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	/**
    	 * 判断边界条件
    	 */
        if(pRootOfTree == null) {
        	return null;
        }
        /**
         * 遍历左子树
         */
        Convert(pRootOfTree.left);
        
        if(node == null) {
        	/**
             * 根节点赋值
             */
        	node = pRootOfTree;
        	head = pRootOfTree;
        }else {
        	/**
        	 * 建立双向链表
        	 */
        	node.right = pRootOfTree;
        	pRootOfTree.left = node;
        	node = pRootOfTree;
        }
        /**
         * 遍历右子树
         */
        Convert(pRootOfTree.right);
        return head;
    }
}
