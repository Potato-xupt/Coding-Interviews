package question18;

import commons.ListNode;

/**
 * ��O(1)ʱ����ɾ������Ľڵ�
 * �������������ͷָ���һ�����ָ�룬����һ��������O(1)ʱ��ɾ���� ��㡣 
 * 
 * ����˼·��
 * �ж����������
 * 1.�׽ڵ����Ҫɾ���ڵ�Ϊ��ʱ��ֱ��return��
 * 2. ���Ҫɾ���Ľڵ㲻Ϊ��ʱ������������ɾ������Ҫɾ���Ľڵ��next�ڵ㸴�Ƹ���ǰ�ڵ㣬next���Զ���gc����
 * 3.Ҫɾ���Ľڵ�Ϊβ�ڵ㣬����Ӧ�ô�ͷ��ʼ�������ҵ���ǰ��ڵ㣬Ȼ����ɾ��
 * @author Potato
 *
 */
public class DeleteNode {
	public void deleteNode ( ListNode head,ListNode node) {
		/**
		 * �׽ڵ����Ҫɾ���ڵ�Ϊ��ʱ
		 */
		if(head == null || node == null) {
			return;
		}
		
		/**
		 * ���Ҫɾ���Ľڵ㲻Ϊ��ʱ������������ɾ��
		 */
		if(node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
		
		/**
		 * ���ͷ�ڵ��β�ڵ����ʱ������Ϊnull
		 */
		if(head == node) {
			head = node =null;
			return ;
		}else {
			/**
			*Ҫɾ���Ľڵ�Ϊβ�ڵ㣬����Ӧ�ô�ͷ��ʼ�������ҵ���ǰ��ڵ㣬Ȼ����ɾ��
			*/
			ListNode l = head;
			while(l.next != node) {
				l = l.next;
			}
			node = null;
			l.next = null;			
			
		}
    }
}
