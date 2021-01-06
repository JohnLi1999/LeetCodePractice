'''
https://leetcode.com/problems/wildcard-matching/
    Time complexity:
        O(min(S,P)) for the best case
        O(2^min(S,P/2)) for the worst case
        where S and P are lengths of the input string and the pattern correspondingly.
        The best case is quite obvious, let's estimate the worst case.
        The most time consuming is the situation where recursion forms the tree on
        the star character in the pattern. In this situation, 2 branches are executed:
        helper(s, p[1:]) and helper(s[1:], p).
        The maximum number of stars in the pattern after data cleanup is P/2 and
        hence the time complexity is O(2^min(S,P/2)).
    Space complexity: O(2^min(S,P/2))
        To keep the memoization hashmap and the recursion stack.
'''
class Solution:
    def remove_duplicate_stars(self, p):
        if p == '':
            return p
        p1 = [p[0],]
        for x in p[1:]:
            if p1[-1] != '*' or p1[-1] == '*' and x != '*':
                p1.append(x)
        return ''.join(p1)

    def helper(self, s, p):
        dp = self.dp
        if (s, p) in dp:
            return dp[(s, p)]

        if p == s or p == '*':
            dp[(s, p)] = True
        elif p == '' or s == '':
            dp[(s, p)] = False
        elif p[0] == s[0] or p[0] == '?':
            dp[(s, p)] = self.helper(s[1:], p[1:])
        elif p[0] == '*':
            dp[(s, p)] = self.helper(s, p[1:]) or self.helper(s[1:], p)
        else:
            dp[(s, p)] = False

        return dp[(s, p)]

    def isMatch(self, s, p):
        p = self.remove_duplicate_stars(p)
        # memoization hashmap to be used during the recursion
        self.dp = {}
        return self.helper(s, p)