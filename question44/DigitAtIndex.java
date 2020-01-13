package question44;
/**
 * ���������е�ĳһλ����
 * ��Ŀ����
 * ������ 0123456789101112131415... �ĸ�ʽ���л���һ���ַ����У�������ַ����ĵ� index λ��
 * 
 * ����˼·��
 * �Ե�1001λ����7Ϊ��
 * ����1������ȷ�������������ڼ�λ����;
 * �����һλ����n<9;�������λ����n<9+90*2=189;�������λ����n<189+900*3=2889;˵������λ����
 * ����2��ȷ�������������ĸ�����
 * 100+(1001-190)/3= 370��
 * ����3��ȷ���Ǹ�������һλ��
 * 1001-190-(370-100)*3 = 1,����λ�ڡ�370�����±�Ϊ1��λ�ã�������7��

 * @author Potato
 *
 */
public class DigitAtIndex {
    public int digitAtIndex(int index) {
    	/**
    	 * �߽������ж�
    	 */
        if(index < 0) {
        	return -1;
        }
        /**
         * 0-9λȫ������һλ����ֱ�ӷ��ض�Ӧ���ּ���
         */
        if(index < 10) {
        	return index;
        }
        /**
         * digits����λ����һλ�������Ѿ��жϹ�������λ���ֿ�ʼ�ж�
         */
        int digits = 2;
        /**
         * �Ȱ�0-9��ʮ�����ּ�ȥ
         */
        index -= 10;
        while(true) {
        	/**
        	 * �õ�digitsλ���ֹ��ж��ٸ�
        	 * 2λ������10��1�η���9 = 90
        	 * 3λ������10��2�η���9 = 900
        	 * 4λ������10��3�η���9 = 9000        	 
        	 * 
        	 */
        	long numbers = 9*beginNumber(digits);
        	/**
        	 * ����� indexλ�����ڷ�Χ������뷶Χ���ң�����index��ȥ���ڷ�Χ�ڵ����֣�λ��+1
        	 */
        	if(index < numbers*digits) {
        		return digitAtIndex(index,digits);
        	}else {
        		index -= numbers*digits;   		
        		digits++;
        	}
        }
    }

    /**
     * ����digitsλ���ֵĵ�һ������
     * 2 -> 10
     * 3 -> 100
     * 4 -> 1000
     * @param digits
     * @return
     */
	private long beginNumber(int digits) {
		return (long) Math.pow(10, digits-1);
	}
	

	private int digitAtIndex(int index, int digits) {
		/**
		 * �ҵ�index�������ڵ�����
		 */
		long number = beginNumber(digits) + (index / digits);
		/**
		 * ����������������Ӧ������
		 */
		int indexFromRight = digits - (index % digits);
		for (int i = 1; i < indexFromRight; i++) {
			number/=10;
		}
		return (int)number%10;
	}

}
