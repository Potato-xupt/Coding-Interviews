package question14;

/**
 * �����ӣ���̬�滮�ⷨ
 * ��Ŀ����
 * ����һ������Ϊ n ���ӣ�������Ӽ��� m �Σ�m��n ����������2��n��58 ���� m��2����
 * ÿ�ε����ӵĳ��ȼ�Ϊk[0]��k[1]��������k[m]��k[0]k[1] �� k[m] ���ܵ����˻��Ƕ��٣�
 * ���統���ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ����ĳ˻�18��
 * 
 * ����˼·������쳲���������
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
