"""
문제
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

입력
첫째 줄에 행렬의 크기 N 과 M이 주어진다.
둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력
첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다.
행렬의 각 원소는 공백으로 구분한다.

중요>> 더한 결과값인 c행렬을 미리 지정하는 것이 중요. 2차원으로 미리 지정을 해야 2차원으로 저장됨
+ a,b,c 지정할때 for 문 중첩을 리스트 컴프리헨션으로 표현
"""


n,m=map(int,input().split())
a=[]
b=[]
c=[[0]*m for _ in range(n)]
a = [list(map(int, input().split())) for _ in range(n)]
b = [list(map(int, input().split())) for _ in range(n)]for i in range(n):

c=[[a[i][j]+b[i][j] for j in range(m)]for i in range(n)]

for i in range(n):
    for j in range(m):
        print("%d "%c[i][j],end="")
    print()

