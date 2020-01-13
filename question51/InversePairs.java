package question51;
/**
 * �����е������
 * ��Ŀ����
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
 * 
 * ʾ��1
 * ����1,2,3,4,5,6,7,0
 * ���7
 * 
 * ����˼·
 * �鲢�����˼��
 * ���̣��Ȱ�����ָ�������飬��ͳ�Ƴ��������ڲ�������Ե���Ŀ��Ȼ����ͳ�Ƴ���������������֮�������Ե���Ŀ��
 * ��ͳ������ԵĹ����У�����Ҫ�������������
 * (a) �ѳ���Ϊ4������ֽ����������Ϊ2�������飻
 * (b) �ѳ���Ϊ2������ֽ�������ɶ�Ϊ1�������飻
 * (c) �ѳ���Ϊ1�������� �ϲ�������ͳ������� ��
 * (d) �ѳ���Ϊ2��������ϲ������򣬲�ͳ������ԣ�
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class InversePairs {
	
    public int InversePairs(int [] array) {
    	/**
    	 * �߽������ж�
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         *	 �����������飬���ҿ�������������Ƚϴ�С
         */
        int [] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        
        return count%1000000007;
    }

	private int InversePairsCore(int[] data, int[] copy, int start, int end) {
		/**
		 * 	�����С�ָ�Ϊ1�������ڱȽϣ�
		 */
		if(start == end) {
			copy[start] = data[start];
			return 0;
		}
		/**
		 * 	��������
		 */
		int length = (end - start) >> 1;
        /**
         * 	��ͳ�Ƴ��������ڲ�������Ե���Ŀ	
         */
		int left = InversePairsCore(copy, data, start, start+length)%1000000007;
		int right = InversePairsCore(copy, data, start+length+1, end)%1000000007;
		
		//ǰ������һ�����ֵ��±�
		int i = start+length;
		//�������һ�����ֵ��±�
		int j = end;
		//������copy�����е��±�
		int indexCopy = end;
		int count = 0;
		
		while(i >= start && j >= start+length+1) {
			//���ǰ��ε����ִ��ں��Σ���ô���ʹ��ں��� ��j�����ο�ͷ��ȫ��
			if(data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j - start -length;
				if(count>=1000000007){
					count%=1000000007;	//��ֵ��������	
				}
			}else {
				copy[indexCopy--] = data[j--];
			}
		}
		//��ǰ��λ��ߺ���δ������Ĳ��ָ��Ƶ�copy��
		for (; i >= start; i--) {
			copy[indexCopy--] = data[i];
		}
		for (; j >= start+length+1; j--) {
			copy[indexCopy--] = data[j];
		}
		return count + left + right;
	}
}
