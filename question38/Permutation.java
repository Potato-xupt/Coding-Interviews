package question38;

import java.util.ArrayList;
import java.util.Collections;
/**
 * �ַ���������
 * ��Ŀ����
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * ��������:
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 * 
 * ����˼·��
 * �ַ���ȫ���п��԰��ַ��������������֣���һ������Ϊ����һ���ַ����ڶ������Ǻ�����ַ���
 * ��������ɣ����������п��ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ������������ַ�������
 * �ڶ����̶���һ���ַ�������������ַ������С����п��Կ����ǵ��͵ĵݹ�˼·�� 
 * ��������ַ��г����ظ�����{a,b,c,c}��������������жϵ�ǰ׼���������ַ��������ǰ׼���������ַ��Ѿ��ڵ�ǰ����ǰ����ַ��г��ֹ��ˣ�������������ͽ���
 * 
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Permutation {

	private ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() <= 0) {
        	return result;
        }
        Permutation(str.toCharArray(),0);
        /**
         * �ֵ����ӡ����
         */
        Collections.sort(result);
        return result;
    }
	private void Permutation(char [] str, int begin) {
		/**
		 * ������һ�ξͰ����ŵ�result��
		 */
		if(begin == str.length) {
			result.add(String.valueOf(str));
		}else {
			for (int i =begin; i < str.length; i++) {
				/**
				 * ���ж��Ƿ��ظ�
				 */
				if(istExit(str,begin,i)) {
					/**
					 * �ѵ�һ���ַ������������ַ�����
					 */
					char temp = str[i];
					str[i] = str[begin];
					str[begin] = temp;
					/**
					 * �̶���һ���ַ�������������ַ�������
					 */
					Permutation(str,begin + 1);
					temp = str[i];
					str[i] = str[begin];
					str[begin] = temp;
				}
			}
		}
		
	}
	/**
	 * �����ǰ׼���������ַ��Ѿ���iǰ����ַ��г��ֹ��ˣ�������������ͽ���
	 * @param str
	 * @param begin
	 * @param i
	 * @return
	 */
	private boolean istExit(char[] str, int begin, int i) {
		for (int j = begin; j < i; j++) {
			if(str[j] == str[i]) {
				return false;
			}
		}
		return true;
	}
}
