class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:    
        if len(nums) < 3:
            return 0

        dp = [0]*(len(nums)+1)
        dp[3] = 1
        for i in range(4, len(nums)+1):
            # 注意重复计算dp[i-2]
            dp[i] = dp[i-1] * 2 - dp[i-2] + 1
        
        d = nums[1] - nums[0]
        slice_len = 2
        relt = list()
        relt_num = 0
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == d:
                slice_len += 1
            else:
                relt.append(slice_len)
                d = nums[i] - nums[i-1]
                slice_len = 2
        relt.append(slice_len)
        for i in relt:
            relt_num += dp[i]
        return relt_num
