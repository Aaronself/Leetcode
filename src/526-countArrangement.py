class Solution:
    def countArrangement(self, n: int) -> int:
        def backtrace(beautiful_list:list, choose_list:list):
            if len(beautiful_list) == n:
                nonlocal count
                count += 1
                return

            for i in range(1, len(choose_list)):
                # already chosed
                if choose_list[i] == 1:
                    continue
                
                if i % (len(beautiful_list)+1) == 0 or (len(beautiful_list)+1) % i == 0:
                    choose_list[i] = 1
                    beautiful_list.append(i)
                    backtrace(beautiful_list, choose_list)
                    choose_list[i] = 0
                    beautiful_list.pop()
                
        beautiful_list = list()
        choose_list = [0] * (n+1)
        count = 0
        backtrace(beautiful_list, choose_list)
        return count