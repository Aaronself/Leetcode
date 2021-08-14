class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        relt_list = list()
        
        nums.sort()
        for i in range(len(nums)-3):
            for j in range(i+1, len(nums)-2):
                k = j + 1
                l = len(nums)-1
                while(k < l):
                    list_sum = nums[i] + nums[j] + nums[k] + nums[l]
                    if list_sum == target:
                        if [nums[i], nums[j], nums[k], nums[l]] not in relt_list:
                            relt_list.append([nums[i], nums[j], nums[k], nums[l]])
                        k += 1
                        l -= 1
                        continue
                    elif list_sum > target:
                        l -= 1
                    elif list_sum < target:
                        k += 1
        return relt_list