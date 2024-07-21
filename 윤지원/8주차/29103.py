"""
문제: 백준 29103번
Xn=Yn+Zn , Yn=Xn+Zn일때, n=k일때 x,y차이를 구하라

풀이: 알고리즘보다는 x,y간의 규칙을 파악하는 게 더 중요
k가 증가함에 따라 , 짝수일때는  초기 x,y값 그대로 차이가 유지되지만 홀수일때는 크기가 뒤바뀌어
차이가 음수가 됨 
"""


x,y,z,k=map(int,input().split())
res=x-y
if res==0:
    print(0)
else:
    if k%2==0:
        print(res)
    else:
        print(-res)
     
