import java.util.*;
public class Search {
    
    public static int binarySearch(int arr[], int key){
        int l=0, r=arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;        //exactly same as (l+r)/2 but better as (l+r) can go out of range 
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Length of Array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.print("Enter the Elements in Ascending Order : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the Element to Search : ");
        int key = sc.nextInt();

        if(binarySearch(arr, key)!=-1){
            System.out.println("Key at index : " + binarySearch(arr, key));
        }
        else{
            System.out.println("Key not present in the given Array");
        }


        sc.close();
    }
}
