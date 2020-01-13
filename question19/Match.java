package question19;

/**
 * 正则表达式匹配
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配.
 * 
 * 解题思路：
 * 当模式中的第二个字符不是“*”时：
 * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * 2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 * 
 * 而当模式中的第二个字符是“*”时：
 * 可以有3种匹配方式：
 * 1、模式后移2字符，相当于*被忽略；
 * 2、字符串后移1字符，模式后移2字符，*相当于只匹配一个字符；
 * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 * @author Potato
 *
 */
public class Match {
	
	public boolean match(char[] str, char[] pattern){
		/**
		 * 条件判断
		 */
        if(str == null || pattern == null) {
        	return false;
        }
        return matchCore(str,pattern,0,0);
    }
	
	private boolean matchCore(char [] str, char [] pattern, int strIndex, int patternIndex) {
		/**
		 * 有效性检验：str到尾，pattern到尾，匹配成功
		 */
		if(str.length == strIndex && pattern.length == patternIndex) {
			return true;
		}
		/**
		 *  pattern先到尾，匹配失败
		 */
		if(str.length != strIndex && pattern.length == patternIndex) {
			return false;
		}
		/**
		 * 模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
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
		 * 模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		 */
		if(strIndex != str.length && str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str,pattern,strIndex+1,patternIndex+1);
		}
		return false;

	}
}
