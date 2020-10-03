import java.lang.*;
import java.util.Scanner;
 class niven
{public static void main(String args[])
          { Scanner in=new Scanner(System.in);
             System.out.println("Enter number");
           int n=in.nextInt();
int s=0,t=n;
            while(n!=0)
                 { int r=n%10;
                        n=n/10;
                        s=s+r;
                               }
                                if((t%s)==0)
                       System.out.println("niven number");
else
System.out.println("number is not niven");                 

           }
}
