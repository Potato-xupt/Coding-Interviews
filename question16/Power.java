package question16;

/**
 * ��ֵ�������η�
 * ��Ŀ����
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * 
 * ����˼·��
 * ���жϱ߽������base == 0��exponent == 1 or 0 �������
 * Ȼ��ݹ���ã���ʽ��a^n=a^(n/2)*a^(n/2)  ż��
 * 				a^n=a^((n-1)/2)*a^((n-1)/2)*a ����
 * ���exponentΪ�����Ļ����ȱ��������Ľ��������������ɡ�
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
