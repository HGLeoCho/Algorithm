'''
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

 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
'''



class Solution:
    def maxSubArray(self, nums: list[int]) -> int:  
        maxSub = nums[0]
        curSum = 0

        for n in nums:
            if curSum < 0:
                curSum = 0
            curSum += n
            maxSub = max(maxSub, curSum) 
        return maxSub



s = Solution()
print(s.maxSubArray([5,4,-1,7,8]))              # 23
print(s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))   # 6
print(s.maxSubArray([1]))                       # 1
print(s.maxSubArray([4,-19,50,-4,5,-42]))       # 36