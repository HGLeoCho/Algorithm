'''
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 

Constraints:

    1 <= nums.length <= 2 * 104
    -10 <= nums[i] <= 10
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

'''


class Solution:
    def maxProduct(self, nums: list[int]) -> int:
        if len(nums) < 2:
            return nums[0]

        output = 0
        temp_output = 1
        
        for n in nums:
            if temp_output < 0:
                temp_output = 1
            temp_output *= n
            output = max(output, temp_output)
        return output

s = Solution()
print(s.maxProduct([2,3,-2,4]))         # 6
print(s.maxProduct([-2,0,-1]))          # 0
print(s.maxProduct([-3,-1,-1]))         # 3

