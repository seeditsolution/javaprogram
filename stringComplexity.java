// Time complexity O(n) 
//Input 3[ab6[ac]]
//Out put abacacacacacacabacacacacacacabacacacacacac
Explain 3[ab6*ac]--> 3[abacacacacacac] -->3*abacacacacacac -->abacacacacacacabacacacacacacabacacacacacac

import java.util.Scanner;

public class repestChar {
	public String demo () 
	{
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	String result =   sc.nextLine();
	while(result.contains("]"))
	{
		int firstlastopenbrac = result.lastIndexOf("[");
		String firstPath = result.substring(0, firstlastopenbrac-1);
		String secondpart = result.substring(firstlastopenbrac-1,result.length());
		int lastopenbrac = secondpart.indexOf("]");
		String lastbrac = secondpart.substring(0,lastopenbrac);
		String lastMain = lastbrac.substring(0,1);
		String test = lastbrac.substring(2,lastbrac.length());
		String rep ="";
		for(int i =0 ; i<Integer.parseInt(lastMain);i++)
		{
			rep = rep+test;
		}
		String third = secondpart.substring(lastopenbrac+1,secondpart.length());
		result=firstPath+rep+third;
		
	}
	return result;
	}
public static void main(String[] args) {
	repestChar a = new repestChar();
	String str =a.demo();
	System.out.println(str);
}	
}
