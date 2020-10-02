public class Java_Math_Class {
    public static void main(String[] args) {

        // Math Class in Java
        int b=5;
        int u=10;
        int r = Math.max(b,u);
        int y = Math.min(b,u);
        System.out.println(r);
        System.out.println(y);

        int c = 64;
        int h = (int) Math.sqrt(c);
        System.out.println(h);

        double v =  Math.abs(-4.7);
        System.out.println(v);

        int g = (int) (Math.random());
        System.out.println(g);

        int randomNum = (int) (Math.random()*101);
        System.out.println(randomNum);

        // Java Math Class Methods
        int num1 = 4,num2 = 7;
        System.out.println(Math.max(num1,num2));
        System.out.println(Math.min(num1, num2));
        System.out.println(Math.sqrt(144));
        System.out.println(Math.abs(-46));
        System.out.println(Math.abs(6));
        System.out.println(101 * Math.random());
    }
}