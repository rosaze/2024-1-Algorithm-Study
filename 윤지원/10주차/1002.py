"""
문제:
두 원의 좌표와 반지름이 주어졌을 때,만나는 점의 개수를 출력하기
풀이:
두 원이 내접, 외접, 교접, 만나지않을때, 동일한 원일 때 총 4가지를 결정해줘야 함!

"""


import math

T=int(input())
for i in range(T):
    x1,y1,r1,x2,y2,r2=map(int,input().split())
    dist=math.sqrt((x1-x2)**2 +(y1-y2)**2)
    if dist==r1+r2 or dist==abs(r1-r2):
        ans=1
    elif dist>abs(r1-r2) and dist<r1+r2:
        ans=2
    elif dist>r1+r2 or dist<abs(r1-r2):
        ans=0
    else:
        ans=-1
    print(ans)
