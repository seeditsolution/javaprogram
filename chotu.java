import java.util.Scanner;
class Chotu
{
public static void main(String[] args)
{
Scanner scan=new Scanner(System.in);
System.out.println("Enter 3 real no's");
int x=scan.nextInt();
int y=scan.nextInt();
int z=scan.nextInt();
int temp;

int s= z < (x<y ? x:y) ? z:(x<y ? x:y);

System.out.println(s+" is the smallest among 3 no's");
}
 }
