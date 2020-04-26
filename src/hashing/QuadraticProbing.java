package hashing;

import java.util.ArrayList;

public class QuadraticProbing {
	private String[] hashTable;
 private int noOfCellsUsed;
 
  public QuadraticProbing() {
	  hashTable=new String[13];
	  noOfCellsUsed=0;
  }
  
  private int simpleHashFunction(String value,int m) {
	  char[] ch = value.toCharArray();
	  int sum=0;
	  for(int i=0;i<value.length();i++) {
		  sum = sum +ch[i];
	  }
	  return sum % m ;  
  }
  private double getLoadFactor() {
	  return noOfCellsUsed * 1.0 / hashTable.length;
  }
  public void insert(String value) {
	  double loadFactor= getLoadFactor();
	  if(loadFactor >= 0.75) {
		  System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
		  rehash(value);
	  }else {
		  int index = simpleHashFunction(value, hashTable.length);
		  int counter =0;
		  for(int i = index;i< index + hashTable.length;i++) {
			  int newIndex= (index +(counter*counter)) % hashTable.length;
			  if(hashTable[newIndex] == null) {
				  hashTable[newIndex]=value;
				  System.out.println("Index: " + newIndex + " is blank. Inserting there...");
					System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
					System.out.println("-------------------------------------------\n");
					break;
			  }else {
				  System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
			  }
			counter++;  
		  }
		  
	  }
	  
	  noOfCellsUsed++;
  }

   private void rehash(String value) {
      noOfCellsUsed=0;
    ArrayList<String> data = new ArrayList<String>();
       for(String s : hashTable) {
        data.add(s);
  }
      data.add(value);
   hashTable = new String[hashTable.length*2];
   
   
    for(String s : data) {
	insert(s);
   }
}
  
   
   public boolean search(String value) {
		int index = simpleHashFunction(value, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
				System.out.println(
						"\n" + "\"" + value + "\"" + " found in HashTable at location: " + newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + value + "\"" + " not found in HashTable.");
		return false;
	}
   
   public void delete(String value) {
		int index = simpleHashFunction(value, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(value)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + value + "\"" + " has been found in HashTable.");
				System.out.println("\"" + value + "\"" + " has been deleted from HashTable !");
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + value + "\"" + " in HashTable");
	}
   
   public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		} else {
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
