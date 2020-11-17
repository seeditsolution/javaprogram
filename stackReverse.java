package Stack;

import java.util.Scanner;

class Reverser {
	private String input;                  //input string
	private String output;				   //output string
	Reverser(String in)
	{
		input=in;
	}
	public String doRev()    			   //function to reverse the string
	{
		int stackSize=input.length();
		StackChar theStack=new StackChar(stackSize);
		for(int i=0;i<input.length();i++)
		{
			theStack.push(input.charAt(i));
		}
		output="";                       //initializing the output string as null string
		while(!theStack.isEmpty())
		{
			output+=theStack.pop();
		}
		return output;
	}
}

public class stackReverse {

	public static void main(String[] args) {
	String input,output;
	while(true)
	{
		System.out.println("Enter a String");
		Scanner scn=new Scanner(System.in);
		input=scn.next();
		if(input.equals(""))             //it means empty string is entered by the user i.e. s/he pressed entered
		{
			break;
		}
		Reverser theReverser=new Reverser(input);
		output=theReverser.doRev();
		System.out.println("Reversed String is: "+output);
	}
  }
}
