package question43;
/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 
 * 解题思路：
 * 考虑从个位开始计算1出现的次数，个位上每10个数就会出现一个1，所以计算十位数之后出现1的次数即n模10的余数为a。
 * 假如个位数为0，那么a就为个位上1出现的次数；
 * 若等于1，那么还应该再加上1，也就是个位数为1所有数字的个数；
 * 若大于1，则a应该再加上1，即十位数出现的次数为a+1.
 * 同样的思想依次向左考虑十位数、百位数一直到最高位。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
        	/**
        	 * 计算a：高位
        	 * b：低位
        	 */
			int a = n / i;
			int b = n % i;
			/**
			 * 之所以补8，是因为当百位为0，则a/10==(a+8)/10
			 * 当百位>=2，补8会产生进位位，效果等同于(a/10+1)。
			 * 若weight为0，则1出现次数为round*base
			 * 若weight为1，则1出现次数为round*base+former+1
			 * 若weight大于1，则1出现次数为round*base+base
			 */
			count += (a+8) / 10 * i;
			count += (a%10==1) ? b+1 : 0;
		}
        return count;
    }
}
