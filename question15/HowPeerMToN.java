package question15;

/**
 * ������������m��n,����m��Ҫ�ı����λ���ܵõ�n��
 * 
 * ����˼·��
 * ��������ټ���1������
 * @author Potato
 *
 */
public class HowPeerMToN {

	public int howPeerMToN(int m,int n) {
		int count = 0;
		int c = m^n;
		while(c != 0) {
			count ++;
			c = (c-1) & c;
		}
		return count;
	}
}
