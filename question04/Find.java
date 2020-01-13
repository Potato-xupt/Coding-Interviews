package question04;
/**
 * 题目描述
   *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
   *解题思路：
   *从右上角开始查找，如果target等于该数，则返回true；小于该数则左移一列继续查找；大于该数则下移一行继续查找。
 * @author Potato
 *
 */
public class Find {
	 public boolean find(int target, int [][] array) {
		 /**
		  * 判断边界条件
		  */
		 if(array == null || array.length<= 0 || array[0].length<=0){
			 return false;
		 }
		 /**
		  * 从右上角开始
		  */
		 int rows = 0;
		 int column = array[0].length - 1;
		 
		 while(rows < array.length && column >= 0) {
			 /**
			  * 如果相等，直接返回true
			  */
			 if(array[rows][column] == target) {
				 return true;
			 }else if(array[rows][column] > target) {
				 /**
				  * 如果大于target，则左移一列继续查找
				  */
				 column--;
			 }else {
				 /**
				  * 如果小于target，则下移一行继续查找
				  */
				 rows++;
			 }
		 }
		 return false;
	 }
}
