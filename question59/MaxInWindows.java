package question59;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
/**
 * �������ڵ����ֵ
 * ��Ŀ����
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 *  �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 *  
 *  ����˼·��
 *  ʹ��˫�˶��У�������������ǻ����������ֵ�����ֵ��±�
 *  ÿ��ѭ��ʱ���Ѷ���β�����бȵ�ǰֵС������ȫ���Ƴ�ȥ��Ȼ��ѵ�ǰֵ���±���룬����ÿ�δӶ���ͷ���õ���ֵ�������ֵ
 *  
 * @author Potato
 *
 */
public class MaxInWindows {
	
    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	/**
    	 * �жϱ߽�����
    	 */
        if(num == null || num.length <= 0 || size > num.length || size < 1) {
        	return new ArrayList<Integer>();
        }
        /**
         * 	һ��˫�˶��д洢���ֵ
         * 	һ�����ϴ�Ž��
         */
        Deque<Integer> index = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        /**
         * 	���߻������ڵĳ��ȣ���size�����ڵ����ֵ���������õ������ֵ������˫�˶���
         */
        for (int i = 0; i < size; i++) {
        	/**
        	 * �����ǰ���ִ��ڶ���β�������֣���ô�Ͱ�β�������бȵ�ǰ����С�Ķ��Ӷ���ɾ��
        	 */
			while(!index.isEmpty() && num[i] >= num[index.peekLast()]) {
				index.removeLast();
			}
			/**
			 * Ȼ��ѵ�ǰ���ַ������β��
			 */
			index.addLast(i);
		}
        
        /**
         * 	��ʽ��ʼ����
         */
        for (int i = size; i < num.length; i++) {
        	/**
        	 * ��Ϊ��һ���Ѿ���size���ȵĻ����������ֵ��������ײ��ˣ�
        	 * ��������ֱ�ӰѶ����ײ���ֵ���ǵ�ǰ���ڵ����ֵ��������������
        	 */
			result.add(num[index.peek()]);
			
			/**
			 * �����ǰ���ִ��ڶ���β�������֣���ô�Ͱ�β�������бȵ�ǰ����С�Ķ��Ӷ���ɾ��
			 */
			while(!index.isEmpty() && num[i] >= num[index.peekLast()] ) {
				index.removeLast();
			}
			/**
			 * ��������ײ��������Ѿ����ڵ�ǰ���������ˣ����԰����Ӷ�����ɾ��
			 */
			if(!index.isEmpty() && index.peekFirst() <= i-size) {
				index.removeFirst();
			}
			/**
			 * Ȼ��ѵ�ǰ���ַ������β��
			 */
			index.addLast(i);
		}
        
        /**
         * 	�����һ���������ڵ����ֵ����������
         */
        result.add(num[index.peek()]);
        
        return result;
    }
}
