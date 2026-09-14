from collections import Counter
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        count = Counter(nums)
        buck = [[] for _ in range(len(nums)+ 1)]
        for num , freq in count.items():
            buck[freq].append(num)
        res =[]
        for i in range(len(buck)-1,0,-1):
            for num in buck[i]:
                res.append(num)
                if len(res)==k:
                    return res
           

        