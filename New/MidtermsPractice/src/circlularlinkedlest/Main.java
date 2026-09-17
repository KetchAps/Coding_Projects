package circlularlinkedlest;

public class Main {

	public static void main(String[] args) {
		
		CircularLinkedList list = new CircularLinkedList();
		
		list.add("Wilson");
		list.add("Willow");
		list.add("Wolfgang");
		list.add("Wendy");
		list.add("WX-78");
		list.add("Wickerbottom");
		list.add("Maxwell");
		list.display();
		
		System.out.println("ELIMINATE every 2nd Position --------------");
		list.eliminate(2);
		list.display();
		
	}
	
}
