package doublylinkedlest;

public class Main {

	public static void main(String[] args) {
		
		ADoublyLinkedList list = new ADoublyLinkedList();
		
		list.add("youtube", "https://yt.com");
		list.add("messenger", "https://messenger.com");
		list.add("stackoverflow", "https://stackoverflow.com");
		list.add("github", "https://github.com");
		list.add("discord", "https://discord.com");
		list.display();
		
		System.out.println("\nADD 6TH RECORD --------------------------\n");
		
		list.add("ALBION ONLINE", "https://albiononlineisasandboxmmorpginwhichyouwriteyourownstoryinsteadoffollowingalaidoutpath-en.com");
		list.display();
		
		System.out.println("\nADD 7TH RECORD --------------------------\n");
		
		list.add("klei accounts", "https://accounts.klei.com");
		list.display();
	}
}
