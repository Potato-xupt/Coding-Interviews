package question32;

import java.util.ArrayList;
import java.util.Stack;

import commons.TreeNode;
/**
 * 按之字形顺序打印二叉树
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * 解题思路：
 * 用两个栈A 和 B，在打印某一层的节点（A栈）时，把下一层的结点保存到另一个栈（B栈）里，下一次循环则遍历另一个栈（B栈），把另一个栈的结点保存到A栈中。
 * 遍历奇数层先放左节点，再放右节点。
 * 遍历偶数层先放右节点，再放左节点。
 * @author Potato
 *
 */
public class PrintByZ {

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
    	 * 创建两个栈，分别用来遍历奇数层和偶数层
         * 先把根节点放入奇数层栈中
         */
    	Stack<TreeNode> odd = new Stack<>();
    	Stack<TreeNode> even = new Stack<>();
    	odd.push(pRoot);
    	/**
    	 * 当两个栈都为空时，循环结束
    	 * 两个栈必有一个为空，所以就遍历不为空的那个，把子元素放入为空的那个
    	 */
    	while(!odd.isEmpty() || !even.isEmpty()) {
    		ArrayList<Integer> temp = new ArrayList<>();
    		/**
    		 * 遍历奇数层栈
    		 */
    		if(!odd.isEmpty()) {
    			while(!odd.isEmpty()) {
    				TreeNode node = odd.pop();
    				temp.add(node.val);
    				/**
    	        	 * 判断左右子树是否为空，不为空则放入队列中。
    	        	 * 因为遍历的是奇数层，所以
    	        	 * 先放左子树，再放右子树
    	        	 */
    				if(node.left != null) {
    					even.push(node.left);
    				}
    				if(node.right != null) {
    					even.push(node.right);
    				}
    			}
    		}else {
    			/**
        		 * 遍历偶数层栈
        		 */
    			while(!even.isEmpty()) {
    				TreeNode node = even.pop();
    				temp.add(node.val);
    				/**
    	        	 * 判断左右子树是否为空，不为空则放入队列中。
    	        	 * 因为遍历的是偶数层，所以
    	        	 * 先放右子树，再放左子树
    	        	 */
    				if(node.right != null) {
    					odd.push(node.right);
    				}
    				if(node.left != null) {
    					odd.push(node.left);
    				}
    			}
    		}
    		result.add(temp);
    	}
    	return result;
    }
}
