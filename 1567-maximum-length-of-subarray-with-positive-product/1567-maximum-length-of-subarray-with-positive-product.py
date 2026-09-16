class Solution(object):
    def getMaxLen(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        pos = 0
        neg = 0
        max_len= 0

        for i in nums:
            if i>0:
                pos = pos+1
                if neg > 0:
                    neg += 1
                else:
                    neg = 0
            elif i<0:
                if neg > 0:
                    npos = neg + 1
                else:
                    npos = 0
                nneg = pos + 1
                pos, neg = npos, nneg
            else:
                pos = 0 
                neg = 0
            max_len = max(max_len, pos)
        return max_len                
        