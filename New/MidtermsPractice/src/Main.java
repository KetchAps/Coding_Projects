
public class Main {

	public static void main(String[] args) {
		
		ALinkedList list = new ALinkedList();
		list.add("Ethan Winters", 071244);
		list.add("Chris Redfield", 123456);
		list.add("Leon Kennedy", 129274);
		list.display();
		System.out.println("\nREVERSE: ------------------------");
		
		list.reverse();
		//list.delete("Chris Redfield");
		list.display();
	}
	
}
