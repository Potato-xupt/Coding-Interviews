package question53;
/**
 * 0到n-1中缺失的数字
 * 题目描述
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 
 * 解题思路：
 * 如果数字m以及m之前的所有数字都在数组中，那么m的下标就是m
 * 如果m不在数组中，那么m+1处就是下标为m的位置
 * 以此类推，找到第一个该数字不与自己下标相等的下标，就是缺失的数字
 * @author Potato
 *
 */
public class GetMissingNumber {
    public int getMissingNumber(int[] nums) {
    	/**
    	 * 边界条件判断
    	 */
        if(nums == null || nums.length <= 0) {
        	return 0;
        }
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
        	/**
        	 * 使用二分法
        	 */
        	int middle = (left+right) >> 1;
        /**
         *	如果数字与下标不一致
         */
        	if(middle != nums[middle]) {
        		/**
        		 * 如果是第一位或者前一位与自己下标相等，那么这一位就是第一个下标不等的元素，返回这个下标，就是缺失的元素
        		 */
        		if(middle == 0 ||(middle > 0 && nums[middle-1] == middle-1) ) {
        			return middle;
        		}else {
        			/**
        			 * 否则从前半部分找
        			 */
        			right = middle -1 ;
        		}
        	}else {
        		/**
        		 * 如果数字与下标一致，从后半部分找
        		 */
        		left = middle + 1;
        	}
        }
      /**
       * 	当数组不缺失数字时,输出数组长度
       */
        if(left == nums.length) {
        	return left;
        }
        /**
         * 	无效的数组，例如非排序数组
         */
        return -1;
    }
}
