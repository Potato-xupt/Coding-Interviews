package question21;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 解题思路：
 * 为保证奇数和奇数，偶数和偶数之间的相对位置不变，所以只能从头开始遍历，先找一个偶数，然后从这点往后，找第一个奇数；
 * 然后把这个偶数到奇数之间所有的数都向后移动一位，把这个奇数放到空出来的（之前偶数）的位置，以此相对位置保持不变。
 * @author Potato
 *
 */
public class ReOrderArrayByOrder {
	public void reOrderArray(int [] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int start = 0;
		while(start < array.length) {
			/**
			 * *首先，start从左向右遍历，找到第一个偶数； 
			 */
			while(start < array.length && !isEven(array[start])) {
				start++;
			}
			/**
			 *  然后，from从start+1开始向后找，直到找到第一个奇数； 
			 */
			int end = start+1;
			while(end < array.length && isEven(array[end])) {
				end++;
			}
			/**
			 * 接着，将[start,…,end-1]的元素整体后移一位； 
			 * 最后将找到的奇数放入start位置，然后start++。**
			 */
			if(end < array.length) {
				int temp = array[end];
				for(int i = end-1;i>=start;i--) {
					array[i+1] = array[i];
				}
				array[start] = temp;
			}else {
				break;
			}
		}
		
	}

	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
}
