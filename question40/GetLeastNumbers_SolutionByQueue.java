package question40;

import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 *��С��K������O(NlogK)ʱ�临�ӶȽⷨ���ʺϴ��������ݣ�
 * ��Ŀ����
 * ����n���������ҳ�������С��K������
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * ����˼·��
 * ά��һ����СΪ K ����С�ѹ������£������һ��Ԫ��֮������󶥶ѵĴ�С���� K����ô��Ҫ���󶥶ѵĶѶ�Ԫ��ȥ����
 * @author Potato
 *
 */
public class GetLeastNumbers_SolutionByQueue {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		/**
		 * �жϱ߽�����
		 */
		if(input == null || input.length <= 0 || k > input.length || k <= 0) {
			return new ArrayList<Integer>();
		}
		/**
		 * �������ȶ�����Ϊ�󶥶�
		 */
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		/**
		 * �������������е�Ԫ��
		 */
		for (int i = 0; i < input.length; i++) {
			/**
			 * ��Ԫ����ӵ��󶥶���
			 */
			maxHeap.add(input[i]);
			/**
			 * ����󶥶��е�Ԫ����������k���Ͱ�����Ԫ���Ƴ���
			 */
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return new ArrayList<Integer>(maxHeap);
		
    }
}
