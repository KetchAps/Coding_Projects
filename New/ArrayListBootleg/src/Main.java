
public class Main {

	public static void main(String[] args) {
		
		ArrayListBootleg<Integer> list = new ArrayListBootleg<Integer>(20);
		int e = 2;
		Integer[] ray = {88, 99, 100};
		for(int i = 0; i < 9; i++) list.add(i);
		list.addArray(ray);
		list.delete(5);
		for(int i = 0; i < list.length(); i++) System.out.print(list.get(i) + " ");
		
		
	}
	
}
