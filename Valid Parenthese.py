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
                if dick[s[i]] < 5:
                    for j in range(i + 1, len(s), 2):
                        if dick[s[i]] + dick[s[j]] == 10 and j not in exclude_index:
                            print(i, j, dick[s[i]], dick[s[j]])
                            exclude_index.extend([j, i])
                            break
            for i in range(len(s)):
                if i not in exclude_index:
                    return False
            return True


s = Solution()
print(s.isValid('[][]'))
print(s.isValid('[({])}'))
print(s.isValid('(){}}{'))
print(s.isValid('()[]{}'))
print(s.isValid('[{()}]'))

class Solution1:
    def isValid(self, s: str) -> bool:
        result = []
        dick = {']': '[', '}': '{', ')': '('}
        for v in s:
            if v in dick:
                if result and result[-1] == dick[v]:
                    result.pop()
                else:
                    return False
            else:
                result.append(v)
        return True if not result else False

s = Solution1()
print(s.isValid('[][]'))
print(s.isValid('[({])}'))
print(s.isValid('([][][][]{{}})'))
print(s.isValid('(){}}{'))
print(s.isValid('()[]{}'))
print(s.isValid('[{()}]'))
    
'''
Success
Details
Runtime: 32 ms, faster than 69.30% of Python3 online submissions for Valid Parentheses.
Memory Usage: 14 MB, less than 96.64% of Python3 online submissions for Valid Parentheses.
'''
