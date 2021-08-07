class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        length = len(nums)

        def _next(index: int) -> int:
            return (index + nums[index]) % length

        def check(start: int) -> bool:
            left, right = start, _next(start)
            cyc_cnt = 0
            while(nums[left]*nums[start] > 0 and nums[left]*nums[right] > 0):
                cyc_cnt += 1
                left = _next(left)
                temp = _next(right)
                if nums[temp]*nums[start] < 0:
                    return False
                right = _next(temp)
                # 判断循环是否为1的部分
                if left == right:
                    return True if left != _next(left) else False
                if cyc_cnt > length:
                    return False
            return False

        for i in range(len(nums)):
            if check(i):
                return True
        return False