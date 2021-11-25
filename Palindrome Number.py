'''
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.



Example 1:

Input: x = 121
Output: true

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Example 4:

Input: x = -101
Output: false



Constraints:

    -231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
'''

# initial solution with string

class Solution:
    def isPalindrome(self, x: int) -> bool:
        stringX = str(x)
        if len(stringX) < 2:
            return True
        else:
            for i in range(len(stringX)//2):
                if stringX[i] != stringX[-(i+1)]:
                    return False
            return True
'''
Accepted	97 ms	14.2 MB	python3
'''
     
# BEST solution with string
class Solution2:
    def isPalindrome(self, x: int) -> bool:
        if str(x)[::-1] == str(x):
            return True   

# my solution without string usage
class Solution3:
    def isPalindrome(self, x: int) -> bool:
        numbers = []
        keeplooping = True
        increment = 10
        if 0 <= x <= 9:
            return True
        elif x < 0 or (x % 10) == 0:
            return False
        else:
            numbers.append(x % increment) # first number
        while keeplooping:
            if increment > x:
                keeplooping = False
            else:
                numbers.append(int((x/increment) % 10))
                increment *= 10
        if numbers[::-1] == numbers:
            return True
        else:
            return False
'''
Accepted	68 ms	14.3 MB	python3
'''
p = Solution3()
print(p.isPalindrome(10022201))  
print(p.isPalindrome(0))
print(p.isPalindrome(2))
print(p.isPalindrome(31213))

# Best Solution without using string
class Solution4:
    
