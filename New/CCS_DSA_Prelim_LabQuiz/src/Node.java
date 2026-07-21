
public class Node {
	
	int id;
	String name;
	int grade;
	// Constructor
	public Node(String name, int id, int grade) {
		this.name = name;
		this.id = id;
		this.grade = grade;
		
	}
	
	public String GetName() {
		return name;
	}
	
	public int GetID() {
		return id;
	}
	
	public void SetGrades(int grade) {
		this.grade = grade;
	}
	
	public int GetGrades() {
		return grade;
	}
	
	
}
