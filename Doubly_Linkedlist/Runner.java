package Linkedlist.Doubly_Linkedlist;

public class Runner {

	public static void main(String[] args) {
		DLL dl= new DLL();
		dl.insert(10);
		dl.insert(20);
		
		dl.insert(30);
		dl.display();
		dl.deleteAt(2);
		dl.display();

	}

}
