package Linkedlist.Doubly_Linkedlist;

public class DLL {

	Node head;

	public void insert(int data) {

		Node new_node = new Node();
		new_node.data = data;
		new_node.next = null;
		if (head == null) {

			new_node.prev = null;
			head = new_node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_node;
			new_node.prev = temp;

		}
	}

	public void insertAtStart(int data) {

		Node new_node = new Node();
		new_node.data = data;
		new_node.next = head;
		new_node.prev = null;
		head = new_node;

	}

	public void insertAt(int data, int index) {
		Node node = new Node();
		node.data = data;

		if (index == 0) {
			insertAtStart(data);
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			
			  node.next=n.next;
			n.next = node;
			node.prev=n;

		}
	}

	// DELETION
	public void deleteFirstNode() {

		head=head.next;
		head.prev=null;
	}

	public void deleteAt(int index) {
		if(index==0)
			head=null;
		else
		{
			Node p=null,n=head,n1=null;
			for(int i=0;i<index-1;i++)
			{
				n=n.next;
			}
			n1=n.next;
			n.next=n1.next;
			System.out.println("Successfully deleted :"+n1.data);
			n1=null;
			
		}
		
	}

	public void deleteEnd() {
		Node q=null,head1=head;
		if(head1.next==null)
		{
			head1=null;
		}
		while(head1.next!=null)
		{
			q=head1;
			head1=head1.next;		
		}
		q.next=null;
		
	}

	//

	// DISPLAY
	public void display() {

		Node node = head;
		Node temp = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			temp = node;
			node = node.next;
		}
		System.out.println();

		/*
		 * System.out.println("Traversal in reverse direction"); while (temp != null) {
		 * System.out.print(temp.data + " "); temp = temp.prev; } System.out.println();
		 */
	}
}
