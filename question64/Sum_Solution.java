package question64;

/**
 * 求1+2+3+...+n
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * 解题思路：
 * 条件与 && 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句。
 * 利用这一特性，将递归的返回条件取非然后作为 && 的第一个条件语句，递归的主体转换为第二个条件语句，那么当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回。
 * 本题的递归返回条件为 n <= 0，取非后就是 n > 0；
 * 递归的主体部分为 sum += Sum_Solution(n - 1)，转换为条件语句后就是 (sum += Sum_Solution(n - 1)) > 0。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Sum_Solution {
	
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
        /**
         * 下面为C或者C++中更快的解法，因为无法使用乘法，可以使用二位数组代替乘法
         * 1+2+3+...+n = n(n+1)/2
         * 
         */
//    	class Solution {
//    		public:
//    		    int Sum_Solution(int n) {
//    		        bool a[n][n+1];
//    		        return sizeof(a)>>1;
//    		    }
//    		};
    }

}
