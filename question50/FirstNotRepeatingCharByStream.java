package question50;

import java.util.BitSet;
/**
 * �ַ����е�һ�����ظ����ַ�
 * 
 * ��Ŀ����
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * 
 * �������:
 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * 
 * ����˼·��
 * ͬ�ַ����Ľⷨһ��
 * @author Potato
 *
 */
public class FirstNotRepeatingCharByStream {
	BitSet bit1 = new BitSet(256);
    BitSet bit2 = new BitSet(256);
    /**
     * ��һ���ַ����������ַ���
     */
    StringBuilder s = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch){
    	/**
    	 * �����00���Ͱ�bit1��Ϊ1�����01���������һ��
    	 */
    	if(!bit1.get(ch) && !bit2.get(ch)) {
			bit1.set(ch);			
		}else if(bit1.get(ch) && !bit2.get(ch)) {
			/**
			 * �����01���Ͱ�bit2��Ϊ11��������ֳ���һ��
			 */
			bit2.set(ch);
		}
    	/**
    	 * ���ַ�ƴ�ӵ��ַ�������
    	 */
    	s.append(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	for (int i = 0; i < s.length(); i++) {
        	/**
        	 * �����ַ���ÿ���ַ�����bit�����Ӧ���ַ��±���Աȳ��ִ���
        	 * ������һ������һ�ε��ַ����������±�
        	 */
			if(bit1.get(s.charAt(i)) && !bit2.get(s.charAt(i))) {
				return s.charAt(i);
			}
    	}
    	return '#';
    }
}
