package question10;

/**
 * ��̬��̨��
 * ��Ŀ����
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * f(n) = 2^(n-1)
 * λ�����󼴿�
 * @author Potato
 *
 */
public class JumpFloorII {
	public int jumpFloorII(int target) {
        if(target == 0){
            return 0;
        }
        return 1 << target-1; 
    }
}
