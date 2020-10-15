package Linkedlist.Single_Linkedlist;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Linkedlist list = new Linkedlist();

		while (true) {
			System.out.println("1-Insertion\n2-Deletion\n3-Display\n4-Exit");
			int key = sc.nextInt();
			int c=0,c1=0;
			switch (key) {
			case 1:
				while( c!=4)
				{	
					System.out.println("1-insert\n2-Whatever you want to insert\n3-Beggining\n4-Exit");
					int val = sc.nextInt();
					if(val==4) {c=4;}else {
					System.out.println("Enter The value");
					int value = sc.nextInt();
					
					switch (val) {
					case 1:list.insert(value);
						
						break;

					case 2:
						System.out.println("Enter index");
						int index = sc.nextInt();
						list.insertAt(index, value);
						break;

					case 3:list.insertAtStart(value);
						
						break;
					
				}
				}
				}
				break;
			case 2:
				while(c1!=4)
				{
					
					System.out.println("1-beggining\n2-Whatever you want to delete\n3-At End\n4-Exit");
					int val1 = sc.nextInt();
					if(val1==4)
						c1=4;
					else {	
					switch (val1) {
					case 1:
					
						break;

					case 2: System.out.println("Enter index");
					        int value1=sc.nextInt();
						    list.deleteAt(value1);
						    break;

					case 3:list.deleteEnd();
						
						break;
					}
				}
				}
				break;
			case 3:   list.show();
			       	  break;
			case 4:   System.exit(0);
			}
		}
	}

}
