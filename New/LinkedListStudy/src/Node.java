
public class Node<E> {

	Node<E> prev;
	Node<E> next;
	
	E item;
	
	
	public E getItem() {
		
		return item;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	
	public Node<E> getPrev() {
		return prev;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public Node<E> getNext() {
		return next;
	}
	
}
