 
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
    if not num:
        return num
    result = ''
    copy_num = num
    while copy_num:
        if copy_num == 1:
            result += ('1')
            copy_num = 0
        elif copy_num%2 == 1:
            result += ('1')
            copy_num //= 2
        else:
            result += ('0')
            copy_num //= 2
    return result[::-1]
print(my_bin(16))

# binary conversion I found on stack overflow
# problem is 0 is not represented as 0
def decimalToBinary(value):
    if value < 0:  # Base case if number is a negative
        return 'Not positive'
    elif value == 0:  # Base case if number is zero
        return ''
    else:
        return decimalToBinary(value // 2) + str(value % 2)

class Solution:
    def countBits(self, n: int) -> list[int]:
        result = [0]
        total = n
        if n == 0:
            return result
        for i in range(n):
            temp_bits = '0'
            if not total == 0:
                total -= 1
                if temp_bits[:-1] == 1:
                    temp_bits.append('0')
                else:
                    temp_bits[:-1] = '1'
