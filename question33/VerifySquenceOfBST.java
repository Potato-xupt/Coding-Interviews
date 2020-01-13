package question33;

/**
 * �����������ĺ����������
 * ��Ŀ����
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 * 
 * ����˼·��
 * �ݹ顣
 * ��Ϊ�Ǻ��������������������һ��Ԫ����������
 * ��ǰ�����ң��ҵ���һ����������Ľ�㣬�����������Ŀ�ʼ�������ߵľ�����������
 * ���ж���������ֵ�ǲ���ȫ��С����������������ֵ�ǲ���ȫ����������������в����ϵĵط����򷵻�false��
 * ���������ݹ�  ������������������������������������������������
 * ����ݹ鵽һ����ֻ��������㣨�����������ӽ�㣩����ôһ���Ƿ��ϵģ�����true���ɡ�
 * ��Ϊ���������һ���Ѿ����������ж��Ƿ�����ˡ�
 * @author Potato
 *
 */
@SuppressWarnings(value = "all")
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
    	/**
    	 * �Ƚ��б߽������ж�
    	 */
    	if(sequence == null || sequence.length <= 0) {
    		return false;
    	}
    	if(sequence.length == 1) {
    		return true;
    	}
        return VerifyCore(sequence,0,sequence.length - 1);
    }

	private boolean VerifyCore(int[] sequence, int start, int last) {
		/**
		 * ����Ŀ����������ӽ�㣬����һ���ӽڵ㣬��Ϊ����һ���жϹ��Ƿ����Ҫ�����Կ���ֱ�ӷ���true
		 */
		if (last - start <= 1)
	        return true;
		/**
		 * ���һ��Ϊ���ڵ�
		 */
		int root = sequence[last];
		int i = start;
		/**
		 * �ҵ���һ���ȸ��ڵ�ֵ��Ľ�㣬��������������������
		 */
		for (;i < last; i++) {
			if(sequence[i] > root) {
				break;
			}
		}
		/**
		 * ��������бȸ��ڵ�С��ֵ���򲻷���Ҫ��
		 */
		for (int j = i; j < last; j++) {
			if(sequence[j] < root) {
				return false;
			}
		}
		/**
		 * �����ݹ�����������
		 */
		return VerifyCore(sequence,start,i-1) && VerifyCore(sequence , i, last -1);
	}
}
