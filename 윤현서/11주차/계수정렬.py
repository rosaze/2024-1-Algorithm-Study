'''
오름차순 정렬

(1번 시도 -> 메모리 초과)
n=int(input())
lst = []
for i in range(n):
    m = int(input())
    lst.append(m)
    
lst.sort()

for i in lst:
    print(i)
'''

# 2번 시도 - 계수 정렬
import sys
input = sys.stdin.readline

n = int(input())
lst = [0] * (10000 + 1)

# 각 입력값에 해당하는 인덱스의 값 +1
for _ in range(n):
    lst[int(input())] += 1

for i in range(len(lst)):
    if lst[i] != 0: #0이 아닌 데이터 출력
        for _ in range(lst[i]):
            print(i)