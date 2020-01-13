package question65;
/**
 * 不用加减乘除做加法
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * 解题思路：
 * 先使用异或运算，num1就是求相加但是不进位的结果
 * 然后使用num2记录下进位的位数，在下一次循环时再次与num1做异或运算，就等于相加
 * 直到无进位为止
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Add {
	
	public int Add(int num1,int num2) {
        do {
        	//异或求相加
        	int sum = num1 ^ num2;
        	/**
        	 * num2得到进位结果
        	 * 只有1+1时才会进位，因为两个1做与运算得到的还是1，然后左移一位，就把这个1向前进了一位
        	 * 在下次运算时就与num1相加，直到没有进位为止
        	 */
        	num2 = (num1&num2) << 1;
        	num1 = sum;
        	
        }while(num2 != 0);
        return num1;
    }

}
