class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0] )
        merged=[]
        for inter in intervals:
            if not merged or merged[-1][1]< inter[0]:
                merged.append(inter)
            else:
                merged[-1][1] = max(merged[-1][1], inter[1])    
        return merged            

        