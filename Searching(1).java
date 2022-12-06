public class Searching {
    //O(log(n))
    public static int fastSearch(int array[], int key) {
        //log(n)+3 ignore constants so Olog(n)
        int low = 0, high = array.length - 1;
        while (low <= high) { // value is split in a while so BO: log(n)
            int mid = low + (high - 1) / 2;
            //check if x is present at mid
            if (array[mid] == key) { // BO: log(n) + 1
                return mid;
            }
            //check right half if x is greater
            if (array[mid] < key) { // BO: log(n) + 2
                low = mid + 1;
            }
            //check left half if x is smaller
            else {
                high = mid - 1; // BO: log(n) + 3
            }
        }
        //means not present
        return -1;
    }
        public static void main(String args[]) {
            Searching task = new Searching();
            int array[] = {7, 4, 29, 25, 26, 58, 39, 42};
            int key = 42;
            int solution = task.fastSearch(array, key);
            if(solution == -1) {
                System.out.println("Key not in any index in this array.");
            }
            else {
                System.out.println("Element found at " + "index " + solution);
            }
        }
    }
