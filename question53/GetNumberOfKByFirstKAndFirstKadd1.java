package question53;
/**
 * 数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * 
 * 解题思路：
 * 二分查找 ，找到k第一次出现的坐标和k+1第一次出现的下标
 * 相减就是出现次数
 * @author Potato
 *
 */
public class GetNumberOfKByFirstKAndFirstKadd1 {

	public int GetNumberOfK(int[] nums, int K) {
		if(nums == null || nums.length <= 0) {
			return 0;
		}
		/**
		 * 分别找k和k+1第一次出现的下标
		 */
	    int first = binarySearch(nums, K);
	    int last = binarySearch(nums, K + 1);
	    /**
	     * 如果k不存在，则返回0
	     */
	    return (first == nums.length || nums[first] != K) ? 0 : last - first;
	}
	 /**
	  * 二分查找
	  * @param nums
	  * @param K
	  * @return
	  */
	private int binarySearch(int[] nums, int K) {
	    int l = 0, h = nums.length;
	    while (l < h) {
	    	/**
	    	 *  计算数组中间位置下标
	    	 */
	        int m = (l + h) >>1;
	    /**
	     * 中间位置数组大于k，从前半段开始找
	     * 否则从后半段开始找
	     * 这样的话，就算数组中没有这个数字，那么最后返回的l就是数组的长度，即l = nums.length;
	     */
	        if (nums[m] >= K)
	            h = m;
	        else
	            l = m + 1;
	    }
	    return l;
	}
}
