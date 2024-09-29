# 구간 합 구하기 4

import sys
input = sys.stdin.readline

n,m = map(int,input().split())
num_list = list(map(int,input().split()))

for i in range(n-1):
    num_list[i+1] += num_list[i]
num_list = [0] + num_list

for _ in range(m):
    a,b = map(int,input().split())
    print(num_list[b]-num_list[a-1])

# 누적 합(prefix sum) 알고리즘을 활용