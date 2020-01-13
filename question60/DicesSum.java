package question60;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * n个骰子的点数
 * 题目描述
 *  把n个骰子扔在地上，所有骰子朝上一面的点数之和为s，
 *  输入n，打印出s的所有可能的值出现的概率。
 *  
 *  解题思路：
 *  一个骰子有6个面，点数分别是1,2,3,4,5,6，那么n个骰子的最小点数和为n,最大点数和为6n；
 *  1、当只有一枚骰子时，它只有6种结果，即和为1,2,3,4,5,6这6种，抛一次骰子时每种结果都只可能会出现1次；
 *  2、当有n枚骰子时，抛一次时的最小点数和为n，最大点数和为6n，其他的点数和在这之间，当求点数和为k(n<k<6n)的出现次数,那f(k) = f(k-1)+f(k-2)+f(k-3)+f(k-4)+f(k-5)+f(k-6);
 *  那么我们用数组下标（最小点数和为n，下标从n计算开始，比n小的不赋值）代表点数和，数组对应的值代表该点数和出现的次数，数组的大小应该是: 骰子最大点数×骰子数+1；
 *  我们用两个数组，其中一个用来存放上一轮骰子各个点数和对应的次数，另一个用来存放当新加入一个骰子的时候各个点数和对应的次数。
 *  
 *  参考文章：https://blog.csdn.net/QQ2899349953/article/details/86701456
 *  
 * @author Potato
 *
 */
public class DicesSum {

	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
		List<Map.Entry<Integer, Double>> result = new ArrayList<>();
		if(n < 1) {
			return result;
		}
		//面数
		final int face = 6;
		//最大点数
		final int pointNum = face * n;
		//存放数据的数组
		long[][] dp = new long[2][pointNum + 1];
		//第一行 1-6的位置存放为第一个骰子的点数出现的次数，都是1
		for (int i = 1; i <= face; i++) {
			dp[0][i] = 1;
		}

		int flag = 1;  /* 旋转标记 */
		for (int i = 2; i <= n; i++, flag = 1 - flag) {
			//把即将要存放数据的那一行清空，因为会有上上次残留的数据
		    for (int j = 0; j <= pointNum; j++) {
		        dp[flag][j] = 0;	/* 旋转数组清零 */
		    }		                                      
		    //根据另外一行的数据，得到这一行的数据，f(k) = f(k-1)+f(k-2)+f(k-3)+f(k-4)+f(k-5)+f(k-6);
		    for (int j = i; j <= pointNum; j++) {
		    	for (int k = 1; k <= face && k <= j; k++) {
		    		dp[flag][j] += dp[1 - flag][j - k];
		    	}  	
		    }		            		                
		}
		//总有出现的次数为6的n次方
		final double totalNum = Math.pow(6, n);
		//统计出现概率
		for (int i = n; i <= pointNum; i++) {
			result.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
		}
		        
		return result;
		
	}
}
