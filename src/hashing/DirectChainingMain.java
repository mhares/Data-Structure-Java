package hashing;

public class DirectChainingMain {

	public static void main(String[] args) {
		DirectChaining hash = new DirectChaining();
		hash.insert("the");
		hash.insert("quick");
		hash.insert("brown");
		hash.insert("fox");
		hash.insert("over");
		hash.insert("lazy");
		
		hash.displayHashTable();
		hash.insert("fox");
		hash.insert("fox");
		hash.insert("fox");
		hash.insert("fox");
		hash.insert("fox");
		hash.insert("fox");
		hash.displayHashTable();
		
		hash.search("the");
		hash.search("fox");
		
		hash.deleteElement("the");
		hash.deleteElement("fox");
		hash.displayHashTable();
		
		hash.deleHashTable();
		hash.displayHashTable();
		

	}

}
