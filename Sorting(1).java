import java.util.*;
public class Sorting {
    //O(n^2)
    public static void my_sort(int[] array) {
        //O(n^2) since it is N^2 * 4 + 1, and we ignore constants, so it's N^2
        int temp = 0; //assigning temp to equal 0  //BO: 1
        for(int i = 0; i<array.length;i++){ //64238 //BO: N
            for(int j = i+1; j<array.length;j++){ //BO: N //increasing by 1 because we are comparing 6 with each number incrementally
                if(array[i]<array[j]){ //if 6 < 4 // N^2 * 1 + 1
                    temp = array[i]; //swaps //temp = x | throwing x into temp // N^2 * 2 + 1
                    array[i] = array[j]; //x=y | throwing y into the empty x // N^2 * 3 + 1
                    array[j] = temp; //y = temp | throwing temp into the // N^2 * 4 + 1
                    //Comparing 6 with 4 then 6 with 2 then 6 with 3 then 6 with 8 then swapping
                }
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {5, 10, 12, 14, 8, 3, 2, 1};
        my_sort(a);
        System.out.println(Arrays.toString(a));
    }
}
