package question42;
/**
 * ���������������(һ��ⷨ)
 * ��������array����array[1]��ʼ���������ӣ������ֵ�Ƚϣ�����ͣ�ظ������ֵ��
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindGreatestSumOfSubArray {
	
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array == null || array.length <= 0) {
    		return 0;
    	}
    	int sum = array[0];
    	int max = array[0];
    	for (int i = 1; i < array.length; i++) {
			if(sum < 0) {
				sum = array[i];
			}else {
				sum += array[i];
			}
			max = max > sum ? max : sum;
		}
    	return max;
    }

}
