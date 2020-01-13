package question03;

/**
 * ���޸������ҳ��ظ�������
 * ���η�  ����
 * ��1~n�����ִ��м�����m�ֳ������֣���ǰһ��1~m��������Ŀ����m����˵���ظ�������ǰһ�����䣬�����ں������m+1~n��ÿ���������ж�һ��Ϊ����֪���ҵ��ظ����֡�
 * 
 * @author Potato
 *
 */
public class GetDuplication {
	
	public int getDuplication(int [] numbers,int length) {
		/**
		 * �߽������ж�
		 */
		if(numbers == null || length <= 0) {
			return -1;
		}
		
		int start = 1;
		int end = length - 1;
	
		while(end >= start) {
			/**
			 * ȡ�м�ֵ������λ������졣
			 * >> 1 Ϊ�� 2
			 * << 1 Ϊ�� 2
			 */
			int middle = ((end - start) >> 1) + start;
			int count = countRange(numbers,length,start,middle);
			
			if(end == start) {
				/**
				 * ���end == start��ȣ������ڼ䷶Χ�ڵ����ִ���һ������϶����ظ�����
				 * ����϶�û���ظ�����
				 */
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			/**
			 * ���start��end�ķ�Χ�ڵ����ָ����������ķ�Χ�����ظ�������ǰ���
			 * �����ظ������ں���
			 */
			if(count > (middle - start + 1)) {
				end = middle;
			}else {
				start = middle + 1;
			}
		}
		
		return -1;
	}
	
	public int countRange(int [] numbers,int length,int start,int end) {
		
		int count = 0;
		/**
		 * �����������飬������start��end�ķ�Χ�ڵ������ж��ٸ�
		 */
		for(int i = 0;i<length;++i) {
			if(numbers[i] >= start && numbers[i] <= end){
				count++;
			}
		}
		return count;
	}
	
	
	// ==================================���Դ���==================================
    /**
     *����Ϊnull
     */
    public void test1() {
        System.out.print("test1��");
        int[] a = null;
        int dup = getDuplication(a,0);
        System.out.println(dup);
    }
 
    /**
     *��������Խ��
     */
    public void test2() {
        System.out.print("test2��");
        int[] a = { 1, 2, 3, 4 };
        int dup = getDuplication(a,a.length);
        System.out.println(dup);
    }
 
    /**
     *������ظ�����
     */
    /**
     * 
     */
    public void test3() {
        System.out.print("test3��");
        int[] a = { 1, 2, 3, 2, 4 };
        int dup = getDuplication(a,a.length);
        if (dup >= 0)
            System.out.println("�ظ�����Ϊ��" + dup);
    }
 
    public static void main(String[] args) {
    	GetDuplication f2 = new GetDuplication();
        f2.test1();
        f2.test2();
        f2.test3();
    }
}
