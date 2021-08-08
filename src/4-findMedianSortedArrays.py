class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        def median_num(nums: list[int]) -> int:
            len_num = len(nums)
            if len_num % 2 == 0:
                return (nums[int(len_num/2)-1] + nums[int(len_num/2)])/2
            else:
                return nums[int(len_num/2)]

        if nums1 == []:
            return median_num(nums2)
        elif nums2 == []:
            return median_num(nums1)

        index_1, index_2 = 0, 0
        len_1, len_2 = len(nums1), len(nums2)
        nums3 = list()
        
        while(index_1 < len_1 and index_2 < len_2):
            if nums1[index_1] <= nums2[index_2]:
                nums3.append(nums1[index_1])
                index_1 += 1
            elif nums1[index_1] > nums2[index_2]:
                nums3.append(nums2[index_2])
                index_2 += 1
        
        if index_1 == len_1:
            for i in range(index_2, len_2):
                nums3.append(nums2[i])
        elif index_2 == len_2:
            for i in range(index_1, len_1):
                nums3.append(nums1[i])

        return median_num(nums3)