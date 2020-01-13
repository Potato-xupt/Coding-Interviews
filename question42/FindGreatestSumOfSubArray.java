package question42;
/**
 * 连续子数组的最大和(一般解法)
 * 对于数组array，从array[1]开始逐个进行相加，与最大值比较，并不停地更替最大值。
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
