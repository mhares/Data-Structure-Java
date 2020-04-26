package hashing;

public class DoubleHashingMain {

	public static void main(String[] args) {
		DoubleHashing hash = new DoubleHashing();
		
		hash.insert("The");
		hash.insert("quick");
		hash.insert("brown");
		hash.insert("fox");
		hash.insert("over");
		hash.insert("lazy");
		hash.displayHashTable();
		
		
		hash.insert("fox");
		hash.displayHashTable();
		
		hash.search("fox");
		
		hash.delete("fox");
		
		hash.deleteHashTable();

	}
}
