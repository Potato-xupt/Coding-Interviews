package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import commons.TreeNode;
/**
 * 从上往下打印二叉树
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解题思路：
 * 使用队列，遍历某个结点时，把该节点的子节点放入队列，然后继续从队列中取出节点，输出该节点的值，继续把该节点的子节点放入队列，循环即可。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class PrintFromTopToBottom {
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<>();
    	/**
    	 * 先判断边界条件，避免树为null，
    	 * 树为null时返回一个空的ArrayList
    	 */
        if(root == null) {
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 先把根节点放入队列
         */
        queue.add(root);
        while(!queue.isEmpty()) {
        	/**
        	 * 从队列中去除结点，把该节点放入结果的ArrayList（模拟输出）
        	 */
        	TreeNode node = queue.poll();
        	result.add(node.val);
        	/**
        	 * 判断左右子树是否为空，不为空则放入队列中。
        	 */
        	if(node.left != null) {
        		queue.add(node.left);
        	}
        	if(node.right != null) {
        		queue.add(node.right);
        	}
        }
        return result;
    }
}
