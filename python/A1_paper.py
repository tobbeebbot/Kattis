# Kattis: https://open.kattis.com/problems/a1paper
# 

import sys
import math

def main():
    n = int(sys.stdin.readline())
    amts = list(map(int, sys.stdin.readline().split()))
    
    def cost(i):
        A2_len = math.pow(2, -3/4)
        A3_len = math.pow(2, -5/4)
        ret = 0
        if i % 2 == 0:
            ret = A2_len / (i / 2)
        else:
            ret = A3_len / (i // 2)

        #print(f'cost of {i} = {ret}')
        return ret


    #Params: n = smallest An, amts = nr of each kind, i = iteration depth..
    #Returns distance or None
    def calculate(n, i):
        if i > n:
            return math.nan

        if amts[i-2] >= 2:
            amts[i-2] -= 2
            return cost(i)

        elif amts[i-2] == 1:
            amts[i-2] -= 1
            return cost(i) + calculate(n, i + 1)

        else:
            return cost(i) + calculate(n, i + 1) + calculate(n, i + 1)
    
    y = calculate(n, 2)
    if math.isnan(y):
        print('impossible')
    else:
        print(y)



if __name__ == "__main__":
    main()