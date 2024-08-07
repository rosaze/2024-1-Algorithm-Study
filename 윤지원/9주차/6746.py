"""
백준 6746

문제의 요지는 Happy Worm(행복한 벌레)이 m x n 크기의 직사각형 필드에서
잠을 잘 수 있는 위치의 수를 구하는 것입니다.
필드에는 k개의 돌이 특정 위치에 놓여 있습니다.
필드의 각 칸은 비어 있거나 돌을 포함하고 있습니다.
벌레가 잠을 잘 때는 가로 또는 세로로 누워서 가능한 한 길게 뻗습니다. (중요)
벌레는 돌이 있는 칸이나 필드 밖으로 갈 수 없으며,
벌레의 길이는 최소 2칸 이상이어야 합니다.
"""

t = int(input())

results = []

for _ in range(t):
    m, n, k = map(int, input().split())
    shell = [[0] * n for _ in range(m)]
    
    for _ in range(k):
        r, c = map(int, input().split())
        shell[r-1][c-1] = 1
    
    def count_positions():
        count = 0
        # 가로로 누울 수 있는 위치 계산
        for i in range(m):#가로
            length = 0
            for j in range(n): #세로
                if shell[i][j] == 0: # 돌없으면 길이 재기
                    length += 1
                else:# 돌-> 전 길이 재기
                    if length >= 2:
                        count += 1
                    length = 0# else 뿐 만 아니라 항상 초기화( 끝이 돌일수도)  
            if length >= 2:
                count += 1
        
        # 세로로 누울 수 있는 위치 계산
        for j in range(n):
            length = 0
            for i in range(m):
                if shell[i][j] == 0:
                    length += 1
                else:
                    if length >= 2:
                        count += 1
                    length = 0
            if length >= 2:
                count += 1
        
        return count
    
    results.append(count_positions())

for result in results:
    print(result)
