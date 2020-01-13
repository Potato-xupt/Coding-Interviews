package question53;
/**
 * 数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * 
 * 解题思路：
 * 通过找到k的第一个坐标和最后一个坐标的方法
 * 因为数组时有序的，所以第一时间想到的是二分法，
 * 但是因为是统计出现的次数，所以可以继续通过二分法找到k的第一个出现的下标和最后一个出现的下标
 * 第一个出现的下标和最后一个出现的下标的差值加一就是出现的次数
 * @author Potato
 *
 */
public class GetNumberOfKByFirstKAndLastK {
	
    public int GetNumberOfK(int [] array , int k) {
    	/**
    	 * 边界条件判断
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         * 	分别找到第一次出现的位置和最后一次出现的位置
         */
        int first = GetFirstK(array, k, 0, array.length-1);
        int last = GetLastK(array, k, 0, array.length-1);
       
        /**
         * 	不排除没有出现的可能
         * 	如果没有出现就返回0
         */
        if(first > -1 && last > -1) {
        	return last- first +1;
        }else {
        	return 0;
        }
        
    }


	private int GetFirstK(int[] array, int k, int start, int end) {
		/**
		 * 边界条件判断，也是判断有可能没出现
		 */
		if(start > end) {
			return -1;
		}
		/**
		 * 二分法，找到中间坐标和相对应的数字
		 */
		int middleIndex = (end+start) >> 1;
		int middleData = array[middleIndex];
		 /**
		  *  如果这个数字和k一样
		  */
		if(middleData == k) {
			/**
			 *  有两种情况可以确定当前下标就是第一次出现的位置
			 *  1：当前坐标是数组第一个
			 *  2：当前坐标前面的元素不是k
			 */
			if(middleIndex == 0 || (middleIndex > 0 && array[middleIndex - 1] != k) ) {
				return middleIndex;
			}else {
				/**
				 * 否则不是第一次出现的位置，
				 *  继续二分，从数组前半部分找
				 */
				end = middleIndex -1 ;
			}
		}else if(middleData > k) {
			/**
			 * 如果中间位置的数字大于k，那么k肯定在数组前半部分，从数组前半部分找
			 */
			end = middleIndex -1 ;
		}else {
			/**
			 * 如果中间位置的数字小于k，那么k肯定在数组后半部分，从数组后半部分找
			 */
			start = middleIndex + 1;
		}
		return GetFirstK(array,k,start,end);
	}
	
	private int GetLastK(int[] array, int k, int start, int end) {
		/**
		 * 边界条件判断，也是判断有可能没出现
		 */
		if(start > end) {
			return -1;
		}
		/**
		 * 二分法，找到中间坐标和相对应的数字
		 */
		int middleIndex = (end + start) >> 1;
		int middleData = array[middleIndex];
		/**
		 *  有两种情况可以确定当前下标就是最后一次出现的位置
		 *  1：当前坐标是数组最后一个
		 *  2：当前坐标后面的元素不是k
		 */
		if(middleData == k) {
			if(middleIndex == array.length - 1 || (middleIndex < array.length -1) && array[middleIndex + 1] !=k ) {
				return middleIndex;
			}else {
				/**
				 * 否则不是最后一次出现的位置，
				 *  继续二分，从数组后半部分找
				 */
				start = middleIndex + 1;
			}						
		}else if(middleData > k) {
			/**
			 * 如果中间位置的数字大于k，那么k肯定在数组前半部分，从数组前半部分找
			 */
			end = middleIndex - 1;
		}else {
			/**
			 * 如果中间位置的数字小于k，那么k肯定在数组后半部分，从数组后半部分找
			 */
			start = middleIndex + 1;
		}
		return GetLastK(array,k,start,end);
	}
}
