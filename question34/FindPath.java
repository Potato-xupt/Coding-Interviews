package question34;

import java.util.ArrayList;

import commons.TreeNode;
/**
 * 二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * 解题思路：
 * 递归，把走过的路径放入一个数组中，判断当前结点是否为叶节点，如果是且达到目标值target，则这个数组为一条符合的路径。
 * 如果这个结点不符合要求，就把递归到其左右节点。
 * 如果到达叶子还不符合，就把该节点从路径中移除，回到它的上一个路径，递归别的路径
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindPath {
	
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		/**
		 * 如果根节点为空，直接返回空的ArrayList
		 */
		if(root == null) {
			return result;
		}
		FindPathCore(root,target,new ArrayList<Integer>());
		return result;
	}
	private void FindPathCore(TreeNode root, int target, ArrayList<Integer> path) {
		path.add(root.val);
		target -= root.val;
		if(target == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(path));
		}else {
			if(root.left != null) {
				FindPathCore(root.left,target,path);
			}
			if(root.right != null) {
				FindPathCore(root.right,target,path);		
			}	
		}
		path.remove(path.size()-1);
	}
}
