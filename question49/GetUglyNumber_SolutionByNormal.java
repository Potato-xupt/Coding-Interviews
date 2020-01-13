package question49;
/**
 * 丑数
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 解题思路：
 * 注意：该解法只适用于判断是否为丑数，禁止用该方法求第n个丑数，因为该方法时间效率极低！严重超时！
 * 请勿使用注释掉的方法求丑数，这里只是提供一个思路而已，效率极差
 * 
 * 如果一个数字是丑数，那么连续被2、3、5整除到最后，最后的结果一定是1
 * @author Potato
 *
 */
public class GetUglyNumber_SolutionByNormal {
	/**
	 * 该方法因为计算了大量不是丑数的数字，效率极低!严重超时!不建议使用!
	 * @param index
	 * @return
	 */
    public int GetUglyNumber_Solution(int index) {
    	/**
    	 * 1-6每个数字都是丑数
    	 */
        if(index <= 6) {
        	return index;
        }
        int number = 0;
        int uglyFound = 0;
        /**
         * uglyFound 记录丑数个数
         */
        while(uglyFound < index) {
        	/**
        	 * 判断每个数字
        	 */
        	++number;
        	/**
        	 * 如果该数字为丑数，个数加一，直到找到第index个丑数为止
        	 */
        	if(isUgly(number)) {
        		uglyFound++;
        	}
        }
        return number;
        
    }

	private boolean isUgly(int number) {
		/**
		 * 如果是小于等于0的数字，那么肯定不是丑数
		 */
		if(number <= 0){
            return false;
        }
		/**
		 * 1-6每个数都是丑数
		 */
        if(number <= 6){
            return true;
        }
        /**
         * 如果能被2整数，就连续除以2，直到不能整除为止
         */
		while(number % 2 == 0) {
			number/= 2;
		}
		/**
         * 如果能被3整数，就连续除以3，直到不能整除为止
         */
		while(number % 3 == 0) {
			number /= 3;
		}
		/**
         * 如果能被5整数，就连续除以5，直到不能整除为止
         */
		while(number % 5 == 0) {
			number /= 5;
		}
		/**
		 * 最后的结果是1的话就是丑数
		 */
		return number == 1;
		
	}
}
