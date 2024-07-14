# 내일 풀 수학 문제의 개수는 오늘 푼 문제 개수의 수와 숫자의 구성이 같으면서, 
# 오늘 푼 문제 개수의 수보다 큰 수 중 가장 작은 수입니다.
# 오늘 푼 문제의 개수를 줬을 때 다음날 풀 문제의 개수를 출력하는 프로그램을 작성하세요.

n = int(input())
x = list(str(n)) 

for i in range(len(x) - 1, 0, -1):
    if x[i] > x[i - 1]:
        for j in range(len(x) - 1, i - 1, -1):
            if x[j] > x[i - 1]:
                x[i - 1], x[j] = x[j], x[i - 1]
                break
        x = x[:i] + sorted(x[i:])
        break

print(''.join(x))