package question17;

/**
 * 打印从1到最大的n位数
 * 题目描述
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 * 解题思路：
 *     把问题转化为数字排列的解法，使用递归可以使代码简洁明了。
 *     即：如果在所有的数字前面补0的话，就会发现n位所有的十进制数其实就是n个从0到9的全排列。
 *     也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。
 *     在打印时，数字排在前面的0不打印。
 *     全排列递归实现最容易。数字的每一位都可能是0到9的一个数，然后设置下一位。
 *     递归结束的条件就是我们已经设置了数字的最后一位。

 */
public class PrintToMaxOfDigits {
	public void printToMaxOfDigits(int n){
		/**
		 * 边界条件
		 */
		if(n <= 0) {
			return;
		}
		/**
		 * 初始化数组
		 */
		char [] number = new char [n];
		for (int i = 0; i < n; i++) {
			number[i] = '0';
		}
		/**
		 * 第一位循环加，后面的位数递归
		 */
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	private void printToMaxOfNDigitsRecursively(char [] number, int n, int index) {
		/**
		 * 如果是最后一位，则开始打印
		 */
		if(index == n-1) {
			printNumber(number);
			return;
		}
		/**
		 * 循环把最后一位数字加一，
		 */
		for (int i = 0; i < 10; i++) {
			number[index + 1] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, index + 1);
		}

	}
	
	/**
	 * 打印数字
	 * @param number
	 */
	private void printNumber(char [] number) {
		boolean isBeginning0 = true;
		for (int i = 0; i < number.length; i++) {
			/**
			 * 从第一个不为零的数字开始打印，把前面的0都忽略掉
			 */
			if(isBeginning0 && number[i]!='0'){
				isBeginning0 = false;
			}
			if(!isBeginning0){
				System.out.print(number[i]);
			}

		}
		System.out.println();

	}
	

}
