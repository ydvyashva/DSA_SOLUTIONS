class Solution:
    def shortestPalindrome(self, s: str) -> str:
        rev = s[::-1]

        # Combine string
        temp = s + "#" + rev

        # Build LPS array
        lps = [0] * len(temp)

        for i in range(1, len(temp)):
            j = lps[i - 1]

            while j > 0 and temp[i] != temp[j]:
                j = lps[j - 1]

            if temp[i] == temp[j]:
                j += 1

            lps[i] = j

        # Length of longest palindromic prefix
        longest_pal_prefix = lps[-1]

        # Remaining characters
        remaining = s[longest_pal_prefix:]

        # Add reverse of remaining in front
        return remaining[::-1] + s