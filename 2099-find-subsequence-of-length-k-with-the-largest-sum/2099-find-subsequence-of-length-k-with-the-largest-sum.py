class Solution(object):
    def maxSubsequence(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        indexed_nums= [(num,i) for i,num in enumerate(nums)]
        top_k = sorted(indexed_nums, key=lambda x: x[0], reverse=True)[:k]
        tk = sorted(top_k, key=lambda x:x[1])
        return [num for num, i in tk]
        
        