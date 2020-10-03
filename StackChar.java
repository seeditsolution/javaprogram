package Stack;

public class StackChar {
	private int maxSize;
	private char[] stackArray;
	private int top;

	StackChar(int max)
	{
		maxSize=max;
		stackArray=new char[maxSize];
		top=-1;
	}
	public void push(char item)
	{
		stackArray[++top]=item;
	}
	public char pop()
	{
		return stackArray[top--];	
	}
	public char peek()
	{
		return stackArray[top];
	}
	public boolean isEmpty()
	{
		return (top==-1);
	}
	public boolean isFull()
	{
		return (top==maxSize-1);
	}
}
