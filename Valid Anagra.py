'''
242. Valid Anagram
Easy

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

 

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

'''



# neetcode solution
# Time complexity O(n). (actually O(s + t) but constants really dont count in Big O notation
# Space complexity O(1)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        countS, countT = {}, {}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)
        for c in countS:
            if countS[c] != countT.get(c, 0):
                return False

        return True

# Sort and solve. not much efficient as above or below
# Time complexity O(n^2).
# Space complexity O(1)
class Solution1:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
       
# one liner. cool but not interview acceptable
class Solution2:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)
