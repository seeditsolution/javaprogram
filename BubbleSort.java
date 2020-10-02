import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        bubble(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static void bubble(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++)
            for (int j = 0; j < arr.length - i; j++)
                if (isSmaller(arr, j + 1, j))
                    swap(arr, j + 1, j);
    }

    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " with " + arr[j]);
        if (arr[i] < arr[j])
            return true;
        else
            return false;
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
