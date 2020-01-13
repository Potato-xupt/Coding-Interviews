package question58;
/**
 * 翻转单词顺序列
 * 题目描述
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 * 
 * 解题思路：
 * 先反转整个句子，然后再反转每个单词
 * 题目应该有一个隐含条件，就是不能用额外的空间。
 * 虽然 Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，
 * 但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。
 * 任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
 * 
 * 反转句子简单，就是首位字符交换位置
 * 其次反转单词就是找到单词的首位位置，反转即可
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class ReverseSentence {

	
    public String ReverseSentence(String str) {
    	/**
    	 * 边界条件判断
    	 */
    	if(str == null || str.length() <= 0) {
    		return str;
    	}
    	/**
    	 * 把字符字符串类型转化为字符数组，因为本来应该是字符数组的，但是牛客网提供的是字符串，就把他转成数组就好了
    	 */
    	char [] s = str.toCharArray();
    	/**
    	 * 反转整个字符数组
    	 */
    	Reverse(s,0,str.length()-1);

    	/**
    	 * 然后开始反转单词
    	 */
    	int start = 0;
    	int end = 0;
    	while(end <= s.length) {
    		/**
    		 * 如果end遇到空格或者走到数组最后一个位置，就是end走到了单词的结束
    		 * 就把这个单词反转一下
    		 */
    		if(end == s.length || s[end] == ' ') {
    			/**
    			 * 反转这个单词
    			 */
    			Reverse(s,start,end-1);
    		/**
    		 * 然后end++就到了下一个单词的第一位，start到这之后就停在这
    		 */
    			end++;
    			start = end;    			
    		}else {
    			/**
    			 * end继续走找单词结束的位置
    			 */
    			end++;
    		}
    	}
    	/**
    	 * 把字符数组转化为字符串返回
    	 */
    	return new String(s);
        
    }

	private void Reverse(char [] s, int start, int end) {
		/**
		 * 不断交换首位字符的位置就行了
		 */
		while(start < end) {
			char temp = s[start];
			s[start++] =s[end];
			s[end--] = temp;		
		}
		
	}
}
