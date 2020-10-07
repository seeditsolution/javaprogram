import java.util.*; 
import java.lang.*; 
  
public class GfG { 
  
    public static int xSum(int n, int m) 
    { 
        int res = 0; 
        int multiplier = 1; 
        int bit_sum; 
  
        // Add numbers till each  
        // number become zero 
        while (true) { 
                  
            if(n==0 && m==0) 
            break; 
  
            // Add each bits 
            bit_sum = (n % 10) + (m % 10); 
  
            // Neglect carry 
            bit_sum %= 10; 
  
            // Update result 
            res = (bit_sum * multiplier) + res; 
            n /= 10; 
            m /= 10; 
  
            // Update multiplier 
            multiplier *= 10; 
            
        } 
        return res; 
    } 
  
    // Driver function 
    public static void main(String args[]) 
    { 
        int n = 8458; 
        int m = 8732; 
        System.out.println(xSum(n, m)); 
    } 
} 
