import java.util.Arrays;

class Quicksort {
    //calling quicksort helper
    public void my_quicksort(int[] array){
        quicksort_helper(array, 0, array.length-1);
    }

    // method to partition and swap the values input array left and
    public static int partition(int arr[], int low, int high){
        int pivot = arr[low];
        int i = low;
        for(int j = low + 1; j <= high; j++){
            if (arr[j] > pivot){
                i = i + 1;
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;

        return i;

    }
    //calling partition and calling and using partitioning on array recursion
    public static void quicksort_helper(int arr[], int low, int high){
        if(low  < high)
        {
            int q = partition(arr, low, high);
            quicksort_helper(arr, low, q);
            quicksort_helper(arr, q + 1, high);
        }
    }
}

// Main class
class Main {
    public static void main(String args[]) {

        int[] array = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(array));

        int size = array.length;

        // call quicksort() on array data
        Quicksort.quicksort_helper(array, 0, size - 1);

        System.out.println("Sorted in Descending Order ");
        System.out.println(Arrays.toString(array));
    }
}