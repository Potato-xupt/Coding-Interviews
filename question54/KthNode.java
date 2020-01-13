package question54;

import commons.TreeNode;
/**
 * �����������ĵ�k�����
 * ��Ŀ����
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 * 
 * ����˼·��
 * ���ö���������������������ص㡣
 * ��������Ľ�����Ǵ�С�����˳��
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class KthNode {
	private int count = 0;
	private TreeNode result; 
	
	public TreeNode KthNode(TreeNode pRoot, int k){
       inOrder(pRoot,k);
       return result;
    }

	private void inOrder(TreeNode pRoot, int k) {
		/**
		 * �߽������ж�
		 */
		if(pRoot == null || count >= k) {
			return ;
		}
		/**
		 * �����������������
		 */
		inOrder(pRoot.left,k);
		/**
		 * ��������kС���ǵ�k���ڵ�
		 */
		if(++count == k) {
			result = pRoot;
		}
		inOrder(pRoot.right,k);	
	}

}
