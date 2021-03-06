package question10;

/**
 * 变态跳台阶
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n) = 2^(n-1)
 * 位运算求即可
 * @author Potato
 *
 */
public class JumpFloorII {
	public int jumpFloorII(int target) {
        if(target == 0){
            return 0;
        }
        return 1 << target-1; 
    }
}
