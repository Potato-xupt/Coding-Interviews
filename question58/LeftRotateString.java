package question58;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * 
 * 解题思路：
 * 先以n为长度，把字符串划分为前后两部分，如上面的例子：划分为ab和cdefg两部分
 * 然后把这两部分分别翻转，结果为：bagfedc
 * 然后把整个字符串反转，就是最后的结果：cdefgab
 * 
 * 同理如果要求右旋转字符串
 * 就先把整个字符串翻转，然后分别翻转这两部分就行了
 * 
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class LeftRotateString {
	
    public String LeftRotateString(String str,int n) {
    	/**
    	 * 边界条件判断
    	 */
        if(str == null || str.length() <= 0 || n <= 0 || n >=str.length()) {
        	return str;
        }
        /**
         * 字符串转为数组
         */
        char [] s = str.toCharArray();
        /**
         * 翻转前半部分
         */
        Reverse(s,0,n-1);
        /**
         * 翻转后半部分
         */
        Reverse(s,n,s.length-1);
        /**
         * 翻转全部
         */
        Reverse(s,0,s.length-1);
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
