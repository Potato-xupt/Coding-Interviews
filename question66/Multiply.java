package question66;
/**
 * 构建乘积数组
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * 解题思路:
 * B[i]的左半部分(红色部分)和B[i-1]有关（将B[i]的左半部分乘积看成C[i]，有C[i]=C[i-1]*A[i-1]），
 * B[i]的右半部分(紫色部分)与B[i+1]有关（将B[i]的右半部分乘积看成D[i]，有D[i]=D[i+1]*A[i+1]），
 * 因此我们先从0到n-1遍历，计算每个B[i]的左半部分； 
 *  然后定义一个变量temp代表右半部分的乘积，从n-1到0遍历，令B[i]*=temp，而每次的temp与上次的temp关系即为temp*=A[i+1]。
 * @author Potato
 *
 */
public class Multiply {
    public int[] multiply(int[] A) {
    	int n = A.length;
    	int [] B = new int [n];
    	//从左向右累乘
    	for (int i = 0, product = 1; i < n; product *= A[i++]) {
			B[i] = product;
		}
    	//从右向左累乘
    	for (int i = n-1, product = 1; i >= 0; product *= A[i--]) {
			B[i] *= product;
		}
    	return B;
    }
}
