package circlularlinkedlest;

public class CircularLinkedList {

	Node head;
	Node tail;
	
	public void add(String name) {
		Node newItem = new Node(name);
		if(head == null) {
			head = newItem;
			tail = newItem;
			head.SetNext(newItem);
			head.SetPrev(newItem);
			
		} else {
			
			tail.SetNext(newItem);
			newItem.SetPrev(tail);
			tail = newItem;
			tail.SetNext(head);
		}
		
	}
	
	public void eliminate(int interval) {
		Node current = head;
		do {
		for(int i = 0; i < interval; i++) {
			current = current.GetNext();
			
		}
		
		if(current == head) {
			
			Node next = head.GetNext();
			head.GetPrev().SetNext(next);
			next.SetPrev(head.GetPrev());
			head = next;
			
		} else if(current == tail) {
			
			Node prev = tail.GetPrev();
			prev.SetNext(head);
			tail = prev;
			
		} else {
			
			current.GetNext().SetPrev(current.GetPrev());
			current.GetPrev().SetNext(current.GetNext());
			
		}
		if(current != current.GetNext())System.out.println("Eliminated: " + current.GetName());
		} while (current != current.GetNext());
		
		
	}
	
	public void display() {
		Node trt = head;
		Node hare = head;
		
		do {
			System.out.println("• " + trt.GetName());
			trt = trt.GetNext();
			hare = hare.GetNext().GetNext();
			
		} while (trt != hare);
		
	};
	
}
