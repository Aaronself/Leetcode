class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        three_sum = 0
        min_length = 10001
        relt = 0

        nums.sort()
        print(nums)
        for i in range(len(nums)-2):
            j = i + 1
            k = len(nums)-1
            while(j < k):
                three_sum = nums[i]+nums[j]+nums[k]
                if abs(target - three_sum) < min_length:
                    min_length = abs(target - three_sum)
                    relt = three_sum
                if target - three_sum > 0:
                    j += 1
                else:
                    k -= 1
        
        return relt