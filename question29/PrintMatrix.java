package question29;

import java.util.ArrayList;
/**
 * 顺时针打印矩阵
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 解题思路：
 * （1）从左往右：肯定有；
 * （2）从上到下：矩阵行数至少为2，即：终止行号必须大于起始行号（这里不可以等于哦，否则会产生矩阵右上角的元素重复多打印一次）；
 * （3）从右往左：矩阵至少为两行两列，即：终止列号必须大于起始列号，并且终止行号必须大于起始行号（同样，不可以等于，否则矩阵右下角的元素会多打印一次）；
 * （4）从下到上：矩阵至少为三行两列，即：终止行号必须比起始行号大2，并且终止列号必须大于起始列号（同样，不可以等于，否则会出现左下角和右上角元素多打印一次）
 * 
 * @author Potato
 *
 */
public class PrintMatrix {

	public ArrayList<Integer> printMatrix(int [][] matrix) {
		/**
		 * 边界条件判断
		 */
		if(matrix == null ) {
			return null;			
		}
		ArrayList<Integer> result = new ArrayList<>(matrix.length);
		if(matrix.length <= 0 || matrix[0].length <= 0) {
			return result;
		}
		/**
		 * start是从每一圈的左上角开始的
		 */
		int start = 0;
		/**
		 * 计算行数和列数，确保每一圈在矩阵内，判断while的循环条件
		 * 因为columns > start*2 && rows > start*2
		 */
		int columns = matrix[0].length;
		int rows = matrix.length;
		while(columns > start*2 && rows > start*2) {
			/**
			 * 计算这一圈的边界值
			 */
			int endX = columns - 1 - start;
			int endY = rows - 1 - start;
			/**
			 * 从左往右：肯定有
			 */
			for (int i = start; i <= endX ; i++) {
				result.add(matrix[start][i]);
			}
			
			/**
			 * 从上到下：矩阵行数至少为2，即：终止行号必须大于起始行号（这里不可以等于哦，否则会产生矩阵右上角的元素重复多打印一次）
			 */
			if(start < endY) {
				for (int i = start + 1; i <= endY ; i++) {
					result.add(matrix[i][endX]);
				}
			}
			/**
			 * 从右往左：矩阵至少为两行两列，即：终止列号必须大于起始列号，并且终止行号必须大于起始行号（同样，不可以等于，否则矩阵右下角的元素会多打印一次）
			 */
			if(start < endX && start < endY) {
				for (int i = endX - 1; i >= start ; i--) {
					result.add(matrix[endY][i]);
				}
			}
			/**
			 * 从下到上：矩阵至少为三行两列，即：终止行号必须比起始行号大2，并且终止列号必须大于起始列号（同样，不可以等于，否则会出现左下角和右上角元素多打印一次）
			 */
			if(start < endX && start < endY - 1) {
				for (int i = endY - 1; i >= start + 1; i--) {
					result.add(matrix[i][start]);
				}
			}
			/**
			 * 往中间缩小一圈
			 */
			start++;
		}
		
		return result;
	       
    }

}
