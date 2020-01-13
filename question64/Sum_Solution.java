package question64;

/**
 * ��1+2+3+...+n
 * ��Ŀ����
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * 
 * ����˼·��
 * ������ && ���ж�·ԭ�򣬼��ڵ�һ���������Ϊ false ������²���ȥִ�еڶ���������䡣
 * ������һ���ԣ����ݹ�ķ�������ȡ��Ȼ����Ϊ && �ĵ�һ��������䣬�ݹ������ת��Ϊ�ڶ���������䣬��ô���ݹ�ķ�������Ϊ true ������¾Ͳ���ִ�еݹ�����岿�֣��ݹ鷵�ء�
 * ����ĵݹ鷵������Ϊ n <= 0��ȡ�Ǻ���� n > 0��
 * �ݹ�����岿��Ϊ sum += Sum_Solution(n - 1)��ת��Ϊ����������� (sum += Sum_Solution(n - 1)) > 0��
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
         * ����ΪC����C++�и���Ľⷨ����Ϊ�޷�ʹ�ó˷�������ʹ�ö�λ�������˷�
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
