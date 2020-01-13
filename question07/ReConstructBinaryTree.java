	package question07;

import commons.TreeNode;

/**
 * 重建二叉树
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * 解题思路：
 * 先序遍历的第一个元素就是该树的根，然后在中序遍历的数组中找到这个元素的位置，这个元素前面的元素就是左子树，后边的元素就是右子树。
 * 然后递归继续从左子树找树根、找左、右子树；从右子树找树根、找左、右子树。
 * @author Potato
 *
 */
public class ReConstructBinaryTree {
	
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 
		 /**
		  * 边界条件判断
		  */
		 if(pre == null || in ==null || pre.length <= 0 || in.length <= 0) {
			 return null;
		 }
		 
		 /**
		  * 查找树根和左右子树
		  */
		 return ConstructCore(pre,in,0,pre.length-1,0,in.length-1);	        
	 }
	 
	 private TreeNode ConstructCore(int [] pre,int [] in ,int preStart,int preEnd,int inStart,int inEnd) {
		 /**
		  * 先序遍历的第一个元素就是根节点
		  */
		 TreeNode tree = new TreeNode(pre[preStart]);
		 tree.left = null;
		 tree.right = null;
		 
		 /**
		  * 如果首尾相等 那么就没有子树。
		  */
		 if(preStart == preEnd && inStart == inEnd){
			 return tree;
		 }
		 
		 /**
		  * 在中序遍历中找根节点的位置
		  */
		 int root = 0;
		 for(root = inStart;root <= inEnd;root++) {
			 if(pre[preStart] == in[root]) {			 
				 break;
			 }	
		 }
		 
		 /**
		  * 计算左子树长度和右子树长度
		  */
		 int leftLength = root - inStart;
		 int rightLength = inEnd - root;
		 
		 /**
		  * 递归找左子树、右子树。。。
		  * 
		  */
		 if(leftLength > 0) {
			 tree.left = ConstructCore(pre,in,preStart+1,preStart + leftLength,inStart,root-1);
		 }
		 if(rightLength > 0) {
			 tree.right = ConstructCore(pre,in,preStart + leftLength + 1,preEnd,root + 1,inEnd);
		 }
		 
		 return tree;
		  
		  
	 }
	 
}
