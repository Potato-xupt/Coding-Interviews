package question15;

/**
 * ��������1�ĸ���
 * ��Ŀ����
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * 
 * ����˼·��
 * ��һ����n��ȥ1���䱾���������㣬ֱ��n�����㡣
 * ���磺n = 1100
 * n-1 = 1011�� n = (n-1) & n = 1000;
 *  n-1 = 0111, n = (n-1) & n = 0;
 *  ����������1
 * @author Potato
 *
 */
public class NumberOf1 {
	public int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
        	count++;
        	n = (n-1)&n;
        }
        return count;
    }
}
