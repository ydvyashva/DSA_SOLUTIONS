class Solution(object):
    def isCircularSentence(self, sentence):
        """
        :type sentence: str
        :rtype: bool
        """
        if sentence[0] != sentence[-1]:
            return False

        for i in range(len(sentence)):
            if sentence[i] == ' ':
                if sentence[i-1] != sentence[i+1]:
                    return False
        return True                


        