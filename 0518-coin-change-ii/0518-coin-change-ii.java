class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] will store the number of ways to make amount i
        int[] dp = new int[amount + 1];
        
        // Base case: There is 1 way to make amount 0 (using no coins)
        dp[0] = 1;
        
        // Process each coin one by one to avoid duplicate combinations
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}