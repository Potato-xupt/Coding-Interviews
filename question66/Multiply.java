package question66;
/**
 * �����˻�����
 * ��Ŀ����
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 * 
 * ����˼·:
 * B[i]����벿��(��ɫ����)��B[i-1]�йأ���B[i]����벿�ֳ˻�����C[i]����C[i]=C[i-1]*A[i-1]����
 * B[i]���Ұ벿��(��ɫ����)��B[i+1]�йأ���B[i]���Ұ벿�ֳ˻�����D[i]����D[i]=D[i+1]*A[i+1]����
 * ��������ȴ�0��n-1����������ÿ��B[i]����벿�֣� 
 *  Ȼ����һ������temp�����Ұ벿�ֵĳ˻�����n-1��0��������B[i]*=temp����ÿ�ε�temp���ϴε�temp��ϵ��Ϊtemp*=A[i+1]��
 * @author Potato
 *
 */
public class Multiply {
    public int[] multiply(int[] A) {
    	int n = A.length;
    	int [] B = new int [n];
    	//���������۳�
    	for (int i = 0, product = 1; i < n; product *= A[i++]) {
			B[i] = product;
		}
    	//���������۳�
    	for (int i = n-1, product = 1; i >= 0; product *= A[i--]) {
			B[i] *= product;
		}
    	return B;
    }
}
