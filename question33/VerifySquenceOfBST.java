package question33;

/**
 * 二叉搜索树的后序遍历序列
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 解题思路：
 * 递归。
 * 因为是后序遍历，所以数组的最后一个元素是树根。
 * 从前往后找，找到第一个比树根大的结点，就是右子树的开始，结点左边的就是左子树。
 * 先判断左子树的值是不是全部小于树根，右子树的值是不是全部大于树根，如果有不符合的地方，则返回false。
 * 如果符合则递归  左子树的左子树和右子树、右子树的左子树和右子树。
 * 如果递归到一棵树只有三个结点（树根，左右子结点），那么一定是符合的，返回true即可。
 * 因为这个树在上一次已经遍历过，判断是否符合了。
 * @author Potato
 *
 */
@SuppressWarnings(value = "all")
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
    	/**
    	 * 先进行边界条件判断
    	 */
    	if(sequence == null || sequence.length <= 0) {
    		return false;
    	}
    	if(sequence.length == 1) {
    		return true;
    	}
        return VerifyCore(sequence,0,sequence.length - 1);
    }

	private boolean VerifyCore(int[] sequence, int start, int last) {
		/**
		 * 传入的可能是两个子结点，或者一个子节点，因为在上一层判断过是否符合要求，所以可以直接返回true
		 */
		if (last - start <= 1)
	        return true;
		/**
		 * 最后一个为根节点
		 */
		int root = sequence[last];
		int i = start;
		/**
		 * 找到第一个比根节点值大的结点，理论上是右子树的树根
		 */
		for (;i < last; i++) {
			if(sequence[i] > root) {
				break;
			}
		}
		/**
		 * 如果其右有比根节点小的值，则不符合要求
		 */
		for (int j = i; j < last; j++) {
			if(sequence[j] < root) {
				return false;
			}
		}
		/**
		 * 继续递归左右子树。
		 */
		return VerifyCore(sequence,start,i-1) && VerifyCore(sequence , i, last -1);
	}
}
