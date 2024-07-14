"""
백준 11724번 연결 요소의 개수

연결 요소란? 그래프의 부분 그래프들 중 모든 노드가 서로 연결되어 있지만, 다른 부분 그래프들과는 연결되어 있지 않은 그룹.
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.
"""


n,m=map(int,input().split())
visited = [False] * (n+1)
graph=[[] for _ in range(n+1)]

for i in range(m):
    a,b=map(int,input().split())
    graph[a]+=[b]
    graph[b]+=[a] #무방향 그래프


#재귀로 구현한 DFS  
def dfs(v):
    visited[v]=1
    for next in graph[v]:
        if visited[next]==0:
            dfs(next)


#연결 요소 새는 역할. 방문하지 않은 노드-> DFS           
count = 0
for i in range(1,n+1):
    if not visited[i]:
        dfs(i)
        count+=1
#dfs가 완료되면 하나의 연결 요소에 속하는 모든 노드가 방문됐음을 표시
#새로운 연결 요소를 발견했으므로, count+=1
print(count)
