//using Naive implementation 
//disadvantage it requires extra space

public class Selection_sort {
  public static  void selectionSort1(int arr[],int n) {
    	int temp[]=new int[n];
    	for (int i = 0; i < n; i++) {
			int min_ind=0;
			for (int j = 1; j < n; j++) {
				if(arr[j] < arr[min_ind])
					min_ind=j;
			}
			temp[i]=arr[min_ind];
			arr[min_ind]=Integer.MAX_VALUE;
		}
    	for (int j = 0; j < n; j++) {
    		arr[j]=temp[j];
		}
    }
  
  //advantange is does't require ant extra space
  //better approach
  public static void selectionSort2(int arr[],int n)
  {
	  for (int i = 0; i < n; i++) {
		int min_ind=i;
		for (int j = i+1; j < n; j++) {
			if(arr[j] < arr[min_ind])
				min_ind=j;
			int temp=arr[min_ind];
			arr[min_ind]=arr[i];
			arr[i]=temp;	
		}
	}
  }
    
    private static void print_sort(int arr[],int n)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int arr[]={5,7,20,10};
		int n=arr.length;
		System.out.print("Before sorting: ");
		print_sort(arr, n);
		selectionSort2(arr,n);
		System.out.print("After sorting: ");
		print_sort(arr, n);
	}

}
