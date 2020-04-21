package binaryTree;

import java.util.LinkedList;
import java.util.Queue;



public class BinaryTreeLinkedlistImpl {
	private class BinaryNode{
		private int value;
		private BinaryNode left;
		private BinaryNode right;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public BinaryNode getLeft() {
			return left;
		}
		public void setLeft(BinaryNode left) {
			this.left = left;
		}
		public BinaryNode getRight() {
			return right;
		}
		public void setRight(BinaryNode right) {
			this.right = right;
		}
		@Override
		public String toString() {
			return " "+value;
		}
		
		
	}
	
	private BinaryNode root;
	
	
	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	public BinaryTreeLinkedlistImpl() {
		this.root=null;
	}
	
	public void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if(root ==null) {
			root =node;
			System.out.println("Sucessfuly Added a Node");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryTreeLinkedlistImpl.BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode= queue.remove();
			if(presentNode.getLeft()==null) {
				presentNode.setLeft(node);
				System.out.println("Sucessfuly Added a node");
				return;
			}
			else if(presentNode.getRight()==null) {
				presentNode.setRight(node);
				System.out.println("sucessfuly Added a node");
				return;
			}
			else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
		
	}
	
  public void search(int value) {
	Queue<BinaryNode> queue = new LinkedList<BinaryTreeLinkedlistImpl.BinaryNode>();
	queue.add(root);
	while(!queue.isEmpty()) {
		BinaryNode presentNode = queue.remove();
		if(presentNode.getValue()==value) {
			System.out.println("Value "+ value +" is found");
			return;
		}
		else {
			if(presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
	}
	System.out.println("value is not found");
}
	
	public void preOrderTraversal(BinaryNode node) {
		if(node==null) {
			return;
		}
		else {
			System.out.println(node.getValue());
		     preOrderTraversal(node.left);
		     preOrderTraversal(node.right);
	}
	}
	
	public void inOrderTraversal(BinaryNode node) {
		if(node==null)
			return;
		
		else {
			inOrderTraversal(node.getLeft());
			System.out.println(node.getValue());
			inOrderTraversal(node.getRight());
		}
	}
	
	public void postOrder(BinaryNode node) {
		if(node==null)
			return;
		else {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.println(node.getValue());
		}
	}
	public void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryTreeLinkedlistImpl.BinaryNode>();
		queue.add(root);
		while(! queue.isEmpty()) {
			BinaryNode presentNode =queue.remove();
			System.out.println(presentNode.getValue());
			if(presentNode.left !=null)
				queue.add(presentNode.getLeft());
			if(presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}
	public void deleteTree() {
		root=null;
		System.out.println("Sucfesfuly Delete tree");
	}
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryTreeLinkedlistImpl.BinaryNode>();
		queue.add(root);
		BinaryNode presentNode=null;
		while(!queue.isEmpty()) {
			presentNode=queue.remove();
			if(presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}
	
	void deleteNodeOfBinaryTree(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node ");
				return;
			}else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}
		System.out.println("Did not find the node");
	}
	
	
	
	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			}else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
		  	queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}
	}

}
