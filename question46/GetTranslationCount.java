package question46;
/**
 * 把数字翻译成字符串
 * 题目描述
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0翻译成”a”，1翻译成”b”，……，11翻译成”l”，……，25翻译成”z”。
 * 一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别是”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 * 
 * 解题思路：
 * 类似于斐波那契数列
 * 定义函数f(i)表示从第i位数字开始的不同翻译的数目，那么f(i)=f(i+1)+g(i,i+1)×f(i+2)。
 * 当第i位和第i+1位两位数字拼接起来的数字在10~25范围之内时，g(i,i+1)的值为1，否则为0 。 
 * @author Potato
 *
 */
public class GetTranslationCount {
    public int getTranslationCount(String s) {
    	/**
    	 * 判断边界条件
    	 */
        if(s == null || s.length() <= 0 ) {
        	return 0;
        }
        int length = s.length();
        /**
         * 储存每一位的情况
         */
        int[] counts = new int[length];
        /**
         * 最后一位肯定只有一种情况，就是他自己，因为她后面没有数字了
         */
        counts[length-1] = 1;
      	/**
    	 * 从倒数第二位开始遍历
    	 */
        for (int i = length-2; i >= 0; i--){
        	/**
        	 * 记录下i+1位共有多少种情况
        	 */
        	int count = counts[i + 1];
        	int digit1 = s.charAt(i) - '0';
            int digit2 = s.charAt(i+1) - '0';
            /**
             * 计算第i位和第i+1位拼接起来的数字
             */
            int num = 10 * digit1 + digit2;
            /**
             * 如果这个数字在10~25范围之内，情况就是f(i) = f(i+1)+g(i,i+1)*f(i+2)
             */
            if (num >= 10 && num <= 25){
            	/**
            	 * 如果其f(i+2)位有数字，则g(i,i+1)==1，就f(i) = f(i+1)+f(i+2)
            	 */
            	if (i < length - 2) {
            		count += counts[i + 2];
            	}else {
            		/**
            		 * 如果其f(i+2)位没有数字，那么久加上其本身的情况就行了，就是f(i) = f(i+1)+1
            		 */
            		count += 1;
            	}           		
            }
            /**
             * 记录下截止到这一位的情况数量
             */
            counts[i] = count;
        }
        /**
         * 返回一直到第一位数字共有多少种情况
         */
        return counts[0];
    }
}
