package hashing;

import java.util.LinkedList;

public class DirectChaining {
	private LinkedList<String> [] hashTable;
//    private	int  maximumChainSize;
    
    public DirectChaining() {
    	hashTable=new LinkedList[13];
    }
    public int simpleHashFunctions(String key,int m) {
    	char [] ch =key.toCharArray();
    	int sum =0;
    	for(int i=0;i<ch.length;i++) {
    		sum=sum+ch[i];
    	}
    	return sum %m;
    }
    public void insert(String key) {
    	int newIndex=simpleHashFunctions(key, hashTable.length);
    	if(hashTable[newIndex] == null) {
             System.out.println("index "+ newIndex +" is empty , creating a linkedlist there");
             hashTable[newIndex]=new LinkedList<String>();
             hashTable[newIndex].add(key);
             System.out.println("Sucessfuly added value "+ key+" in index " + newIndex );
           System.out.println("----------------------------------- \n");   		
    	}else {
    		System.out.println("index "+ newIndex +"is having sufficient space , Adding there");
    		hashTable[newIndex].add(key);
    		  System.out.println("Sucessfuly added value "+ key+" in index " + newIndex );
    		  System.out.println("----------------------------------- \n");   	
    	}
    	
    }
    public boolean search(String key) {
    	int newIndex=simpleHashFunctions(key, hashTable.length);
    	if(hashTable[newIndex] != null && hashTable[newIndex].contains(key)) {
    		System.out.println("Value "+ key +" is found in hash table in index "+newIndex );
    		return true;
    	}else {
    		System.out.println("Value not found ");
    		return false;
    	}
    }
    public void deleteElement(String key) {
    	int newIndex=simpleHashFunctions(key, hashTable.length);
    	if(hashTable[newIndex] != null && hashTable[newIndex].contains(key) ) {
    		System.out.println("Value to be deleted found "+ key );
    		hashTable[newIndex].remove(key);
    		System.out.println("Value is Deleted ");
    	}else {
    		System.out.println("Value is not found ");
    	}
    	
    	
    }
    public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("There is no hash table to display");
			return;
		}else {
			for(int i=0;i<hashTable.length;i++) {
				System.out.println("index  " + i +" , key "+ hashTable[i]);
			}
		}
	}
    
    public void deleHashTable() {
    	hashTable=null;
    	System.out.println("Sucessfully delete hash table");
    }

}
