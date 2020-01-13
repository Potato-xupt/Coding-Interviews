package question53;
/**
 * 数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组[-3, -1, 1, 3, 5]中，数字3和它的下标相等。
 * 
 * 解题思路：
 * 二分法
 * 如果当前下标与下标上的数字相等，那么直接返回该数字即可
 * 如果当前下标小于下标上的数字，那么数值和下标相等的元素肯定在右半部分，从右半部分找
 * 如果当前下标大于下标上的数字，那么数值和下标相等的元素肯定在左半部分，从左半部分找
 * @author Potato
 *
 */
public class GetNumberSameAsIndex {
    public int getNumberSameAsIndex(int[] nums) {
        if(nums == null || nums.length <= 0) {
        	return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
        	int middle = (left+right) >> 1;
        	if(middle == nums[middle]) {
        		return middle;
        	}
        	if(middle > nums[middle]) {
        		left = middle+1;
        	}else{
        		right = middle-1;
        	}
        }
        return -1;
    }
}
