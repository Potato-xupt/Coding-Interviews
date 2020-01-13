	package question05;
	/**
	 *替换空格
	 *题目描述
	 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 *解题思路：
	 *遍历字符串，计数共有多少个空格，*2 + 原长度 得出替换后的长度
	 *将字符串扩容，并且从后向前遍历。双指针，p1指向原字符串尾部，p2指向替换后字符串长度的尾部位置。
	 *p1 p2同时向前移动，遇到非空格就把p1位置得字符移动到p2位置。遇到空格就p2替换为"%20"，直到p1 p2相遇或者 p1等于0
	 * @author Potato
	 *
	 */

public class ReplaceSpace {
	 public String replaceSpace(StringBuffer str) {
		 /**
		  * 使用java内置方法解法：
		  * return str.toString().replaceAll(" ", "%20");
		  */
		 
		 /**
		  * 判断边界条件
		  */
		 if(str == null || str.length() < 0){
	            return null;
	        }
		 if(str.length() == 0){
	            return "";
	     }
	     
		 /**
		  * 对空格计数
		  */
	     int len = str.length();
	     int numberOfBlank = 0;
	     for(int i = 0;i<len;i++){
	    	 
	    	 if(str.charAt(i) == ' '){
	    		 numberOfBlank++;
	         }
	    	 
	     }
	        

	     /**
	      * 计算扩容后的大小，且扩容
	      *
	      */
	     int afterLen = len + numberOfBlank*2;
	     str.setLength(afterLen);
	     int p1 = len-1;
	     int p2 = afterLen-1;
	     
	     /**
	      * 遍历字符串，p1 p2同时向前移动，遇到非空格就把p1位置得字符移动到p2位置。遇到空格就p2替换为"%20"，直到p1 p2相遇或者 p1等于0
	      */
	     while( p1>=0 && p2>p1){
	         if(str.charAt(p1) == ' '){
	             str.setCharAt(p2--,'0');
	             str.setCharAt(p2--,'2');
	             str.setCharAt(p2--,'%');
	             p1--;
	         }else{
	             str.setCharAt(p2--,str.charAt(p1--));
	         }
	     }
	     return str.toString();
	    	
	 }
}
