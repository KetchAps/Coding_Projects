 class Main {

	public static void main(String[] args) {
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.add("potato"); //0
		list.add("tomato"); //1
		list.add("cabbage"); //2
		list.add("corn"); //3
		list.add("eggplant"); //4
		list.delete(2);
		
		for(int i = 0; i < list.size(); i++) System.out.print("(" + i + ")" + list.get(i) + " ");
		
	}
	
	
}
