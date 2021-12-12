'''
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

    1 <= numRows <= 30
'''


class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        result = [[1]]
        for i in range(1,numRows):
            result += [list(map(lambda x,y: x+y, result[-1] + [0], [0] + result[-1]))]
        return result[:numRows]


''' 
Success
Details
Runtime: 28 ms, faster than 86.50% of Python3 online submissions for Pascal's Triangle.
Memory Usage: 14.4 MB, less than 25.06% of Python3 online submissions for Pascal's Triangle.
Next challenges:
Pascal's Triangle II
Show off your acceptance:
Time Submitted
	
Status
	
Runtime
	
Memory
	
Language
12/11/2021 19:50	Accepted	28 ms	14.4 MB	python3
'''
