class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        if len(p) > len(s):
            return []

        p_co = [0]*26
        s_co = [0]*26
        for i in range(len(p)):
            p_co[ord(p[i])- ord('a')] +=1
            s_co[ord(s[i])- ord('a')] += 1

        res = []
        if p_co == s_co:
            res.append(0)

        for i in range(len(p), len(s)):
            s_co[ord(s[i]) -  ord('a')] +=1
            s_co[ord(s[i - len(p)]) - ord('a')] -= 1
            if s_co== p_co:
                res.append(i - len(p) + 1)

        return res

        