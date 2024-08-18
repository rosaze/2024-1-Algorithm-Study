# solution 1
# 런타임 오류
count = int(input())
li = []
for i in range(count):
  [a, b] = map(input().split())
  li.append([a,b])
li.sort()
for i in li:
  print(i[0], i[1])


# solution 2
import sys #sys 라이브러리를 사용하여 input 시간 줄이기

count = int(sys.stdin.readline())
li = []
for i in range(count):
  [a, b] = map(int, sys.stdin.readline().split())
  li.append([a,b])
li.sort()
for i in li:
  print(i[0], i[1])