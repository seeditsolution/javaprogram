import java.util.*;
interface HomeDemo
{
    public void setPrices();
    public void showPrices();
    public void compareToGivenAmount(int amount);
}

abstract class Home implements HomeDemo
{
    public  int chilliPrice=100;
    public  int otherPrice=200;
    public  int lightBill=1500;
    public  int defaultAmount=2000;
    public  void showPrices()
    {
        String s="chilliprice is "+this.chilliPrice+"otherPrice is "+this.otherPrice+"light bill is "+this.lightBill;
        System.out.println(s);

    }
    public  void compareToGivenAmount(int amount)
    {
        if(amount>this.defaultAmount)
            System.out.println("Out of Budget...");
        else
            System.out.println("In Budget...");
    }
}

class HomeBudgetManagementDemo extends Home implements HomeDemo
{
    public  void setPrices()
    {
        int w,x,y,z;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new chilliprice,otherprice,lightbill to set respectively:");
        w=sc.nextInt();
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
    
        this.chilliPrice=w;
        this.otherPrice=x;
       this.lightBill=y;
        this.defaultAmount=z;
    }

    public static void main(String[] args)
    {
        int a,b,c,d;

        HomeBudgetManagementDemo h=new HomeBudgetManagementDemo();


    Scanner sc=new Scanner(System.in);
    // System.out.println("Enter chilliprice,otherprice,lightbill respectively:");
    // a=sc.nextInt();
    // b=sc.nextInt();
    // c=sc.nextInt();
    
    while(true)
    {
        System.out.println("1.show prices\n2.set prices\n3.comapre to given amount\nenter >2 to exit...Enter option...:");
        int opt=sc.nextInt();
        if(opt==1)
            h.showPrices();
        else if(opt==2)
            h.setPrices();
        else if(opt==3)
        {
            System.out.println("enter the amount");
            int amt=sc.nextInt();
            h.compareToGivenAmount(amt);
        }
        else
            return ;

    }
   
    }
   
}