package Linkedlist.Single_Linkedlist;

public class Linkedlist {
	
	Node head;
	public void insert(int data)
	{
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(head==null)
		{
			head=node;
		}
		else
		{
			Node n=head;
			while(n.next!=null)
			{
				n=n.next;
			}
			n.next=node;
		}	
	}
	
	public void insertAtStart(int data)
	{
		Node node=new Node();
		node.data=data;
		node.next=null;
		node.next=head;
		head=node;
	}
	
	public void insertAt(int index,int data)
	{
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(index==0)
		{
			insertAtStart(data);
		}
		else
		{
			Node n=head;
			for(int i=0;i<index-1;i++)
			{
				n=n.next;
			}
			node.next=n.next;
			n.next=node;
		}
	}
	
	public void deleteAt(int index)
	{
		if(index==0)
		{
			head=head.next;
		}
		else
		{
			Node n=head;
			Node n1=null;
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
	
	public void deleteEnd()
	{
		Node p=head,q=null,nex=head.next;
		if(nex==null)
		{
			head=null;
			
		}
		while((nex=p.next)!=null)
		{
			q=p;
			p=nex;
		}
		q.next=null;
		
	}
	public void deletebeg()
	{
	
		Node head1=head;
		head1=head1.next;//it means in the head1.next the value is null after assignning null head1 is also null
		
	}
	
	public void show()
	{
		Node node=head;
		while(node.next!=null)
		{
			System.out.println(node.data);
			node=node.next;
		}
		System.out.println(node.data);
	}
	
}
