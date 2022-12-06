import java.util.Arrays;

public class Matrix {
    //O(n) worst occurs when the while loop runs 2n times 1 + 1 + 1 = 3 T(n) = 3 * 2n+2
    public static boolean MatrixFind(int[][] matrix, int key, int rows){
       int i = 0;
       int j = rows - 1;
       while(i<rows&&j>=0){
           if(matrix[i][j]==key){
               return true;
           }
           if(matrix[i][j]<key){
               j--;
           }
           else {
               i++;
           }
       }
       return false;
    }
    public static void main(String[] args) {
        int matrix1[][] = { { 16, 15, 14, 13 },
                            { 12, 11, 10, 9 },
                            { 8, 7, 6, 5 },
                            { 4, 3, 2, 1 } };
        System.out.println(Arrays.toString(new boolean[]{MatrixFind(matrix1, 17, 4)}));

        int matrix2[][] = { { 60, 35, 10, 3 },
                            { 20, 16, 8, 1 },
                            { 18, 12, 3, -3 },
                            { 14, 3, -2, -9 } };
        System.out.println(Arrays.toString(new boolean[]{MatrixFind(matrix2, 16, 4)}));
    }
}
