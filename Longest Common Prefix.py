'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.



Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lower-case English letters.
'''
# my initial solution
class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        result = ''
        index = 0
        if strs[0] == "":
            return result
        if len(strs) == 1:
            return strs[0]
        for i in range(len(strs[0])):
            temp_string = strs[0][i]
            index = 0
            for j in range(1, len(strs)):
                try:
                    if strs[j][i] == temp_string:
                        index += 1
                        if index == len(strs)-1:
                            index = 0
                            result += temp_string
                    else:
                        return result
                except IndexError:
                    return result
        return result

s = Solution()
print(s.longestCommonPrefix(['flo','flow','flier'])) # fl
print(s.longestCommonPrefix([''])) # ''
print(s.longestCommonPrefix(['a'])) # a
print(s.longestCommonPrefix(['flo','f','floer'])) # f
print(s.longestCommonPrefix(['flo','','flier'])) # ''
print(s.longestCommonPrefix(['f','','flier'])) # ''


'''
Success
Details
Runtime: 32 ms, faster than 83.95% of Python3 online submissions for Longest Common Prefix.
Memory Usage: 14.3 MB, less than 56.89% of Python3 online submissions for Longest Common Prefix.
'''
