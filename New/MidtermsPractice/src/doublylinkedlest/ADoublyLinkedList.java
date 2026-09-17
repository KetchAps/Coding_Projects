package doublylinkedlest;

public class ADoublyLinkedList {

	Node head;
	Node tail;
	
	int records;
	
	void add(String title, String url) {
		Node newItem = new Node(title, url);
		if(head == null) {
			head = newItem;
			tail = newItem;
			tail.SetNext(newItem);
		} else {
			
			tail.SetNext(newItem);
			newItem.SetPrev(tail);
			tail = newItem;
			
		}
		
		records++;
		RecordCheck();
	}
	
	void RecordCheck() {
		if(records <= 5) return;
		records = 5;
		
		Node next = head.GetNext();
		next.SetPrev(null);
		head = next;
		
	}
	
	void display() {
		Node current = head;
		while(current != null) {
			
			System.out.println("• Title: " + current.GetTitle() + " | URL: " + current.GetUrl());
			
			current = current.GetNext();
			
		}
		
	}
	
}
