 
'''
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101


Constraints:
    0 <= n <= 105


Follow up:
    It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
    Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
'''

# my creation for decimal to binary
def my_bin(num):
    if num < 0:
        return 'Not positive'
    elif num == 0:
        return '0'
    elif num == 1:
        return '1'
    else:
        return my_bin(num // 2) + str(num % 2)

class Solution:
    def countBits(self, n: int) -> list[int]:
        result = [0]
        if n == 0:
            return result
        for i in range(1, n + 1):
            result.append(my_bin(i).count('1'))
        return result


p = Solution()
print(p.countBits(5))  # [0,1,1,2,1,2]
print(p.countBits(0))  # [0]
print(p.countBits(10))  # [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2]
                  
'''
Runtime: 408 ms, faster than 5.03% of Python3 online submissions for Counting Bits.
Memory Usage: 21 MB, less than 36.06% of Python3 online submissions for Counting Bits.
'''
