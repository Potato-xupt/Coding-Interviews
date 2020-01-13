package question37;

import commons.TreeNode;
/**
 * ���л�������
 * ��Ŀ����
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * ����˼·��
 * ���л�������ǰ��ݹ�������ɣ���λ�� # ���棬ÿ���ڵ�֮�䶼�Կո���
 * �����л���Ѱ���ַ�����һ���ո��λ�ã��жϿո�֮ǰ���Ǹ��ڵ�����
 * ����� # ��ýڵ�Ϊnull�����Ϊ���֣���ý����ڡ�
 * ����Ҳ����ո��λ�ã���ô��֤���ַ����ߵ������һ����㣬���Ժ���Ĳ��־������һ�����
 * @author Potato
 *
 */
public class SerializeAndDeserialize {
	
    public String Serialize(TreeNode root) {
    	/**
    	 * ����ڵ�Ϊnull������"#"����
    	 */
    	if(root == null) {
    		return "#";
    	}
    	/**
    	 * �ݹ�ǰ�������ÿ���ڵ�֮�䶼�Կո���
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
		 * ����ַ�������Ϊ�㣬����������ڣ�ֱ�ӷ���null
		 */
		if(deserializeStr.length() <= 0) {
			return null;
		}
		/**
		 * Ѱ�ҵ�һ���ո���±�
		 */
		int index = deserializeStr.indexOf(" ");
		/**
		 * �±�֮ǰ�Ĳ���Ϊ��εݹ�Ҫ�����Ľ�㣬��node������ȡ����
		 * ����Ҳ����ո���ô˵��deserializeStr�������һ�����
		 * �����deserializeStr�а�node���ֽ�ȡ��
		 */
		String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
		deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
		/**
		 * ����ý��Ϊ"#"����ô�ýڵ�Ϊnull
		 */
		if(node.equals("#")) {
			return null;
		}
		/**
		 * ����ý�㲻Ϊ"#"����ô����������ͺ�
		 */
		TreeNode t = new TreeNode(Integer.valueOf(node));
		t.left = Deserialize();
		t.right = Deserialize();
		return t;
	}
    
}
