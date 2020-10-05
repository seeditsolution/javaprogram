import java.lang.*;
import java.util.*;
import java.lang.Math;

class TestClass {
    public static long factorial(long N)
    {
        long fact=1;
        if(N==0 || N==1)
        {
            fact=1;
        }
        else
        {
            fact=N*factorial(N-1);
        }
        return fact;
    }
    public static long Calculation(long X,long N)
    {
        long rfact = factorial(N);
        long equ = rfact%10;
        
        long res = 1;
        while(equ!=0)
        {
            res = res*X;
            equ--;
        }
        return res%10;
    }
    public static void main(String args[] ) throws Exception {
        
        Scanner sobj = new Scanner(System.in);
        long X = sobj.nextLong();
        long N = sobj.nextLong();
        
        long result = Calculation(X,N);
        System.out.println(result);

    }
}
