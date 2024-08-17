import sys
from collections import deque

input=sys.stdin.readline
sys.setrecursionlimit(10**6)

def hanoi(n, end): #하노이탑 재귀 알고리즘 
    
    global res
    
    if n==0:
        return
    
    for i in range(3):
        if lst[i] and lst[i][0]==n:
            if i==end:
                lst[i].popleft()
                hanoi(n-1, end)
            else:
                if end!=0 and i!=0:
                    temp=0
                elif end!=1 and i!=1:
                    temp=1
                else:
                    temp=2
                
                lst[i].popleft()
                
                hanoi(n-1, temp)
                res=res+power_of_2[n-1]
                if res>=1000000:
                    res%=1000000
                return
                
res=0
n=int(input())
a,b,c=map(int,input().split())

power_of_2=[1]*(n+1) #2의 제곱을 반복문을 통해 미리 구하기
for i in range(1,n+1):
    power_of_2[i]=(power_of_2[i-1]*2)%1000000
    
lst=[]
for i in range(3):
    lst.append(deque(map(int,input().split())))

for i in range(3):
    if(lst[i] and lst[i][0]==n):
        lst[i].popleft()
        hanoi(n-1,i)
        print(i+1)
        print(res)

#제곱이 너무 크고 나머지를 구할 땐, 배열의 반복을 통해 빠르게 구할 수 있음
#-> 특히 호출이 많아서 자주 계산을 해야한다면 배열에 미리 저장해두고 꺼내쓰는 게 시간적으로 압도적으로 유리함

#하노이 탑의 풀이의 토대는 시작점, 경유점, 종착점 3가지다. 경유점은 때에 따라 여러개가 될 수도 있음