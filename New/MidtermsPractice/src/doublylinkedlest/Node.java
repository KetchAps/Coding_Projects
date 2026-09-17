package doublylinkedlest;

public class Node {

	private String title;
	private String url;
	
	private Node next;
	private Node prev;
	
	public Node(String title, String num) {
		SetTitle(title);
		SetUrl(num);
	}
	
	public void SetTitle(String title) {
		this.title = title;
	}
	
	public String GetTitle() {
		return title;
	}
	
	public void SetUrl(String url) {
		this.url = url;
		
	}
	
	public String GetUrl() {		
		return url;
		
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
