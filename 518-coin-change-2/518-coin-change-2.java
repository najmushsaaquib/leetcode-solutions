class Solution {
    public int change(int target, int[] coins) {
        
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        int n = coins.length;
        
        for(int coin = 0; coin<n; coin++ ){
            for(int amt = 1; amt <= target; amt++){
                
                if( coins[coin] <= amt ){
                    int remainingAmt = amt - coins[coin];
                    dp[amt] += dp[remainingAmt];
                    
                }
            }
            
        }
        
        return dp[target];
    }
}