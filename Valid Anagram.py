

test1 = {
    'a': 0,
    'b': 2,
    'c': 1
}
# keys, values = zip(test1.items())
# keys, values = zip(*test1.items())
for letter in test1:
    if 'c' in test1:
        print(False)
print(sum(test1.values()))
for v in iter(test1.values()):
    print(v)

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        res = {}
        for letter in s:
            res[letter] = 1 + res.get(letter, 0)
        for letter in t:
            if letter not in res:
                return False
            else:
                res[letter] -= 1
        # print(res)
        # return not bool(sum(res.values()))
        # return True if sum(res.values()) == 0 else False
        return not any(v > 0 for v in iter(res.values()))
            

s = Solution()
print(s.isAnagram('apple','eppla'))     # True
print(s.isAnagram('aacc','ccac'))       # False
print(s.isAnagram('asd','dsa'))         # True
print(s.isAnagram('aaaaaa','aaaaab'))   # False