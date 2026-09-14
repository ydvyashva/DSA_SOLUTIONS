class Solution(object):
    def isCircularSentence(self, sentence):
        """
        :type sentence: str
        :rtype: bool
        """
        words = sentence.split()

        for i in range(len(words)):
            if words[i-1][-1]!= words[i][0]:
                return False
        return True                


        