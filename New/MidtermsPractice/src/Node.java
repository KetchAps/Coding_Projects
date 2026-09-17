
public class Node {

	private String name;
	private int contact;
	private Node next;
	
	public Node(String name, int num) {
		SetName(name);
		SetContact(num);
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public String GetName() {
		return name;
	}
	
	public void SetContact(int contact) {
		this.contact = contact;
		
	}
	
	public Integer GetContact() {		
		return contact;
		
	}
	
	public void SetNext(Node next) {
		this.next = next;
	}
	
	public Node GetNext() {
		return next;
	}
}
