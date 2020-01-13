package question50;

import java.util.BitSet;
/**
 * ��һ��ֻ����һ�ε��ַ�
 * ��Ŀ����
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * 
 * ����˼·��
 * ��ֱ�۵Ľⷨ��ʹ�� HashMap �Գ��ִ�������ͳ�ƣ����ǿ��ǵ�Ҫͳ�Ƶ��ַ���Χ���ޣ���˿���ʹ������������� HashMap���Ӷ����ռ临�Ӷ��� O(N) ����Ϊ O(1)��
 * ����ʵ�ֵĿռ临�ӶȻ��������ŵġ����ǵ�ֻ��Ҫ�ҵ�ֻ����һ�ε��ַ�����ô��Ҫͳ�ƵĴ�����Ϣֻ�� 0,1,����ʹ����������λ���ܴ洢��Щ��Ϣ��
 * ʹ��bit1��bit2������һ������������bit1��bit2����0����00������һ�ζ�û�г���
 * bit1Ϊ1��bit2Ϊ�����01��������ֹ�һ�Ρ�
 * bit1��bit2����1����11��������ֶ�Ρ�
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
    	/**
    	 * �߽������ж�
    	 */
        if(str == null || str.length() <= 0) {
        	return -1;
        }
        BitSet bit1 = new BitSet(256);
        BitSet bit2 = new BitSet(256);
        int len = str.length();
        for (int i = 0; i < len; i++) {
        	/**
        	 * �����ַ��������ַ�����ÿ���ַ��ĳ��ִ���ͳ�Ƶ�bit1��bit2��
        	 * �����00���Ͱ�bit1��Ϊ1�����01���������һ��
        	 */
			if(!bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i))) {
				bit1.set(str.charAt(i));
				
			}else if(bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i))) {
				/**
				 * �����01���Ͱ�bit2��Ϊ11��������ֳ���һ��
				 */
				bit2.set(str.charAt(i));
			}
		}
        for (int i = 0; i < len; i++) {
        	/**
        	 * �ٴα����ַ���ÿ���ַ�����bit�����Ӧ���ַ��±���Աȳ��ִ���
        	 * ������һ������һ�ε��ַ����������±�
        	 */
			if(bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i))) {
				return i;
			}
		}
        /**
         * �Ҳ���������·���-1
         */
        return -1;
    }
}
