package question60;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * n�����ӵĵ���
 * ��Ŀ����
 *  ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs��
 *  ����n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 *  
 *  ����˼·��
 *  һ��������6���棬�����ֱ���1,2,3,4,5,6����ôn�����ӵ���С������Ϊn,��������Ϊ6n��
 *  1����ֻ��һö����ʱ����ֻ��6�ֽ��������Ϊ1,2,3,4,5,6��6�֣���һ������ʱÿ�ֽ����ֻ���ܻ����1�Σ�
 *  2������nö����ʱ����һ��ʱ����С������Ϊn����������Ϊ6n�������ĵ���������֮�䣬���������Ϊk(n<k<6n)�ĳ��ִ���,��f(k) = f(k-1)+f(k-2)+f(k-3)+f(k-4)+f(k-5)+f(k-6);
 *  ��ô�����������±꣨��С������Ϊn���±��n���㿪ʼ����nС�Ĳ���ֵ����������ͣ������Ӧ��ֵ����õ����ͳ��ֵĴ���������Ĵ�СӦ����: ������������������+1��
 *  �������������飬����һ�����������һ�����Ӹ��������Ͷ�Ӧ�Ĵ�������һ��������ŵ��¼���һ�����ӵ�ʱ����������Ͷ�Ӧ�Ĵ�����
 *  
 *  �ο����£�https://blog.csdn.net/QQ2899349953/article/details/86701456
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
		//����
		final int face = 6;
		//������
		final int pointNum = face * n;
		//������ݵ�����
		long[][] dp = new long[2][pointNum + 1];
		//��һ�� 1-6��λ�ô��Ϊ��һ�����ӵĵ������ֵĴ���������1
		for (int i = 1; i <= face; i++) {
			dp[0][i] = 1;
		}

		int flag = 1;  /* ��ת��� */
		for (int i = 2; i <= n; i++, flag = 1 - flag) {
			//�Ѽ���Ҫ������ݵ���һ����գ���Ϊ�������ϴβ���������
		    for (int j = 0; j <= pointNum; j++) {
		        dp[flag][j] = 0;	/* ��ת�������� */
		    }		                                      
		    //��������һ�е����ݣ��õ���һ�е����ݣ�f(k) = f(k-1)+f(k-2)+f(k-3)+f(k-4)+f(k-5)+f(k-6);
		    for (int j = i; j <= pointNum; j++) {
		    	for (int k = 1; k <= face && k <= j; k++) {
		    		dp[flag][j] += dp[1 - flag][j - k];
		    	}  	
		    }		            		                
		}
		//���г��ֵĴ���Ϊ6��n�η�
		final double totalNum = Math.pow(6, n);
		//ͳ�Ƴ��ָ���
		for (int i = n; i <= pointNum; i++) {
			result.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
		}
		        
		return result;
		
	}
}
