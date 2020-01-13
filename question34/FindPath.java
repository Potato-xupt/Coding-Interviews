package question34;

import java.util.ArrayList;

import commons.TreeNode;
/**
 * �������к�Ϊĳһֵ��·��
 * ��Ŀ����
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * 
 * ����˼·��
 * �ݹ飬���߹���·������һ�������У��жϵ�ǰ����Ƿ�ΪҶ�ڵ㣬������ҴﵽĿ��ֵtarget�����������Ϊһ�����ϵ�·����
 * ��������㲻����Ҫ�󣬾Ͱѵݹ鵽�����ҽڵ㡣
 * �������Ҷ�ӻ������ϣ��ͰѸýڵ��·�����Ƴ����ص�������һ��·�����ݹ���·��
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindPath {
	
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		/**
		 * ������ڵ�Ϊ�գ�ֱ�ӷ��ؿյ�ArrayList
		 */
		if(root == null) {
			return result;
		}
		FindPathCore(root,target,new ArrayList<Integer>());
		return result;
	}
	private void FindPathCore(TreeNode root, int target, ArrayList<Integer> path) {
		path.add(root.val);
		target -= root.val;
		if(target == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(path));
		}else {
			if(root.left != null) {
				FindPathCore(root.left,target,path);
			}
			if(root.right != null) {
				FindPathCore(root.right,target,path);		
			}	
		}
		path.remove(path.size()-1);
	}
}
