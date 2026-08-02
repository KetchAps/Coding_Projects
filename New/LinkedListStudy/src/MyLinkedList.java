
public class MyLinkedList<E> {
	
	Node<E> first;
	Node<E> last;
	
	int size = 0;
	
	public void addFront() {
		
		
	}
	
	public void add(E val) {
		Node<E> newNode = new Node<E>();
		newNode.setItem(val);
		
		if(first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			last.setNext(newNode);
			newNode.setPrev(last);
			last = newNode;
			
		 }
		size++;
		}
	
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
		
	public E get(int index) {
		
		Node<E> q = find(index);
		
		return q.getItem();
	}
	
	public Node<E> find(int index) {
		if( index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
		
		Node<E> q = first;
		for(int i = 0; i < index; i++) 
			q = q.getNext();
			
		return q;
		
	}
	
	
	

}
