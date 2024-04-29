package tree;

import java.util.*;

class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(String val) {
		this.val = val;
	}

	TreeNode(String val, TreeNode left) {
		this.val = val;
		this.left = left;
	}

	TreeNode(String val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
		
	}
	

// 現在樹看起來像這樣:
//    A
//   / \
//  B   C
// / \   \
//D   E    F
	static void DFS(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(root);
		System.out.println("DFS");
		while(!s.isEmpty())
		{
			TreeNode n = s.pop();
			System.out.println("val=" + n.val);
			
			
			if (n.right != null) {
				s.add(n.right);
			}
			if (n.left != null) {
				s.add(n.left);
			}
		}
		
	}
	
	
	
// 現在樹看起來像這樣:
//    A
//   / \
//  B   C
// / \   \
//D   E    F
	static void DFS3(TreeNode root) {//TODO
	    if (root == null) {
	        return;
	    }
	    System.out.println("DFS3");
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode current = root;
	    TreeNode lastVisited = null;

	    while (!stack.isEmpty() || current != null) {
	        if (current != null) {
	            stack.push(current);
	            current = current.left;
	        } else {
	            TreeNode peekNode = stack.peek();
	            if (peekNode.right != null && lastVisited != peekNode.right) {
	                current = peekNode.right;
	            } else {
	                System.out.println("val=" + peekNode.val);
	                lastVisited = stack.pop();
	            }
	        }
	    }
	}
	
	
	
	static void DFS2(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		System.out.println("DFS2");
		TreeNode n = root;
		while(!s.isEmpty()||n!=null)
		{
			while(n!=null)
			{
				s.push(n);
				n=n.left;
			}
		
			n=s.pop();
			System.out.println("val=" + n.val);
			
			n=n.right;
			
		}
		
	}
	static void BFS(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		System.out.println("BFS");
		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			System.out.println("val=" + n.val);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		

	}
	
}

	public class Tree {

		public static void main(String[] args) {
			TreeNode lol = new TreeNode("D");
			TreeNode rol = new TreeNode("E");
			TreeNode ror = new TreeNode("F");

			TreeNode l = new TreeNode("B", lol, rol);
			TreeNode r = new TreeNode("C", ror);

			TreeNode root = new TreeNode("A", l, r);

//			TreeNode.BFS(root);
      		TreeNode.DFS(root);
			TreeNode.DFS2(root);
			
			TreeNode.DFS3(root);
		}

	}


