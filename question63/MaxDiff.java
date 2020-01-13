package question63;
/**
 * 股票的最大利润
 * 题目描述
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖 一次 该股票可能获得的利润是多少？
 * 例如一只股票在某些时间节点的价格为[9, 11, 8, 5, 7, 12, 16, 14]。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 * 
 *  解题思路：
 *  遍历数组，记录下i之前的最小值，然后计算出知道i的最大差值即可
 * @author Potato
 *
 */
public class MaxDiff {
	
    public int maxDiff(int[] nums) {
    	/**
    	 * 边界条件
    	 */
        if(nums == null || nums.length <= 0) {
        	return 0;
        }
        /**
         * 分别记录i之前的最小值和直到i的最大利润
         */
        int min = nums[0];
        int maxProfile = 0;
        
        for (int i = 1; i < nums.length; i++) {
        	/**
        	 * 如果i比i之前的最小值还小，那他就是新的最小值
        	 */
			min = Math.min(min, nums[i]);
			/**
			 * 用当前的值减去之前的最小值，就是最大的差值，也就是最大利润
			 */
			maxProfile = Math.max(maxProfile, nums[i] - min);
		}
        return maxProfile;
    }

}
