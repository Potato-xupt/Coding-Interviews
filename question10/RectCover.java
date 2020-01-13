package question10;

/**
 * ���θ���
 * ��Ŀ����
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * @author Potato
 *
 */
public class RectCover {
	public int rectCover(int target) {
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
