'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.



Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true
[[]]


Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
'''


class Solution:
    def isValid(self, s: str) -> bool:
        dick = {
            '[': 1, ']': 9,
            '{': 2, '}': 8,
            '(': 3, ')': 7
        }
        exclude_index = []
        if dick[s[0]] > 5:
            return False
        else:
            for i in range(len(s)):
                for j in range(i+1,len(s),2):
                    if dick[s[i]] + dick[s[j]] == 10 and j not in exclude_index:
                        exclude_index.extend([j,i])
            for i in range(len(s)):
                

s = Solution()
print(s.isValid())
