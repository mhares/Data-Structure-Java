package binaryTree;

public class BinaryTreeArrayImpl {
	private int arr[]=null;
	private int lastUsedIndex;
	
	public  BinaryTreeArrayImpl(int size) {
	  arr= new int[size+1];
	  lastUsedIndex=0;
	} 
	
	public boolean isFull() {
		if(arr.length-1==lastUsedIndex)
			return true;
		else
			return false;
	}
	
	public void insert(int value) {
		if(! isFull()) {
			arr[lastUsedIndex+1] = value;
			lastUsedIndex++;
		}
		else {
			System.out.println("Tree is Full");
		}
	}
	

	public void levelOrderTraversal() {
		for(int i =1;i<=lastUsedIndex;i++) {
			System.out.println(arr[i]);
		}
	}
	public void preOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrder(index * 2);
		preOrder(index * 2 + 1);
	}
	
	
	
	void postOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrder(index * 2);
		postOrder(index * 2 + 1);
		System.out.print(arr[index] + " ");
	}

	
	
	void inOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		System.out.print(arr[index] + " ");
		inOrder(index * 2 + 1);
	}
	
	 
	public int search(int value) {
			for (int i = 0; i <= lastUsedIndex; i++) {
				if (arr[i] == value) {
					return i;
				}
			}
			System.out.println(value + " does not exists in Tree !");
			
			return -1;
	}
	
	public void delete(int value) {
		int location = search(value);
	
		if (location == -1) {
			return;
		}else {
			arr[location] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Successfully deleted " + value + " from the Tree !");
		}	
	}
	
	
	public void deleteTree(){
		try {
			arr = null;
			System.out.println("Tree has been deleted successfully !");
		}catch(Exception e){
			System.out.println("There was an error deleting the tree.");
		}
	}
			
}
