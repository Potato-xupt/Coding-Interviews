package question19;

/**
 * ������ʽƥ��
 * ��Ŀ����
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
 * ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��.
 * 
 * ����˼·��
 * ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
 * 1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
 * 2������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��
 * 
 * ����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
 * ������3��ƥ�䷽ʽ��
 * 1��ģʽ����2�ַ����൱��*�����ԣ�
 * 2���ַ�������1�ַ���ģʽ����2�ַ���*�൱��ֻƥ��һ���ַ���
 * 3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
 * @author Potato
 *
 */
public class Match {
	
	public boolean match(char[] str, char[] pattern){
		/**
		 * �����ж�
		 */
        if(str == null || pattern == null) {
        	return false;
        }
        return matchCore(str,pattern,0,0);
    }
	
	private boolean matchCore(char [] str, char [] pattern, int strIndex, int patternIndex) {
		/**
		 * ��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
		 */
		if(str.length == strIndex && pattern.length == patternIndex) {
			return true;
		}
		/**
		 *  pattern�ȵ�β��ƥ��ʧ��
		 */
		if(str.length != strIndex && pattern.length == patternIndex) {
			return false;
		}
		/**
		 * ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
		 */
		if((patternIndex + 1) < pattern.length && pattern[patternIndex + 1] == '*') {
			if(strIndex != str.length && str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex != str.length) ) {
				return matchCore(str,pattern,strIndex,patternIndex+2) || 
						matchCore(str,pattern,strIndex+1,patternIndex+2) || 
						matchCore(str,pattern,strIndex+1,patternIndex);
			}else {
				return matchCore(str,pattern,strIndex,patternIndex+2);
			}
		}
		/**
		 * ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
		 */
		if(strIndex != str.length && str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str,pattern,strIndex+1,patternIndex+1);
		}
		return false;

	}
}
