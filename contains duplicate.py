class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:
        nums.sort()
        for i in range(len(nums)-1):
            if nums[i] == nums[i + 1]:
                return True
        return False





class Solution1:
    def containsDuplicate(self, nums: list[int]) -> bool:
        hashmap = {}
        for num in nums:
            hashmap[num] = 1 + hashmap.get(num, 0)
            # hashmap[nums[i]] += hashmap.get(nums[i], 0)
            if hashmap[num] > 1:
                return True
        return False



# from leetcode discuss
# very pythonic

list1 = [1,4,6,1,23,4]
print(set(list1))           # {1, 4, 6, 23}

class Solution2:
    def containsDuplicate(self, nums: list[int]) -> bool:
        return len(nums) > len(set(nums))




s = Solution1()
print(s.containsDuplicate([1,2,3,4,5,6,1]))         # True
print(s.containsDuplicate([1,63,45,66,7,11]))       # False
print(s.containsDuplicate([7,5,3,1,7,1]))           # True
print(s.containsDuplicate([1]))                     # False
