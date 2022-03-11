package com.company;

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
//        ProductofArrayExceptSelf pr = new ProductofArrayExceptSelf();
//        System.out.println(Arrays.toString(pr.solution(new int[] {1,2,3,4})));

        /* Maximum Subarray */
//        MaximumSubarray ms = new MaximumSubarray();
//        System.out.println(ms.solution3(new int[] {5,4,-1,7,8}));       // 23
//        System.out.println(ms.solution3(new int[] {-2,1,-3,4,-1,2,1,-5,4}));        // 6
//        System.out.println(ms.solution3(new int[] {-2,1}));         // 1
//        System.out.println(ms.solution3(new int[] {1,2}));          // 3
//        System.out.println(ms.solution3(new int[] {-2,-1}));        // -1

        /* Maximum Product Subarray */
//        MaximumProductSubarray MPS = new MaximumProductSubarray();
//        System.out.println(MPS.solution2(new int[] {2,3,-2,4}));        // 6
//        System.out.println(MPS.solution2(new int[] {-2,0,-1}));         // 0
//        System.out.println(MPS.solution2(new int[] {-2,-2,0,-1,-5}));       // 5
//        System.out.println(MPS.solution2(new int[] {-2,0,-4,-3,0,-3,7}));   // 12
        /* Find Minimum in Roated Sorted Array */
        FindMinimuminRoatedSortedArray FMRSA = new FindMinimuminRoatedSortedArray();
//        System.out.println(FMRSA.solution1(new int[] {3,4,5,1,2}));         // 1
        System.out.println(FMRSA.solution1(new int[] {2,3,1}));     // 0
        System.out.println(FMRSA.solution1(new int[] {11,13,15,17}));       // 11
        System.out.println(FMRSA.solution1(new int[] {2,0,1}));             // 0
        System.out.println(FMRSA.solution1(new int[] {0,1}));               // 0

//        System.out.println(FMRSA.recursion(new int[] {11,13,15,17}));

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
    public int[] solution(int[] nums){
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

class MaximumSubarray{
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.


    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Example 2:
    Input: nums = [1]
    Output: 1

    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23

    Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

     */

    // quadratic solution. TIME LIMIT EXCEEDED. O(N^2)
    protected int solution1(int[] nums){
        int max = Integer.MIN_VALUE;
        int temp;
        for(int i = 0; i < nums.length; i++){
            temp = 0;
            for(int k = i; k < nums.length; k++){
                temp += nums[k];
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    // 5,4,-1,7,8
    public int solution2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n]; //dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;

    }

    // non DP solution
    public int solution3(int[] nums){
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum < 0 ? nums[i] : nums[i] + sum);
            max = Math.max(max, sum);
        }
        return max;

    }
}

class MaximumProductSubarray{
    /*
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.


Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,-2,0,-1,-5]
Output: 5

Example 3:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
    1 <= nums.length <= 2 * 104
    -10 <= nums[i] <= 10
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     */

    //-2,-2,0,-1,-5
    // 1,-2,3
    // 1,-2,3,-4
    public int solution1(int[] nums){
        int sum = 1;
        int sum_until = 0;
        int temp_negative = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            if ( nums[i] == 0){
                sum_until = sum;
                sum = 1;
                continue;
            }
            if ( nums[i] < 0 && sum_until > 1 && temp_negative < 0){
                sum = sum - (sum_until * temp_negative);
                sum = sum_until * temp_negative * sum * nums[i];
                sum_until = 0;
                temp_negative = 0;
                continue;
            }
            sum *= nums[i];
            max = Math.max(max, sum);

            if ( nums[i] < 0) {
                sum_until = sum;
                temp_negative = nums[i];
            }

        }
        return max;
    }


    /*
    you find max product from left side then find max product from right side.

    there only 2 things to consider in the question
    - 0 values in the array
    - odd number of negative value

    for 0 values in the array
    -> we can easily solve this issue by setting current sum back to 1 when there is 0
    if (sum == 0) sum = 1;

    for odd number of negative values
    -> when there is odd number of negative value, it is just matter of comparison between left side and right side.

    example)
    [2,3,-1,2,4] -> 2 * 3 vs 2 * 4

    */
    public int solution2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 1;

        for (int i = 0; i < nums.length; i++){
            sum *= nums[i];
            max = Math.max(sum, max);
            if (sum == 0) sum = 1;
        }
        sum = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            sum *= nums[i];
            max = Math.max(sum, max);
            if (sum == 0) sum = 1;
        }

        return max;
    }


    /*
    similar thinking as above. however, in this solution we iterate only once and make the process time even faster
    Also, instead of thinking about right side this time we consider other side by remembering Minimum value.
     */
    public int solution3(int[] nums){
        int n = nums.length;
        if (n == 0) {
            throw new IllegalArgumentException();
        }

        int curMax = nums[0];
        int curMin = nums[0];
        int ans = curMax;

        for (int i = 1; i < n; i++) {
            int tmp = curMax;
            curMax = Math.max(tmp*nums[i], Math.max(curMin*nums[i], nums[i]));
            curMin = Math.min(tmp*nums[i], Math.min(curMin*nums[i], nums[i]));

            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}

class FindMinimuminRoatedSortedArray{

    public int solution1(int[] nums){
        //3,4,5,1,2

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);


        int l = 0;
        int r = nums.length - 1;
        int m;

        while(r > l){

            m = (r + l) / 2;

            if (l == m) return nums[r];
            else if (nums[r] < nums[m]) l = m;
            else if (nums[l] < nums[m]) r = m;
            else return nums[m];
        }
        return Integer.MIN_VALUE;
    }

    public int recursion(int[] arr){
        System.out.println("received arr is : " + Arrays.toString(arr));
        if (arr.length <= 2) return 2;
        if (arr.length > 2){
            int m = arr.length/2;
            int[] new_nums = Arrays.copyOfRange(arr, 0, m);
            System.out.println("new num set to : " + Arrays.toString(new_nums));
            recursion(new_nums);
        }
        return arr[1];
    }

}