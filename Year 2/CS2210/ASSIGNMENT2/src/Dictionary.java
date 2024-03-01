
/* Class: Dictionary
 * Author: Ria Haque 251164501
 * This class represents a dictionary that stores Records in key-value pairs, with the key being the Record game string and the value being the Record object.
 * They are stored in hash table that uses separate chaining to resolve collisions. It uses nodes to store each Record object and then stores the node in the
 * appropriate hash table position, or at the end of a linked list. The hash table is default filled with nodes that store null for their data and next pointer.
 */

import java.util.Arrays;




public class Dictionary {
	private HashNode hashTable[]; /* The array of nodes used for the hash table */
	private int records; /*Tracks the amount of currently stored Records */
	private int size; /* The size of the hash table */

	
	/* Constructor for Dictionary class, creates new Dictionary/hash table and fills it with null
	 * @param size the size of the dictionary
	 */
	public Dictionary(int size) {
		this.size = size;
		this.hashTable = new HashNode[size]; 
		Arrays.fill(hashTable, null); 
	}
	
	
	
	/* Hashes a string into an integer and then remaps it to fit to the size of the dictionary
	 * @param key the string key of the Record object
	 * @return val, the index of the hash table the Record should be stored
	 */
	private int hash(String key) {
		int length = key.length();
		int val = (int) (key.charAt(length -1));
		for (int i = length - 2; i >= 0; i--) {
			val = (   val * 31 + (int)(key.charAt(i))  ) % this.size;
		}
		return val;
	}
	
	
	/* If a Record object with a certain key is already stored in the dictionary, returns it, else null
	 * @return if it is already stored, the Record object, else null
	 */
	public Record get(String key) {
		int index = hash(key);
		HashNode current = hashTable[index];
		while ((current!= null) && (! (current.getRecord()).getKey().equals(key))) { // until the key is found or node is null
			current = current.getNext();
		}
		if (current != null) return current.getRecord();
		else return null;
	}
	
	
	
	/* Adds a Record object to the dictionary and increments records, throws DuplicatedKeyException if it is already stored
	 * If it is not already stored, creates a node to store the Record and gets its hash code
	 * If hash code position node has null data, stores the node there and returns 0. 
	 * If hash code position node stores a Record, adds to end of linked list and returns 1
	 * @param rec the Record to be stored
	 * @return 0 if there is no collision, else 1
	 */
    public int put (Record rec) throws DuplicatedKeyException {
    	// Search for key, if it exists already, throw Duplicated Key exception
    	if (get(rec.getKey()) != null) {
    		throw new DuplicatedKeyException("Duplicated Key Error: Key already exists");
    	}
    	
    	HashNode newNode = new HashNode(rec); 
    	int hashCode = hash(rec.getKey());
    	
    	if (hashTable[hashCode] == null) { // Checks if hashcode position's node stores a Record object or null
    		hashTable[hashCode] = newNode;
    		records++;
    		return 0;
    	}
    	else {
    		HashNode currentNode = hashTable[hashCode];
    		while (currentNode.getNext() != null) {
    			currentNode = currentNode.getNext();
    		}
    		currentNode.setNext(newNode);
    		records++;
    		return 1;
    	}
    	
    }
    
    
    
    /*
     * If the key is not in the table, throw InexistentKeyException
     * 
     */
    public void remove (String key) throws InexistentKeyException {
    	if (this.get(key) == null) throw new InexistentKeyException("Inexistent Key Error: Key does not exist");
    	int hashCode = hash(key);
    	HashNode currentNode = hashTable[hashCode];
    	if (currentNode.getRecord().getKey().equals(key)) {
    		hashTable[hashCode] = currentNode.getNext();
    		records--;
    	}
    	else {
        	HashNode preNode = null;
        	while (!currentNode.getRecord().getKey().equals(key)) {
        		preNode = currentNode;
        		currentNode = currentNode.getNext();
        	}
        	preNode.setNext(currentNode.getNext());
        	records--;
    	}
    }
    
    
    /* Returns the number of Records currently stored */
    public int numRecords() {
    	return this.records;
    }
	
    
    
    
	/*Testing*/
    public static void main(String[] args) {
    	System.out.println("Starting program");
    	Record r3 = new Record("ab", 1, 3);
    	Record r4 = new Record("4eeeeeeeeeeeeeee", 1, 4);
    	Record r5 = new Record("5eeeeeeeeeeeeeee", 1, 5);
    	
    	Dictionary testDict = new Dictionary(13);
    	testDict.put(r3);
    	testDict.put(r4);
    	testDict.put(r5);
    	
    	for (int i = 0; i < 13; i++) {
    		if (testDict.hashTable[i] == null) System.out.println("null");
    		else System.out.println(testDict.hashTable[i].getRecord().getKey());
    	}
    	
    	for (int i = 0; i < 13; i++) {
    		System.out.println(testDict.hashTable[i]);
    	}
    	
    	
    	Record testRec = testDict.get("ab");
    	System.out.println(testRec.getKey());
    	
    	testDict.remove("ab");
    	
    	System.out.println("removing");
    	
    	for (int i = 0; i < 13; i++) {
    		if (testDict.hashTable[i] == null) System.out.println("null");
    		else System.out.println(testDict.hashTable[i].getRecord().getKey());
    	}
    	
    }

	
	
	
	
	
	
	
	
}
