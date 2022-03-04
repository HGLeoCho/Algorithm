package com.company;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        TwoSum t1 = new TwoSum();
////        int[] result = t1.quadraticSolution(new int[] {3,2,4}, 6);
////        int[] result = t1.hashmapSolution(new int[] {3,2,4}, 6);
//        int[] result = t1.twoPointerSolution(new int[] {3,3}, 6);
//        System.out.println(result[0] + " " + result[1]);

//        TwoSumII t2 = new TwoSumII();
//        int[] result = t2.twoSum(new int[] {-2,0,2}, -2);
//        System.out.println("result is : [ " + result[0] + ", " + result[1] + " ]");



        /*
        BestTimeToBuyAndSellStock
         */
//        BestTimeToBuyAndSellStock stock1 = new BestTimeToBuyAndSellStock();
//        System.out.println(stock1.twoPointerSolution(new int[] {2,1,2,1,0,1,2}));               // 2
//        System.out.println(stock1.twoPointerSolution(new int[] {2,4,1}));               // 2
//        System.out.println(stock1.twoPointerSolution(new int[] {2,1,2,0,1}));           // 1

        /*
        ContainsDuplicate
         */

//        ContainsDuplicate cd = new ContainsDuplicate();
//        System.out.println(cd.hashmapSolution(new int[] {1,1,1,3,3,4,3,2,4,2}));
//        System.out.println(cd.hashsetSolution(new int[] {1,1,1,3,3,4,3,2,4,2}));


        /*
        Product of Array Except Self
         */
        ProductofArrayExceptSelf pr = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(pr.solution(new int[] {1,2,3,4})));
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

class BestTimeToBuyAndSellStock {

    public static int twoPointerSolution(int[] prices){

        int l = 0;
        int r = 1;
        int max_profit = 0;

        while(r < prices.length){
            if (max_profit < (prices[r] - prices[l])) {
                max_profit = Math.max(max_profit, prices[r] - prices[l]);
            } else if(((prices[r] - prices[l]) < 0)){
                l = r;
            }
            r++;
        }
        return max_profit;
    }

}

class ContainsDuplicate {
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true



Constraints:
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
 */
    // HashMap Solution. uses less memory than HashSet solution (6 ms	54.6 MB)
    public static boolean hashmapSolution(int[] nums){
        Map<Integer, Integer> numCounter = new HashMap<>();

        for (int i = 0; i<nums.length; i++){
            if (numCounter.containsKey(nums[i])){
                return true;
            } else {
                numCounter.put(nums[i],0);
            }
        }
        return false;
    }

    // HashSet method O(n), O(n) (9 ms	68.7 MB)
    public static boolean hashsetSolution(int[] nums){
        final HashSet <Integer> sets = new HashSet<>(); // good programming practice to put final. final means we don't want distinct point to another Set instance. But the content of distinct can be modified.
        for (int num : nums){
            if (!sets.add(num)){      // HashSet.add() returns true is there is a duplicated value !
                return true;
            }
        }
        return false;
    }

    // sort method O(n log n), O(1) (26 ms	71.3 MB)
    public static boolean sortSolution(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                return true;
            }
        }
        return false;
    }
}


class ProductofArrayExceptSelf{
    public static int[] solution(int[] nums){
        /*
       1 [1,2,3,4] 1
         [1,1,2,6]
        [24,12,4,1]

        [24,12,8,6]
        explaination: lets pick 2 in the list. in order to set product of all numbers except 2 you need to get product of all numbers on left side of 2
        and product of all numbers on right side of 2. in this case it will be shown as this
        left side : (1) * 1
        right side : 3 * 4 * (1)
        pranthesis 1 is inserted in order to prevent left/right most number to become 0
        so to make the solution o(n) in time complexity, we get product from left side first and right later. which makes it O(n + n) or O(2n)
        constants really do not count in terms of Big O notation, so we can say its O(N) complexity
         */
        int[] result = new int[nums.length];
        //product of left side
        for (int i = 0, k = 1; i < nums.length; i++){
            result[i] = k;
                    k *= nums[i];
        }
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(nums));
        //product of right side
        for (int i = nums.length - 1, k = 1; i >= 0; i--){
            result[i] *= k;
            k *= nums[i];
        }
        System.out.println(Arrays.toString(result));

        return result;
    }
}