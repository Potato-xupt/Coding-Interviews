package question14;

/**
 * 剪绳子（动态规划解法
 * 题目描述
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 * 
 * 解题思路：类似斐波那契数列
 * @author Potato
 *
 */
public class DP_MaxProductAfterCutting {
	public int maxProductAfterCutting(int length){
        if(length < 2) {
        	return 0;
        }
        if(length == 2) {
        	return 1;
        }
        if(length == 3) {
        	return 2;
        }
        
        int [] products = new int [length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i < length + 1; i++) {
        	max = 0;
			for (int j = 1; j < (i/2+1); j++) {
				int product = products[j] *products[i-j];
				if(product > max) {
					max = product;
				}				
			}
			products[i] = max;		
		}
        
        return products[length];
    }
}
