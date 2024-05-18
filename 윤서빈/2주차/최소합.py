# 11399번 ATM문제

a = int(input())
b = list(map(int, input().split()))

b = sorted(b)

result = 0
temp = 0

for i in range(a):
    result += (b[i] + temp)
    temp += b[i]

print(result)