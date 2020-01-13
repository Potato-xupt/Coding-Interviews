package question16;

/**
 * 数值的整数次方
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * 解题思路：
 * 先判断边界情况，base == 0，exponent == 1 or 0 的情况。
 * 然后递归调用：公式：a^n=a^(n/2)*a^(n/2)  偶数
 * 				a^n=a^((n-1)/2)*a^((n-1)/2)*a 奇数
 * 如果exponent为负数的话，先变成整数求的结果，最后求倒数即可。
 * @author Potato
 *
 */
public class Power {
	
	public double power(double base, int exponent) {
		if(base == 0) {
			if(exponent == 0) {
				return 1;
			}
			return 0;
		}
		if(exponent == 0) {
			return 1;
		}
		if(exponent == 1) {
			return base;
		}
		
		if(exponent > 0) {
			double result = power(base,exponent >> 1);
			result *= result;
			if((exponent & 1) == 1) {
				result *= base;
			}
			return result;
		}else {
			exponent = -exponent;
			double result = power(base,exponent);
			return 1 / result;
		}
	}
}
