package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;




public class BinarySearchTree {

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

 public BinarySearchTree() {
	
	this.root = null;
}

 
  public void search(int value) {
	  
	  searchForValue(root, value);
  }
 
  
  public void insert(int value) {
	  root=insertInTree(root, value);
  }
  
  BinaryNode insertInTree(BinaryNode curentNode , int value) {
	  if (curentNode==null) {
		  return createNewNode(value);
	  }
	  else if(value <= curentNode.value) {
		  curentNode.setLeft(insertInTree(curentNode.left, value));
		  return curentNode;
	  }
	  else {
		  curentNode.setRight(insertInTree(curentNode.right, value));
		  return curentNode;
	  }
	  
  }
  
  
  BinaryNode createNewNode(int value) {
	  BinaryNode node = new BinaryNode();
	  node.value=value;
	  return node;
	  
  }
  
  BinaryNode searchForValue(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}
	}
	 

    public void levelOrder() {
    	 Queue<BinaryNode> queue= new LinkedList<BinarySearchTree.BinaryNode>();
    	 queue.add(root);
    	 if(root==null) {
    		 System.out.println("Tree is empty");
    	 }
    	 while(!queue.isEmpty()) {
    		 BinaryNode node =queue.remove();
    		 System.out.print(node.value+" ");
    		 if(node.left!=null) {
    			 queue.add(node.left);
    		 }
    		 if(node.right!=null) {
    			 queue.add(node.right);
    		 }
    	 }
    }

    public void delete(int value) {
    	deleteNodeOfBST(root, value);
    	
    }
    
	public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.getValue()) {
			root.setLeft(deleteNodeOfBST(root.getLeft(), value));
		} else if (value > root.getValue()) {
			root.setRight(deleteNodeOfBST(root.getRight(), value));
		} else { // If currentNode is the node to be deleted

			if (root.getLeft() != null && root.getRight() != null) { // if nodeToBeDeleted have both children
				BinaryNode temp = root;
				BinaryNode minNodeForRight = minimumElement(temp.getRight());// Finding minimum element from right subtree
				root.setValue(minNodeForRight.getValue()); // Replacing current node with minimum node from right subtree
				root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue()));  // Deleting minimum node from right now
			}
			
			  else if (root.getLeft() != null) {// if nodeToBeDeleted has only left child
				root = root.getLeft();
			} else if (root.getRight() != null) {// if nodeToBeDeleted has only right child
				root = root.getRight();
			} else // if nodeToBeDeleted do not have child (Leaf node)
				root = null;
		}
		return root;
	}
	
	
	
	public static BinaryNode minimumElement(BinaryNode root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}
    
	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully !");
	}
 
 
 
 }
  

