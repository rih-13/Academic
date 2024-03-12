
public class DLStack<T> {
	/** This class represents a stack, implemented using a doubly linked list. This will be used later on to make a stack
	 * of chambers.
	 * @author Ria Haque 251164501
	 */
	
	

	private DoubleLinkedNode<T> top; //DLL node, represents top of stack
	private int numItems; //int, represents number of items in stack 
	
	/**
	 * constructor for an empty stack, sets top to null and numItems to 0
	 */
	public DLStack() {
		top = null;
		numItems = 0;
	}
	
	
	
	/**
	 * Creates new DLL node with element dataitem. If top of null sets top to dataitem, else pushes dataitem to top of stack.
	 * Increments numItems by +1.
	 * @param dataitem a data item of any type T to be added to the stack
	 */
	public void push(T dataitem) {
		DoubleLinkedNode<T> newItem = new DoubleLinkedNode<T>(dataitem);
		if (top == null) { //if stack is empty 
			top = newItem;
		}
		else {
			newItem.setPrevious(top);
			top.setNext(newItem);
			top = newItem;
		}
		numItems++;
	}

	/**
	 * Returns data element of node at top of stack and removes it from stack, decrementing numItems. 
	 * If stack empty, throws EmptyStack Exception.
	 * @return element of top node 
	 * @throws EmptyStackException if stack is empty 
	 */
	//if stack is empty, throws EmptyStack Exception
	//otherwise returns data element of item at top of stack, removing it from stack
	public T pop() throws EmptyStackException {
		if (top == null) throw new EmptyStackException("Empty stack");
		T result = top.getElement();
		if (top.getPrevious() == null) { //only item 
			top = null;
		}
		else {
			top = top.getPrevious();
			top.setNext(null);
		}
		numItems--;
		return result;
	}
	
	/**
	 * Returns data element of node at k position in stack and removes it from stack, decrementing numItems.
	 * @return element of node at position k in stack
	 * @param k an integer representing a position in stack
	 */
	public T pop (int k) throws InvalidItemException {
		if (k > numItems) throw new InvalidItemException("invalid");
		if (k <= 0) throw new InvalidItemException("invalid");
		int count = 1;
		DoubleLinkedNode<T> curNode = top;
		//System.out.println("starting while loop");
		while (count < k) {
			count++;
			curNode = curNode.getPrevious();
		}
		//System.out.println("ending while loop");
		T result = curNode.getElement();
		//System.out.println("got element");
		if (curNode.getNext() == null && curNode.getPrevious() == null) { //only item in stack
			top = null;
			//System.out.println("only item");
		}
		else if (curNode.getPrevious() == null) { //end of stack 
			DoubleLinkedNode<T> nextNode = curNode.getNext();
			nextNode.setPrevious(null);
			//System.out.println("front");
			
		}
		else if (curNode.getNext() == null) { //front of stack 
			top = top.getPrevious();
			top.setNext(null);
			//System.out.println("back");
		}
		else { //middle of two other nodes 
			//System.out.println("middle");
			DoubleLinkedNode<T> preNode = curNode.getPrevious();
			DoubleLinkedNode<T> nextNode = curNode.getNext();
			preNode.setNext(nextNode);
			nextNode.setPrevious(preNode);
			//System.out.println("done");
		}
		numItems--;
		return result;
	}
	
	/**
	 * Returns the data element of the top of the stack, without removing
	 * @return data element of top node
	 * @throws EmptyStackException if stack empty 
	 */
	public T peek() throws EmptyStackException {
		if (top == null) throw new EmptyStackException("");
		return top.getElement();
	}
	
	/**
	 * Returns true if stack empty, false otherwise
	 * @return boolean representing if stack is empty 
	 */
	public boolean isEmpty() {
		return (top == null);
	}
	
	/**
	 * Returns int, size of stack
	 * @return number of items in stack
	 */
	public int size() {
		return numItems;
	}
	
	/**
	 * returns top of stack
	 * @return DLL node at top of stack
	 */
	public DoubleLinkedNode<T> getTop() {
		return top;
	}
	
	/**
	 * Returns String representation of stack from top to end
	 * @return String in the form [dataitem1 dataitem2 . . . ]
	 */
	public String toString() {
		String printValue = "[";
		DoubleLinkedNode curNode = top;
		while (curNode != null) {
			printValue += curNode.getElement() + " ";
			curNode = curNode.getPrevious();
		}
		printValue += "]";
		return printValue;
	}
	
	//testing
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLStack<String> stack = new DLStack<String>();
		boolean testPassed = true;
		try {
			for (int i = 0; i < 10; ++i)
				stack.push("" + i);
			System.out.println("THE STACK: " + stack);
			String value = stack.pop(2); // Delete node storing "8"
			System.out.println("THE STACK after popping 2: " + stack);
			System.out.println("popped value: " + value);
			if (!value.equals("8")) {
				System.out.println("ERROR: not 8");
				testPassed = false;
			}
			DoubleLinkedNode<String> node = stack.getTop();

			value = stack.pop(1);
			System.out.println("THE STACK after popping 1: " + stack);
			System.out.println("popped value: " + value);
			if (!value.equals("9"))
				testPassed = false;
			
			node = stack.getTop();
			if (!node.getElement().equals("7"))
				testPassed = false;
			
			
			value = stack.pop(6);
			System.out.println("THE STACK after popping 6: " + stack);
			System.out.println("popped value: " + value);
			if (!value.equals("2"))
				testPassed = false;
			for (int i = 0; i < 6; ++i) {
				node = node.getPrevious();
				System.out.println("node: "+ node.getElement());
			}
			if (!node.getElement().equals("0"))
				testPassed = false;
			for (int i = 0; i < 6; ++i)
				node = node.getNext();
			if (!node.getElement().equals("7"))
				testPassed = true;
		} 
		finally {
			
			System.out.println("done");//catch (Exception e) {
		}
			//testPassed = false;
			//System.out.println("exception");
		//}

		if (testPassed)
			System.out.println("Test 4 passed");
		else
			System.out.println("Test 4 failed");
		
		
	}

}
