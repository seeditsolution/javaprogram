public class pattern9
{
public static void main(String args[])
{
 int n=121,rem,store=0;
 int b=n;
 while(n!=0)
 {
 rem=n%10;
 store=store*10+rem;
 n=n/10;
 }
 if(b==store)
 {
 System.out.println("It is a palindrome number");
 }
 else
 {
 System.out.println("It is not a palindrome number");
 }
}
}
