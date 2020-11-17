import java.lang.*;
import java.util.Scanner;

class fibo
{
public static void main(String args[])
{
Scanner kb=new Scanner(System.in);
System.out.println("Enter Range");
int n=kb.nextInt();
int a=1,b=1,c=0;
if(n==1)
System.out.println(a);
else if(n==2)
System.out.println(a+" "+b);
else
{System.out.print(a+" "+b);
for(int i=2;i<n;i++)
{c=a+b;
a=b;
b=c;
System.out.print(" "+c);
}
}
}
}
