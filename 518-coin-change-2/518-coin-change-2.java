class Solution {
    public int change(int target, int[] coins) {
        
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int coin: coins ){
            for(int amt = coin; amt <= target; amt++){
                  int remainingAmt = amt - coin;
                  dp[amt] += dp[remainingAmt];
            }
        }
        return dp[target];
    }
}