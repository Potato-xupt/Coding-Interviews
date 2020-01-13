package question14;

/**
 *  �����ӣ�̰���㷨�ⷨ
 * ��Ŀ����
 * ����һ������Ϊ n ���ӣ�������Ӽ��� m �Σ�m��n ����������2��n��58 ���� m��2����
 * ÿ�ε����ӵĳ��ȼ�Ϊk[0]��k[1]��������k[m]��k[0]k[1] �� k[m] ���ܵ����˻��Ƕ��٣�
 * ���統���ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ����ĳ˻�18��
 * 
 * ����˼·��
 * �����������Ϊ3�����ӣ�������ʣ�³���1�����ټ�һ��3������һ��4.
 * @author Potato
 *
 */
public class Greedy_MaxProductAfterCutting {
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
		
		int timeOf3 = length / 3;
		
		if(length%3 == 1) {
			timeOf3 -= 1;
		}
		int timeOf2 = (length - timeOf3*3) /2;
		
		return (int) (Math.pow(3, timeOf3)*Math.pow(2, timeOf2));
	}
}
