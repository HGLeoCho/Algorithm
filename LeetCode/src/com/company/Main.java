package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        TwoSum t1 = new TwoSum();
////        int[] result = t1.quadraticSolution(new int[] {3,2,4}, 6);
////        int[] result = t1.hashmapSolution(new int[] {3,2,4}, 6);
//        int[] result = t1.twoPointerSolution(new int[] {3,3}, 6);
//        System.out.println(result[0] + " " + result[1]);

        TwoSumII t2 = new TwoSumII();
        int[] result = t2.twoSum(new int[] {-2,0,2}, -2);
        System.out.println("result is : [ " + result[0] + ", " + result[1] + " ]");
    }
}


class TwoSum{
    public static int[] quadraticSolution(int[] nums, int target) {
        System.out.println("function started");
        for(int i = 0; i < nums.length - 1; i++){
            for(int k = i + 1; k < nums.length; k++){
                if ((nums[i] + nums[k]) == target){
                    System.out.println("found answer: " + i + " " + k);
                    return new int[] {i, k};
                }
            }
        }
        System.out.println("nothing found");
        return new int[] {};

    }

    // 3ms
    public static int[] hashmapSolution(int[] nums, int target){
        System.out.println("function started");
        Map<Integer,Integer> map1 = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map1.containsKey(nums[i])){
                System.out.println("found answer: " + map1.get(nums[i]) + " " + i);
                return new int[] {map1.get(nums[i]),i};
            }
            map1.put((target - nums[i]), i);
        }
        System.out.println("nothing found");
        return new int[] {0, 0};
    }

    public static int[] twoPointerSolution(int[] nums, int target){
        // Just need to add how to find the index of the answer from original array("nums")
        int[][] temp_nums = new int[nums.length][2];
        for(int i = 0; i< nums.length; i++){
            temp_nums[i][0] = i;
            temp_nums[i][1] = nums[i];
        }
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;

        while(l <= r){
            if(target == (nums[l] + nums[r])){
                break;
            } else if(target < (nums[l] + nums[r])){
                r--;
            } else {
                l++;
            }
        }
        System.out.println(l + " " + r);

        int avoid_index = 0;
        for(int k = 0; k < nums.length; k++) {
            if (temp_nums[k][1] == nums[l]) {
                l = temp_nums[k][0];
                avoid_index = k;
                break;
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(temp_nums[k][1] == nums[r] && avoid_index != k){
                r = temp_nums[k][0];
                break;
            }
        }

        return (new int[] {l, r});
    }
}


class TwoSumII{
/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].



Constraints:

    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
 */
    // 2ms Solution. Time: O(n) Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, r = len - 1;
        while(l <= r){
            if(target == (numbers[l] + numbers[r])){
                return new int[] {l + 1, r + 1};
            } else if(target > (numbers[l] + numbers[r])){
                l++;
            } else{
                r--;
            }
        }
        return new int[] {1, 2};

    }
}