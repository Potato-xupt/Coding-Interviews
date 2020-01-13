	package question07;

import commons.TreeNode;

/**
 * �ؽ�������
 * ��Ŀ����
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * 
 * ����˼·��
 * ��������ĵ�һ��Ԫ�ؾ��Ǹ����ĸ���Ȼ��������������������ҵ����Ԫ�ص�λ�ã����Ԫ��ǰ���Ԫ�ؾ�������������ߵ�Ԫ�ؾ�����������
 * Ȼ��ݹ������������������������������������������������������������
 * @author Potato
 *
 */
public class ReConstructBinaryTree {
	
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 
		 /**
		  * �߽������ж�
		  */
		 if(pre == null || in ==null || pre.length <= 0 || in.length <= 0) {
			 return null;
		 }
		 
		 /**
		  * ������������������
		  */
		 return ConstructCore(pre,in,0,pre.length-1,0,in.length-1);	        
	 }
	 
	 private TreeNode ConstructCore(int [] pre,int [] in ,int preStart,int preEnd,int inStart,int inEnd) {
		 /**
		  * ��������ĵ�һ��Ԫ�ؾ��Ǹ��ڵ�
		  */
		 TreeNode tree = new TreeNode(pre[preStart]);
		 tree.left = null;
		 tree.right = null;
		 
		 /**
		  * �����β��� ��ô��û��������
		  */
		 if(preStart == preEnd && inStart == inEnd){
			 return tree;
		 }
		 
		 /**
		  * ������������Ҹ��ڵ��λ��
		  */
		 int root = 0;
		 for(root = inStart;root <= inEnd;root++) {
			 if(pre[preStart] == in[root]) {			 
				 break;
			 }	
		 }
		 
		 /**
		  * �������������Ⱥ�����������
		  */
		 int leftLength = root - inStart;
		 int rightLength = inEnd - root;
		 
		 /**
		  * �ݹ�����������������������
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
