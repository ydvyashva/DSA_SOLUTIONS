class Solution(object):
    def rankTeams(self, votes):
        """
        :type votes: List[str]
        :rtype: str
        """
        n = len(votes[0])
        count = {team: [0] * n for team in votes[0]}
        for vote in votes:
            for pos, team in enumerate(vote):
                count[team][pos] += 1
        teams = list(votes[0])
        teams.sort(key=lambda team: ([-c for c in count[team]], team))
        
        return "".join(teams)