package question10;

/**
 * 쳲���������
 * ��Ŀ����
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����n<=39
 * ����˼·��
 * �ݹ�Ч�ʼ��ͣ���Ϊ���μ����ظ���ֵ������ʹ��������㣬�е�0��͵�1����õ�2�������õ�3��...
 * @author Potato
 *
 */
public class Fibonacci {
	
	public int fibonacci(int n) {
		if(n < 2) {
			return n;
		}
		int one = 1;
		int two = 0;
		int result = 0;
		for (int i = 2; i < n+1; i++) {
			result = one + two;
			two = one;
			one = result;
		}
		
		return result;
		
    }

}
