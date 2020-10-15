import java.util.*;

class Sort
{
    public static void main(String[] arg)
    {
int i, j, temp, s;
    int arr[]=new int[6];
Scanner input=new Scanner(System.in);
for(i=1;i<=5;i++)
arr[i]=input.nextInt();

for(i=1;i<=5;i++)
    for(j=i+1;j<=5;j++)
    {
        if(arr[i]==arr[j])
        arr[i]=0;
    }
for(i=1;i<=5;i++)
System.out.println(arr[i]);
    }

}