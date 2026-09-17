
public class ALinkedList {

	Node head;
	
	void add(String name, int number) {
		Node newItem = new Node(name, number);
		
		if(head == null) head = newItem;
		else
		{
			newItem.SetNext(head);
			head = newItem;
		}
		
	}
	
	void display() {
		Node current = head;
		System.out.print("• ");
		while(current != null) {
			
			System.out.print(current.GetName() + "\n- " + current.GetContact());
			current = current.GetNext();
			if(current != null)
				System.out.print("\n• ");
			
		}
		
	}
	
	void delete(String name) {
		Node prev = null;
		Node current = head;
		
		while (current != null) {
			if(current.GetName().equals(name)) {
				if(current == head) head = head.GetNext();
				else {
					
					Node next = current.GetNext();
					prev.SetNext(next);
					
				}
				}
			prev = current;
			current = current.GetNext();	
		}
	}
	
	void reverse() {
		
		Node prev = null;
		Node current = head;
		while(current != null) {
			
			Node next = current.GetNext();
			if(next == null) head = current;
			current.SetNext(prev);
			prev = current;
			current = next;
			
		}
		
	}
	
}
