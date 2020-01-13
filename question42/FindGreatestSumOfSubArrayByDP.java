package question42;

/**
 * ���������������(��̬�滮�ⷨ)
 * ����һ������ array[1, 4, -5, 9, 8, 3, -6]��������������ж�������飬�����������Ӧ���ǣ�[9, 8, 3]�����20��
 * �ٱ�������Ϊ[1, -2, 3, 10, -4, 7, 2, -5]��������������Ϊ[3, 10, -4, 7, 2]�����18��
 * 
 * ����˼·��
 * ״̬���� �� max( dp[ i ] ) = getMax( max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] )
 * ����ʽ�ӵ������ǣ����Ǵ�ͷ��ʼ�������飬����������Ԫ�� arr[ i ] ʱ�����������ĺ� ����Ϊ max( dp[ i -1 ] ) + arr[ i ] ��Ҳ����Ϊ arr[ i ] ��
 * ���Ƚϼ��ɵó��ĸ�����ȡ���ֵ��ʱ�临�Ӷ�Ϊ n��
 * @author Potato
 *
 */

public class FindGreatestSumOfSubArrayByDP {
    public int FindGreatestSumOfSubArray(int[] array) {
    	/**
    	 * �жϱ߽�����
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         * sum����ǰ�͵�ֵ
         * max�����������
         */
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {    
        	/**
        	 * ״̬����
        	 */
			sum = (sum+array[i]) > array[i] ? (sum+array[i]) : array[i];
			max = max > sum ? max : sum;
		}
        return max;
    }
}
