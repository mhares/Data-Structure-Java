package hashing;

import java.util.ArrayList;

public class LinearProbing {
	String hashTable [];
  private	int noOfCellsUsed;
  
  public LinearProbing() {
	  hashTable=new String[13];
	  noOfCellsUsed=0;
  }
  private int simpleHashFunction(String value , int m) {
	 char [] c = value.toCharArray();
	 int sum=0;
	 for(int i =0;i<value.length();i++) {
		 sum=sum + c[i];
	 }
	  return sum % m;
	  
  }
  private double getLoadFactor() {
	  return noOfCellsUsed * 1.00 / hashTable.length;
  }
  private void reHashValue(String value) {
	  noOfCellsUsed=0;
	  ArrayList<String> data = new ArrayList<String>();
	  for(String s : hashTable) {
		  if(s != null)
		  data.add(s);
	  }
	  data.add(value);
	  hashTable=new String[hashTable.length * 2];
	  for(String s : data) {
		  insert(s);
	  }
  }
public void insert(String value) {
	double loadFactor = getLoadFactor();
	if(loadFactor>=0.75) {
		System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
		reHashValue(value);
	}else {
		System.out.println("Inserting \"" + value + "\" in HashTable...");
		int index = simpleHashFunction(value, hashTable.length);
		for(int i=index;i<index +hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] == null) {
				hashTable[newIndex] = value;
				System.out.println("Index: " + newIndex + " is blank. Inserting there...");
				System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
				System.out.println("-------------------------------------------\n");
				break;
			}else {
				System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
			}
			
		}
		
	}
	noOfCellsUsed++;
}

public boolean search(String value) {
	int index = simpleHashFunction(value, hashTable.length);
	for(int i = index;i<index+hashTable.length;i++) {
		int newIndex = i%hashTable.length;
		if(hashTable[newIndex] != null && hashTable[newIndex].contains(value) ) {
			System.out.println("\n" + "\"" + value + "\"" + " found in HashTable at location: "+newIndex);
			return true;
		} 
	}
	System.out.println("\n" + "\"" + value + "\"" + " not found in HashTable.");
	return false;
}

 public void delete(String value) {
 int index = simpleHashFunction(value, hashTable.length);
 for(int i =index ;i<index+hashTable.length;i++) {
	 int newIndex=i%hashTable.length;
	 if(hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
		 hashTable[newIndex] = null;
			System.out.println("\n" + "\"" + value + "\"" + " has been found in HashTable." );
			System.out.println("\"" + value + "\"" + " has been deleted from HashTable !" );
			return;
	 }
 }
 System.out.println("\nCould not find " + "\"" + value + "\"" + " in HashTable");
}

 public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		}else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
			}
		}
		System.out.println("\n");
	}
	
	
	
	public void deleteHashTable() {
		System.out.println("Successfully deleted HashTable !");
		hashTable = null;
	}
 
}
