package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import commons.TreeNode;
/**
 * 把二叉树打印成多行
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 解题思路：
 * 大致同从上往下打印二叉树一样，只是在每一次while循环开始的时候，记录当前队列中结点的数量，因为这个数量就是该树这一层结点的数量。
 * @author Potato
 *
 */

public class PrintByLine {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	/**
    	 * 先判断边界条件，避免树为null，
    	 * 树为null时返回一个空的ArrayList
    	 */
    	ArrayList<ArrayList<Integer> > result = new ArrayList<>();
    	if(pRoot == null) {
    		return result;
    	}
    	/**
         * 先把根节点放入队列
         */
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(pRoot);
    	while(!queue.isEmpty()) {
    		/**
    		 * 记录当前结点的数量
    		 * 这个数量就是该树这一层结点的数量。
    		 * 把这一层结点的值全部放入List中，再放入result中
    		 */
    		int size = queue.size();
    		ArrayList<Integer> temp = new ArrayList<>();
    		for (int i = 0; i < size; i++) {
    			/**
            	 * 从队列中去除结点，把该节点放入结果的ArrayList（模拟输出）
            	 */
				TreeNode node = queue.poll();
				temp.add(node.val);
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
    		result.add(temp);
    	}
    	return result;
    	
    }
}
