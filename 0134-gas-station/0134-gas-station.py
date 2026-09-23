class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        if sum(gas)<sum(cost):
            return -1
        sti = 0
        tt = 0
        for i in range(len(gas)):
            tt += gas[i] - cost[i]
            if tt<0:
                sti = i+1
                tt = 0
        return sti        

        