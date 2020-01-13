package question10;

/**
 * 矩形覆盖
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author Potato
 *
 */
public class RectCover {
	public int rectCover(int target) {
		if(target < 2) {
			return target;
		}
		int one = 1;
		int two = 1;
		int result = 0;
		for (int i = 2; i < target+1; i++) {
			result = one + two;
			two = one;
			one = result;
		}
		
		return result;
    }
}
