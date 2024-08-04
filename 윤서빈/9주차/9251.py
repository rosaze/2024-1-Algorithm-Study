first = input()
second = input()

f = len(first)
s = len(second)
dp = [[0]*(f+1) for _ in range(s+1)]

for i in range(1, s+1):
    for j in range(1, f+1):
        if first[j-1] == second[i-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            
print(dp[s][f])

#빨간색은 같은 알파벳위치에 있으면 [i-1][j-1]에서 +1을 해준다.
#파란색은 왼쪽과 위쪽의 숫자를 비교해서 큰 값으로 설정해준다.