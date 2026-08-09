
public class MyLinkedList<E> {
	
	Node<E> first;
	Node<E> last;
	
	int size = 0;

	/**Creates a new entry at the end of the list. 
	 * */
	public void add(E val) {
		Node<E> newNode = new Node<E>();
		newNode.setItem(val);
		
		if(first == null) { // If the list is empty
			first = newNode; // Since there's only one node, it becomes the first and the last.
			last = newNode;
		}
		else {
			last.setNext(newNode); // Sets the new node as next in the list for the current last item.
			newNode.setPrev(last); // Sets the last item in the list as the item before the new node.
			last = newNode; // Marks the new node as the last item in the list.
			
		 }
		size++;
		}
	
	/** Adds */
	public void addAt(E val, int index) {
		Node<E> newNode = new Node<E>();
		newNode.setItem(val);
		
		Node<E> itemAt = find(index); // The node at the given index
		Node<E> prevItem = itemAt.getPrev(); // The node that comes before the item at the given index.
		
		/* This block sets the newNode as (1) sets the new node as the node before the selected item and sets it as the next item for the new node.
		 * (2) Checks if the selected node is the first node, if it is, set the new node as the new head. !IMPORTANT! Since you access the linkedlist via the head,
		 * updating the head node is important to avoid bugs. (3) If there is a node before the selected item(meaning it isn't the head), set the new node
		 * as the next item for that node and set it as the next node for the previous node. */
		itemAt.setPrev(newNode);
		newNode.setNext(itemAt);
		
		if(first == itemAt) first = newNode;
		
		if(prevItem != null ) {
			
			prevItem.setNext(newNode);
			newNode.setPrev(prevItem);
		}
		
		size++;
	}
	
	/**Deletes the node at the selected index.
	 *  */
	public void delete(int index) {
		Node<E> q = find(index);
		
		if(q == first) { 
			first = q.getNext();
			return;
		}
		
		Node<E> p = q.getPrev();
		
		if(q.getNext() != null)
			p.setNext(q.getNext());
		else p.setNext(null);
		
		size--;
		
	}
	
	public int size() {
		return size;
	}
	
	/** Returns the value at the selected index. */
	public E get(int index) {
		
		Node<E> q = find(index);
		
		return q.getItem();
	}
	
	/* Helper Method: Finds the node at the given index. */
	private Node<E> find(int index) {
		if( index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
		
		Node<E> q = first;
		for(int i = 0; i < index; i++) 
			q = q.getNext();
			
		return q;
		
	}
	
	
	

}
