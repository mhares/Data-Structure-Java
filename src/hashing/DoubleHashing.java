package hashing;

import java.util.ArrayList;

public class DoubleHashing {
	private String [] hashTable;
	private int noOfCellsUsed;
	
	public DoubleHashing() {
		hashTable = new String[13];
		noOfCellsUsed = 0;
	}

	public int simpleHashFunction(String value, int M) {
		char ch[];
		ch = value.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < value.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}
	
	int secondHashFunction(String value, int M) {
		char ch[];
		ch = value.toCharArray();
		int xlength = value.length();
		int i, sum;
		for (sum = 0, i = 0; i < xlength; i++)
			sum += ch[i];
		while (sum > 13)
			sum = addAllTheDigitsTogether(sum);
		return sum % M;
	}
	
	private int addAllTheDigitsTogether(int sum) {
		int value = 0;
		while (sum > 0) {
			value = sum % 10;
			sum = sum / 10;
		}
		return value;
	}
	public double getLoadFactor() {
		return noOfCellsUsed * 1.0 / hashTable.length;
	}
	public void insert(String value) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
			rehashKeys(value);
		} else {
			System.out.println("Inserting \"" + value + "\" in HashTable...");
			int x = simpleHashFunction(value, hashTable.length);
			int y = secondHashFunction(value, hashTable.length);
			for (int i = 0; i < hashTable.length; i++) {
					int newIndex = (x + i * y) % hashTable.length;
					// If there is a collision then we go to the next index
					// and keep going till we reach starting index.
					if (hashTable[newIndex] == null) {
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
	
	public void rehashKeys(String newStringToBeInserted) {
		noOfCellsUsed = 0; 
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashTable) { 
			if (s != null)
				data.add(s);
		}
		data.add(newStringToBeInserted);
		hashTable = new String[hashTable.length * 2]; 
		for (String s : data) { 
			insert(s);
		}
	}
	
	
	public boolean search(String stringToBeSearched) {
		int index = simpleHashFunction(stringToBeSearched, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeSearched)) {
				System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: "+newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
		return false;
	}

	
	
	public void delete(String stringToBeDeleted) {
		int index = simpleHashFunction(stringToBeDeleted, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeDeleted)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
				System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
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

