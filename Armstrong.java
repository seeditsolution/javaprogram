import java.util.Scanner;
class Armstrong
{
public static void main(String[] args)
{
Scanner scan=new Scanner(System.in);
System.out.println("Enter a real no:");
int x=scan.nextInt();
int temp=x,A=0,r;
while(x!=0)
{
r=x%10;
A+=r*r*r;
x=x/10;
}
if(temp==A)
System.out.println("Armstrong no");
else
System.out.println("not an Armstrong no");
}
}
