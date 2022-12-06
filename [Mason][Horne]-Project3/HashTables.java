

import java.util.*;

public class HashTables {
        //creating a hashset and iterating through it and adding nums to the hash set
        //creating another for loop and assigning x to nums at i if the set contains target - x then return given set
        //otherwise return null
        public static int[] findSumPair(int[] nums, int target) {
            HashSet<Integer> set = new HashSet<>();
            for(int i =0; i<nums.length;i++) {
                set.add(nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];

                if (set.contains(target - x)) {
                    return new int[]{(target - x), x};
                }
            }
            return null;
        }
        //hashset iterating through the array with a for reach and adding the elements and returning the size of the abs value elements
        public static int DistinctValues(int[] array){
            Set<Integer> set = new HashSet<>();
            for (int i : array) {
                set.add(Math.abs(i));
            }
            return set.size();
        }
        public static void main(String[] args) {
        }
    }