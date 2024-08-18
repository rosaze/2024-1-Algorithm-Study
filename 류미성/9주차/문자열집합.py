import sys

n, m  = map(int, sys.stdin.readline().split())

s = []
count = 0

for _ in range(n):
  word = sys.stdin.readline().strip()
  s.append (word)

for _ in range (m):
  check = input().strip()
  if check in s:
    count += 1

print(count)