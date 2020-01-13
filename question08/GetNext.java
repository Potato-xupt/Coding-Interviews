package question08;

import commons.TreeLinkNode;

/**
 * ����������һ�����
 * 
 * ��Ŀ����
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * 
 *����˼·��
 *���жϱ߽�������
 *����ڵ���������������һ���ڵ�����������������ӽڵ�
 *���û�������������жϵ�ǰ�ڵ��Ǹ��ڵ�����ӽڵ㻹�����ӽڵ�
 *��������ӽڵ㣬��ô������һ���ڵ�����丸�ڵ㡣
 *��������ӽڵ㣬�Ǿ������ң���ĳһ���ڵ����丸�ڵ�����ӽڵ�ʱ���丸�ڵ����Ҫ�ҵ���һ���ڵ�
 * @author Potato
 *
 */
public class GetNext {
	
	 public TreeLinkNode getNext(TreeLinkNode pNode){
		 /**
		  * �жϱ߽�����
		  */
	        if(pNode == null) {
	        	return null;
	        }
	        
	        /**
	         * ����ڵ���������������һ���ڵ�����������������ӽڵ�
	         */
	        if(pNode.right != null) {
	        	pNode = pNode.right;
	        	while(pNode.left != null) {
	        		pNode = pNode.left;
	        	}
	        	return pNode;
	        }else {
	        	/**��
	        	 *���û�������������жϵ�ǰ�ڵ��Ǹ��ڵ�����ӽڵ㻹�����ӽڵ�
	        	 *��������ӽڵ㣬��ô������һ���ڵ�����丸�ڵ㡣
	        	 *��������ӽڵ㣬�Ǿ������ң���ĳһ���ڵ����丸�ڵ�����ӽڵ�ʱ���丸�ڵ����Ҫ�ҵ���һ���ڵ�
	        	 */
	        	
	        	while(pNode.next != null) {
	        		if(pNode.next.left == pNode) {
	        			return pNode.next ;
	        		}else {
	        			pNode = pNode.next;	        			
	        		}
	        	}
	        	
	        	/**
	        	 * ����ҵ����ڵ㻹û�оͷ���null
	        	 * 
	        	 */
	        	return null;
	        } 
	 }
}
