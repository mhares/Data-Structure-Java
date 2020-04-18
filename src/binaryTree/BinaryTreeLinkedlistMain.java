package binaryTree;

public class BinaryTreeLinkedlistMain {
	public static void main(String[] args) {
		BinaryTreeLinkedlistImpl tree= new BinaryTreeLinkedlistImpl();
		
		tree.insert(20);
		tree.insert(100);
		tree.insert(3);
		tree.insert(50);
		tree.insert(15);
		tree.insert(250);
		tree.insert(35);
		tree.insert(222);
		System.out.println("Level Order Traversal ->>>>");
		tree.levelOrderTraversal();
		
		System.out.println("pre Order Traversal ->>>");
		tree.preOrderTraversal(tree.getRoot());
		
		System.out.println("IN Order Traversal ->>>");
		tree.inOrderTraversal(tree.getRoot());
		
		System.out.println("post Order Traversal ->>>");
		tree.postOrder(tree.getRoot());
		
		tree.search(222);
		
		System.out.println(tree.getDeepestNode());
		
		tree.deleteTree();
	}

}
