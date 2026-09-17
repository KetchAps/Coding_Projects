package circlularlinkedlest;

public class Node {

	private String person;
	
	private Node next;
	private Node prev;
	
	public Node(String person) {
		SetName(person);
	}
	
	public void SetName(String person) {
		this.person = person;
	}
	
	public String GetName() {
		return person;
	}
	
	public void SetNext(Node next) {
		this.next = next;
	}
	
	public Node GetNext() {
		return next;
	}
	
	public void SetPrev(Node prev) {
		this.prev = prev;
		
	}
	
	public Node GetPrev() {
		return prev;
		
	}
}
