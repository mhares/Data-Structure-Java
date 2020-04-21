package binarysearchtree;

public class BinarySearchTreeMain {

	public static void main(String[] args) {
	    BinarySearchTree tree = new BinarySearchTree();
	    tree.insert(100);
	    tree.insert(80);
	    tree.insert(200);
	    tree.insert(70);
	    tree.insert(150);
	    tree.insert(300);
	    tree.insert(90);
	    tree.insert(50);
	    tree.insert(40);
	    tree.insert(60);
	    tree.insert(250);
	    tree.insert(900);
	    
	    tree.levelOrder();
	    System.out.println("\n");
	    
	    tree.search(10);
	    tree.search(250);
	    
	    tree.delete(100);
	    System.out.println("\n");
	    tree.levelOrder();

	    

	}

}
