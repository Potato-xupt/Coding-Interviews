package question42;

/**
 * 连续子数组的最大和(动态规划解法)
 * 给定一个数组 array[1, 4, -5, 9, 8, 3, -6]，在这个数字中有多个子数组，子数组和最大的应该是：[9, 8, 3]，输出20，
 * 再比如数组为[1, -2, 3, 10, -4, 7, 2, -5]，和最大的子数组为[3, 10, -4, 7, 2]，输出18。
 * 
 * 解题思路：
 * 状态方程 ： max( dp[ i ] ) = getMax( max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] )
 * 上面式子的意义是：我们从头开始遍历数组，遍历到数组元素 arr[ i ] 时，连续的最大的和 可能为 max( dp[ i -1 ] ) + arr[ i ] ，也可能为 arr[ i ] ，
 * 做比较即可得出哪个更大，取最大值。时间复杂度为 n。
 * @author Potato
 *
 */

public class FindGreatestSumOfSubArrayByDP {
    public int FindGreatestSumOfSubArray(int[] array) {
    	/**
    	 * 判断边界条件
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         * sum：当前和的值
         * max：最大连续和
         */
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {    
        	/**
        	 * 状态方程
        	 */
			sum = (sum+array[i]) > array[i] ? (sum+array[i]) : array[i];
			max = max > sum ? max : sum;
		}
        return max;
    }
}
