package question48;
/**
 * 最长不含重复字符的子字符串
 * 题目描述
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。
 * 
 * 解题思路：
 * 动态规划，用f(i)表示以i个字符结尾不包含重复子字符串的最长长度，从左向右扫
 * 1、若第i个字符在之前没出现过，则 f(i) = f(i-1) + 1;
 * 2、若第i个字符在之前出现过，
 * 计算第i个字符距离上次出现之间的距离为d
 * (a)若d <= f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新 f(i) = d
 * (b)若d > f(i-1)，则无影响,f(i) = f(i-1) + 1
 * @author Potato
 *
 */
public class LongestSubstringWithoutDuplication {
	
    public int longestSubstringWithoutDuplication(String s) {
    	/**
    	 * 判断边界条件
    	 */
    	if(s == null || s.length() <= 0) {
    		return 0;
    	}
    	/**
    	 * 当前长度和最大长度
    	 */
    	int curLength = 0;
    	int maxLength = 0;
    	/**
    	 * 用一个长为26的数组，存放每个字符上次出现在字符串中位置的下标
    	 */
    	int position [] = new int [26];
    	for (int i = 0; i < position.length; i++) {
    		position[i] = -1;
		}
    	int len = s.length();
    	for (int i = 0; i < len; i++) {
    		/**
    		 * preIndex 上次出现在字符串中位置的下标
    		 */
			int preIndex = position[s.charAt(i)-'a'];
			/**
			 * 如果为负数（-1），则之前没有出现过
			 * 如果上次出现的位置与当前i的差值大于当前字符串的长度，则代表未在当前计数范围内的字符串出现，所以不用担心
			 * 这两种情况就字符串长度加一即可
			 */
			if(preIndex < 0 || i - preIndex > curLength) {
				curLength++;
			}else {
				/**
				 * 当遇到重复的字符时，如果当前的字符长度大于最大长度，就把其赋给最大长度
				 */
				if(curLength > maxLength) {
					maxLength = curLength;
				}
				/**
				 * 长度重新设置为第i个字符距离上次出现之间的距离
				 * 就是把前面重复的那个字符之前的部分裁掉
				 */
				curLength = i - preIndex;
			}
			/**
			 * 记录出现的位置
			 */
			position[s.charAt(i)-'a'] = i;
		}
    	return maxLength > curLength ? maxLength : curLength;
        
    }
}
