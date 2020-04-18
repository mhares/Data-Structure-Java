package binaryTree;

public class BinaryTreeArrayImplMain {
	
	public static void main(String[] args) {
		BinaryTreeArrayImpl tree = new BinaryTreeArrayImpl(8);
		
		tree.insert(20);
		tree.insert(100);
		tree.insert(3);
		tree.insert(50);
		tree.insert(15);
		tree.insert(250);
		tree.insert(35);
		tree.insert(222);
		
		tree.levelOrderTraversal();

	}
	
}
