package question37;

import commons.TreeNode;
/**
 * 序列化二叉树
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * 解题思路：
 * 序列化：把树前序递归输出即可，空位以 # 代替，每个节点之间都以空格间隔
 * 反序列化：寻找字符串第一个空格的位置，判断空格之前的那个节点内容
 * 如果是 # 则该节点为null，如果为数字，则该结点存在。
 * 如果找不到空格的位置，那么就证明字符串走到了最后一个结点，所以后面的部分就是最后一个结点
 * @author Potato
 *
 */
public class SerializeAndDeserialize {
	
    public String Serialize(TreeNode root) {
    	/**
    	 * 如果节点为null，就用"#"代替
    	 */
    	if(root == null) {
    		return "#";
    	}
    	/**
    	 * 递归前序遍历，每个节点之间都以空格间隔
    	 */
    	return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }
    private String deserializeStr;
    public TreeNode Deserialize(String str) {
    	deserializeStr = str;
    	return Deserialize();
    }
	private TreeNode Deserialize() {
		/**
		 * 如果字符串长度为零，则该树不存在，直接返回null
		 */
		if(deserializeStr.length() <= 0) {
			return null;
		}
		/**
		 * 寻找第一个空格的下标
		 */
		int index = deserializeStr.indexOf(" ");
		/**
		 * 下标之前的部分为这次递归要建立的结点，用node把他截取出来
		 * 如果找不到空格，那么说明deserializeStr就是最后一个结点
		 * 最后在deserializeStr中把node部分截取掉
		 */
		String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
		deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
		/**
		 * 如果该结点为"#"，那么该节点为null
		 */
		if(node.equals("#")) {
			return null;
		}
		/**
		 * 如果该结点不为"#"，那么建立这个结点就好
		 */
		TreeNode t = new TreeNode(Integer.valueOf(node));
		t.left = Deserialize();
		t.right = Deserialize();
		return t;
	}
    
}
