package question10;

/**
 * ��̨��
 * ��Ŀ����
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * ����˼·��
 *쳲����������У��������
 * @author Potato
 *
 */
public class JumpFloor {
	public int jumpFloor(int target) {
		if(target < 2) {
			return target;
		}
		int one = 1;
		int two = 1;
		int result = 0;
		for (int i = 2; i < target+1; i++) {
			result = one + two;
			two = one;
			one = result;
		}
		
		return result;
    }
}
