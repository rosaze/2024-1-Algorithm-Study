
n=int(input())
v=int(input())
graph=[[] for i in range(n+1)] #인덱스: 컴퓨터 번호 원소: 연결된 컴퓨터 번호(들)
visited=[0]*(n+1) #n+1개만큼의 unvisited 리스트 생성. 1번 컴퓨터를 1번 인덱스를 스기 위해 1개 더 추가한 것이다. 
for i in range(v):
    a,b=map(int,input().split())
    graph[a]+=[b]
    graph[b]+=[a] #양방향으로 연결

"""
# BFS
from collections import deque
visited[1]=1 #1번 컴퓨터부터 시작=> 루프 밖에서 방문 표시. 이 코드 지워도 작동함
arr=deque([1]) #첫 번째 컴퓨터에 대한 덱
while arr:
    current=arr.popleft()
    for next in graph[c]:
        if visited[next]==0:
            arr.append(next)
            visited[next]=1
print(sum(visited)-1) #1번 컴퓨터를 제외하고 출력해준다. 
"""
#DFS

def dfs(v):
    visited[v]=1
    for next in graph[v]:
        if visited[next]==0:
            dfs(next)
dfs(1)
print(sum(visited)-1)
